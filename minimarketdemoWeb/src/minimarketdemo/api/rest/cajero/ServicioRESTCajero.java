package minimarketdemo.api.rest.cajero;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import minimarketdemo.model.cajero.dtos.DTOCliente;
import minimarketdemo.model.cajero.managers.ManagerCliente;

@RequestScoped
@Path("cajero")
@Produces("application/json")
@Consumes("application/json")
public class ServicioRESTCajero {

	@EJB
	private ManagerCliente mCli;
	@GET
	@Path(value = "cliente")
	public List<DTOCliente> findClienteConDeuda(){
		return mCli.clienteConDeuda();
	} 		 	
	
}
