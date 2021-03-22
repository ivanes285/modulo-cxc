package minimarketdemo.controller.cajero;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.cajero.managers.ManagerCliente;
import minimarketdemo.model.core.entities.Cliente;
import minimarketdemo.model.core.entities.TipoPago;

@Named
@SessionScoped
public class BeanCliente implements Serializable {

	@EJB
	private ManagerCliente mCliente;

	private List<Cliente> listaCliente;
	private int idClienteSeleccionado;
	private Cliente nuevoCliente;
	private Cliente edicionCliente;

	public BeanCliente() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		listaCliente = mCliente.findAllCliente();
	}

	public String actionMenuCliente() {
		listaCliente = mCliente.findAllCliente();
		System.out.println("MENUCLIENTE");
		return "cliente";
	}

	public void LlenarMenuCliente() {
		listaCliente = mCliente.findAllCliente();
		System.out.println("LISTA LLENADA");
	}

//	public void actionListenerSeleccionarTipoPago() {
//		listaTipo=ManagerTipoPago;
//	}

	// public void actionListenerActivarDesactivarTipoPago(int idTipoPago) {
	// try {
	// mTipoPago.activarDesactivarTipo(idTipoPago);
	// listaTipo = mTipoPago.findAllTipoPago();
	// JSFUtil.crearMensajeINFO("Tipo de Pago activado/desactivado");
	// } catch (Exception e) {
	// JSFUtil.crearMensajeERROR(e.getMessage());
	// e.printStackTrace();
	// }
	// }

	public String actionMenuNuevoCliente() {
		nuevoCliente = new Cliente();
		return "cliente_nuevo";
	}

	public void actionListenerInsertarNuevoCliente() {
		try {
			mCliente.insertarCliente(nuevoCliente);
			listaCliente = mCliente.findAllCliente();
			nuevoCliente = new Cliente();
			JSFUtil.crearMensajeINFO("Cliente insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public String actionSeleccionarEdicionCliente(Cliente cliente) {
		edicionCliente = cliente;
		return "cliente_edicion";
	}

	public void actionListenerActualizarCliente() {
		try {
			mCliente.actualizarCliente(edicionCliente);
			listaCliente = mCliente.findAllCliente();
			JSFUtil.crearMensajeINFO("Cliente actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerEliminarCliente(int idCliente) {
		try {
			mCliente.eliminarCliente(idCliente);
			listaCliente = mCliente.findAllCliente();
			JSFUtil.crearMensajeINFO("Cliente eliminado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public ManagerCliente getmCliente() {
		return mCliente;
	}

	public void setmCliente(ManagerCliente mCliente) {
		this.mCliente = mCliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public int getIdClienteSeleccionado() {
		return idClienteSeleccionado;
	}

	public void setIdClienteSeleccionado(int idClienteSeleccionado) {
		this.idClienteSeleccionado = idClienteSeleccionado;
	}

	public Cliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(Cliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public Cliente getEdicionCliente() {
		return edicionCliente;
	}

	public void setEdicionCliente(Cliente edicionCliente) {
		this.edicionCliente = edicionCliente;
	}

}
