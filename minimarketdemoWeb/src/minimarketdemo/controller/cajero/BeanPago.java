package minimarketdemo.controller.cajero;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.cajero.managers.ManagerPago;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.gestion.managers.ManagerTipoPago;

@Named
@SessionScoped
public class BeanPago implements Serializable {

	@EJB
	private ManagerPago mPago;

	private List<Pago> listaPago;
	private Pago nuevoPago;
	private Pago edicionPago;
	
	public BeanPago() {
		// TODO Auto-generated constructor stub
	}
	
	public String actionMenuPago() {
		listaPago = mPago.findAllPago();
		System.out.println("MENUPAGO");
		return "pago";
	}

//	public void actionListenerActivarDesactivarTipoPago(int idTipoPago) {
//		try {
//			mTipoPago.activarDesactivarTipo(idTipoPago);
//			listaTipo = mTipoPago.findAllTipoPago();
//			JSFUtil.crearMensajeINFO("Tipo de Pago activado/desactivado");
//		} catch (Exception e) {
//			JSFUtil.crearMensajeERROR(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public String actionMenuNuevoTipoPago() {
//		nuevoTipo = new TipoPago();
//		nuevoTipo.setEstado(true);
//		return "tipopago_nuevo";
//	}
//
//	public void actionListenerInsertarNuevoTipoPago() {
//		try {
//			mTipoPago.insertarTipoPago(nuevoTipo);
//			listaTipo = mTipoPago.findAllTipoPago();
//			nuevoTipo = new TipoPago();
//			nuevoTipo.setEstado(true);
//			JSFUtil.crearMensajeINFO("Tipo de Pago insertado.");
//		} catch (Exception e) {
//			JSFUtil.crearMensajeERROR(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public String actionSeleccionarEdicionTipo(TipoPago tipo) {
//		edicionTipo = tipo;
//		return "tipos_edicion";
//	}
//
//	public void actionListenerActualizarEdicionTipo() {
//		try {
//			mTipoPago.actualizarTipoPago(edicionTipo);
//			listaTipo = mTipoPago.findAllTipoPago();
//			JSFUtil.crearMensajeINFO("Tipo de Pago actualizado.");
//		} catch (Exception e) {
//			JSFUtil.crearMensajeERROR(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public void actionListenerEliminarTipo(int idTipoPago) {
//		try {
//			mTipoPago.eliminarTipo(idTipoPago);
//			listaTipo = mTipoPago.findAllTipoPago();
//			JSFUtil.crearMensajeINFO("Tipo de Pago eliminado.");
//		} catch (Exception e) {
//			JSFUtil.crearMensajeERROR(e.getMessage());
//			e.printStackTrace();
//		}
//	}

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

}
