package Factory;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import configuration.ConfigXML;

public class konexioEZlokala implements DBmota{

	@Override
	public BLFacade konexiomota() throws MalformedURLException {
		ConfigXML c=ConfigXML.getInstance();
		String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";

		URL url = new URL(serviceName);

		QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");

		Service service = Service.create(url, qname);

		return  service.getPort(BLFacade.class);
	}
}
