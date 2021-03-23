package minimarketdemo.api.soap.cajero;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import minimarketdemo.model.cajero.dtos.DTOCliente;
import minimarketdemo.model.cajero.managers.ManagerCliente;

@WebService(serviceName = "ServiceCajero")
public class ServiceSOAPCajero {
	
	@EJB
	private ManagerCliente mCli;
	
	@WebMethod(operationName = "findClienteConDeuda")
	public List<DTOCliente> findClienteConDeuda(){
		return mCli.clienteConDeuda();
	}
	
}
