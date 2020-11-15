package Factory;

import java.net.MalformedURLException;

import businessLogic.BLFacade;

public interface DBmota {
	public BLFacade konexiomota() throws MalformedURLException;
}
