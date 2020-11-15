package Factory;

import java.util.Locale;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class konexioLOKALA implements DBmota {

	@Override
	public BLFacade konexiomota() {
		ConfigXML c=ConfigXML.getInstance();
		DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
		return new BLFacadeImplementation(da);
	}
	
	
}
