package minimarketdemo.controller.cajero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import minimarketdemo.model.cajero.dtos.DTOFacturas;

@Named
@SessionScoped
public class BeanFacturas implements Serializable {

	private List<DTOFacturas> listaFacturas;
	private Client client;   //
	private WebTarget objetivo; //
	private JsonArray response;
	
	public BeanFacturas() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaFacturas = new ArrayList<DTOFacturas>();
		String URL = "http://node246071-env-3756133.j.layershift.co.uk/minimarketdemoWeb/apirest/facturacion/facturas";
		client = ClientBuilder.newClient();
		objetivo = client.target(URL);
		response = objetivo.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		for (int i = 0; i < response.size(); i++) {
			JsonObject j = response.getJsonObject(i);
			DTOFacturas f = new DTOFacturas();
			
		    f.setDescuento(j.getJsonNumber("descuento").doubleValue());
		    f.setNumfactura(j.getString("numFactura"));
		    f.setSubtotal(j.getJsonNumber("subtotal").doubleValue());
			//f.setFecha(j.getString("fechaEmision"));
		    f.setTotal(j.getJsonNumber("total").doubleValue());	
			 listaFacturas.add(f);
		}
	}
	
	public String actionMenuFacturas() {

		System.out.println("FACTURAS  API");
		return "facturas";
	}

	
	
	
	public List<DTOFacturas> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<DTOFacturas> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	
	
	

}
