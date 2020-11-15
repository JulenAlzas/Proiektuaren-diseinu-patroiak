package iterator;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Factory.DBmota;
import Factory.konexioLOKALA;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
public class Main_Iterator {
	public static void main(String[] args) throws ParseException, MalformedURLException {
		boolean isLocal=true;
		//Facade objektua lortu lehendabiziko ariketa erabiliz
		DBmota mota= new konexioLOKALA();
		BLFacade facadeInterface= mota.konexiomota();
		String bilatuEguna= "25/11/2020" ;//Fitxategiko probako data "17/03/2020";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(bilatuEguna);
		ExtendedIterator<Event> i= facadeInterface.getEvents(date1);
		Event ev;
		i.goLast();
		while (i.hasPrevious()){
			ev=i.previous();
			System.out.println(ev.toString());
		}
		System.out.println("----------------------");
		//Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu.
		i.goFirst();
		while (i.hasNext()){
			ev=(Event) i.next();
			System.out.println(ev.toString());
		}
	}
}
