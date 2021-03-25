package minimarketdemo.controller.cajero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import minimarketdemo.model.cajero.dtos.DTOClienteApi;

@Named
@SessionScoped
public class BeanClienteApi implements Serializable {

	private List<DTOClienteApi> listaClientesApi;
	private Client client;   //
	private WebTarget objetivo; //
	private JsonArray response;
	
	
	
	public BeanClienteApi() {
		// TODO Auto-generated constructor stub
	}

	
	@PostConstruct
	public void inicializarApiConsumo() {
		listaClientesApi = new ArrayList<DTOClienteApi>();
		String URL = "http://node246071-env-3756133.j.layershift.co.uk/minimarketdemoWeb/apirest/facturacion/clientes";
		client = ClientBuilder.newClient();
		objetivo = client.target(URL);
		response = objetivo.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		for (int i = 0; i < response.size(); i++) {
			JsonObject j = response.getJsonObject(i);
			DTOClienteApi c = new DTOClienteApi();
			c.setIdCliente(j.getInt("idCliente"));
			c.setNombreCliente(j.getString("nombres"));
			c.setApellidoCliente(j.getString("apellidos"));
			c.setCedula(j.getString("cedula"));
			c.setSaldo(j.getJsonNumber("saldo").doubleValue());
			c.setValorLimiteCredito(j.getJsonNumber("valorLimiteCredito").doubleValue());
			listaClientesApi.add(c);
			
		}
	}
	
	public String actionMenuClienteApi() {
//		listaClientesApi = mCliente.findAllCliente();
		System.out.println("MENUCLIENTE   API");
		return "clienteApi";
	}

	

	public List<DTOClienteApi> getListaClientesApi() {
		return listaClientesApi;
	}

	public void setListaClientesApi(List<DTOClienteApi> listaClientesApi) {
		this.listaClientesApi = listaClientesApi;
	}

}
