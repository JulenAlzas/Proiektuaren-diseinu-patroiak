package Adapter;

import java.util.Vector;

import businessLogic.BLFacade;
import domain.Bet;
import domain.Event;
import domain.Kuota;
import domain.Question;
import domain.User;
import gui.MainGUI;

public class UserAdapter extends AbstractTableModel {
    private Vector<Bet> userApustuak;
    private String[] columnNames = {"Event","Question","Event Date", "Bet(€)"};
    
    public UserAdapter(User u) {
    	userApustuak =u.getbetlista();
    }

    public int getRowCount() {
        return userApustuak.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
    	BLFacade facade=MainGUI.getBusinessLogic();
    	
        Bet dagokionapustua = userApustuak.get(rowIndex);
        int apustuaren_Kuotaid = dagokionapustua.getKuotaId();

        Kuota kuota=facade.getKuota(apustuaren_Kuotaid);
        int questionID=kuota.getQuestionId();
        Question question = facade.getQuestion(questionID);
        Event ev = question.getEvent();
        
        switch(columnIndex) {
            case 0: return ev.getDescription();
            case 1: return question.getQuestion();
            case 2: return ev.getEventDate();
            case 3: return dagokionapustua.getZenbatDiru();
        }
        return null;
    }
    
    public String[] getColNames() {
        return this.columnNames;
    }
}
