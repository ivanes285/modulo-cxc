package minimarketdemo.controller.cajero;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.controller.gestion.BeanTipoPago;
import minimarketdemo.model.cajero.managers.ManagerPago;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.gestion.managers.ManagerTipoPago;

@Named
@SessionScoped
public class BeanPago implements Serializable {

	@EJB
	private ManagerPago mPago;
//	private ManagerTipoPago mTipoPago;

//
//	private List<TipoPago> listaTipo;
	private List<Pago> listaPago;
	private Pago nuevoPago;
	private Pago edicionPago;
	private Integer idCliente;
	private Integer idTipoPago;

	public BeanPago() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		listaPago = mPago.findAllPago();
		nuevoPago = new Pago();
	}

	public String actionMenuPago() {
		listaPago = mPago.findAllPago();
		System.out.println("MENUPAGO");
		return "pago";
	}

	public void actionListenerActivarDesactivarPago(int idPago) {
		try {
			mPago.activarDesactivarPago(idPago);
			listaPago = mPago.findAllPago();
			JSFUtil.crearMensajeINFO("Pago activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public String actionMenuNuevoPago() {
		// listaTipo = mTipoPago.findAllTipoPago();
		nuevoPago = new Pago();
		return "pago_nuevo";
	}

	public void actionListenerInsertarNuevoPago() {
		try {
			incrementos();
			mPago.insertarPago(nuevoPago, idCliente, idTipoPago);
			listaPago = mPago.findAllPago();
			nuevoPago = new Pago();
			JSFUtil.crearMensajeINFO("Pago insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	String num="";
	int con=0;
	public void incrementos() {
		if (listaPago.isEmpty()) {
			num = String.format("PAG-%04d",1);
			nuevoPago.setNumPago(num);
		}else {
		   con=listaPago.size()+1;
		   num = String.format("PAG-%04d",con);
			nuevoPago.setNumPago(num);
		}
	}

	public String actionSeleccionarEdicionPago(Pago pago) {
		edicionPago = pago;
		return "pago_edicion";
	}

	public void actionListenerActualizarEdicionPago() {
		try {
			mPago.actualizarPago(edicionPago);
			listaPago = mPago.findAllPago();
			JSFUtil.crearMensajeINFO("Pago actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerEliminarPago(int idPago) {
		try {
			mPago.eliminarPago(idPago);
			listaPago = mPago.findAllPago();
			JSFUtil.crearMensajeINFO("Pago eliminado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Pago> getListaPago() {
		return listaPago;
	}

	public void setListaPago(List<Pago> listaPago) {
		this.listaPago = listaPago;
	}

	public Pago getNuevoPago() {
		return nuevoPago;
	}

	public void setNuevoPago(Pago nuevoPago) {
		this.nuevoPago = nuevoPago;
	}

	public Pago getEdicionPago() {
		return edicionPago;
	}

	public void setEdicionPago(Pago edicionPago) {
		this.edicionPago = edicionPago;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(Integer idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

//	public List<TipoPago> getListaTipo() {
//		return listaTipo;
//	}
//
//	public void setListaTipo(List<TipoPago> listaTipo) {
//		this.listaTipo = listaTipo;
//	}

}
