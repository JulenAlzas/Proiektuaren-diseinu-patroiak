package Adapter;

import java.awt.EventQueue;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;
import domain.Mugimenduak;
import domain.User;
import gui.MainGUI;

public class JTable_GUI extends JFrame {

	private JFrame frame;
	private JTable tableMugimenduak= new JTable();
	private DefaultTableModel tableModelMugimenduak;
	private UserAdapter userAd;
	private String[] columnNamesMugimenduak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable_GUI window = new JTable_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JTable_GUI() {
		getContentPane().setLayout(null);

		setTitle("x-k egindako apuntuak:");
		getContentPane().setLayout(null);

		JScrollPane scrollPaneMugimenduak = new JScrollPane();
		scrollPaneMugimenduak.setBounds(58, 46, 298, 181);
		getContentPane().add(scrollPaneMugimenduak);
		initialize();

		scrollPaneMugimenduak.setViewportView(tableMugimenduak);

		tableModelMugimenduak = new DefaultTableModel(null, columnNamesMugimenduak);

		tableMugimenduak.setModel(tableModelMugimenduak);
		tableMugimenduak.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableMugimenduak.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableMugimenduak.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableMugimenduak.getColumnModel().getColumn(3).setPreferredWidth(100);

	}
	public JTable_GUI(User us) {
		setTitle(us.getIzena()+"-k egindako apuntuak:");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);

		userAd= new UserAdapter(us);
		columnNamesMugimenduak= userAd.getColNames();

		JScrollPane scrollPaneMugimenduak = new JScrollPane();
		scrollPaneMugimenduak.setBounds(58, 46, 298, 181);
		getContentPane().add(scrollPaneMugimenduak);

		scrollPaneMugimenduak.setViewportView(tableMugimenduak);

		tableModelMugimenduak = new DefaultTableModel(null, columnNamesMugimenduak);

		tableMugimenduak.setModel(tableModelMugimenduak);

		BLFacade facade = MainGUI.getBusinessLogic();

		tableModelMugimenduak.setDataVector(null, columnNamesMugimenduak);
		tableModelMugimenduak.setColumnCount(4);
		
		Vector<Object> rowObj = new Vector<Object>();
		for(int row=0; row<userAd.getRowCount();row++) {
			for(int col=0; col<userAd.getColumnCount();col++) {
				rowObj.add(userAd.getValueAt(row, col));
			}
			tableModelMugimenduak.addRow(rowObj); 
			rowObj = new Vector<Object>();
		}


		tableMugimenduak.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableMugimenduak.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableMugimenduak.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableMugimenduak.getColumnModel().getColumn(3).setPreferredWidth(100);
		//		tableMugimenduak.getColumnModel().removeColumn(tableMugimenduak.getColumnModel().getColumn(2));


		this.getContentPane().add(scrollPaneMugimenduak, null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 100, 50, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
