package minimarketdemo.controller.gestion;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.gestion.managers.ManagerTipoPago;

@Named
@SessionScoped
public class BeanTipoPago implements Serializable {

	@EJB
	private ManagerTipoPago mTipoPago;

	private List<TipoPago> listaTipo;
	private int idTipoPagoSeleccionado;
	private TipoPago nuevoTipo;
	private TipoPago edicionTipo;

	public BeanTipoPago() {
		// TODO Auto-generated constructor stub
	}

	public String actionMenuTipoPago() {
		listaTipo = mTipoPago.findAllTipoPago();
		System.out.println("MENUTIPOPAGO");
		return "tipopago";
	}
	
	public void LlenarMenuTipoPago() {
		listaTipo = mTipoPago.findAllTipoPago();
		System.out.println("LISTA LLENADA");
	}

//	public void actionListenerSeleccionarTipoPago() {
//		listaTipo=ManagerTipoPago;
//	}
	
	public void actionListenerActivarDesactivarTipoPago(int idTipoPago) {
		try {
			mTipoPago.activarDesactivarTipo(idTipoPago);
			listaTipo = mTipoPago.findAllTipoPago();
			JSFUtil.crearMensajeINFO("Tipo de Pago activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public String actionMenuNuevoTipoPago() {
		nuevoTipo = new TipoPago();
		nuevoTipo.setEstado(true);
		return "tipopago_nuevo";
	}

	public void actionListenerInsertarNuevoTipoPago() {
		try {
			mTipoPago.insertarTipoPago(nuevoTipo);
			listaTipo = mTipoPago.findAllTipoPago();
			nuevoTipo = new TipoPago();
			nuevoTipo.setEstado(true);
			JSFUtil.crearMensajeINFO("Tipo de Pago insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public String actionSeleccionarEdicionTipo(TipoPago tipo) {
		edicionTipo = tipo;
		return "tipos_edicion";
	}

	public void actionListenerActualizarEdicionTipo() {
		try {
			mTipoPago.actualizarTipoPago(edicionTipo);
			listaTipo = mTipoPago.findAllTipoPago();
			JSFUtil.crearMensajeINFO("Tipo de Pago actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerEliminarTipo(int idTipoPago) {
		try {
			mTipoPago.eliminarTipo(idTipoPago);
			listaTipo = mTipoPago.findAllTipoPago();
			JSFUtil.crearMensajeINFO("Tipo de Pago eliminado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<TipoPago> getListaTipo() {
		return listaTipo;
	}

	public void setListaTipo(List<TipoPago> listaTipo) {
		this.listaTipo = listaTipo;
	}

	public TipoPago getNuevoTipo() {
		return nuevoTipo;
	}

	public void setNuevoTipo(TipoPago nuevoTipo) {
		this.nuevoTipo = nuevoTipo;
	}

	public TipoPago getEdicionTipo() {
		return edicionTipo;
	}

	public void setEdicionTipo(TipoPago edicionTipo) {
		this.edicionTipo = edicionTipo;
	}

	public int getIdTipoPagoSeleccionado() {
		return idTipoPagoSeleccionado;
	}

	public void setIdTipoPagoSeleccionado(int idTipoPagoSeleccionado) {
		this.idTipoPagoSeleccionado = idTipoPagoSeleccionado;
	}

}
