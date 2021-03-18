package minimarketdemo.model.cajero.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerPago
 */
@Stateless
@LocalBean
public class ManagerPago {

	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
	
    /**
     * Default constructor. 
     */
    public ManagerPago() {
        // TODO Auto-generated constructor stub
    }

    public List<Pago> findAllPago(){
    	Pago p = new Pago();
    	System.out.println("FORANEA "+p.getTipoPago());
    	return mDAO.findAll(Pago.class, "numPago");
    }
    
//    public SegUsuario findByIdSegUsuario(int idSegUsuario) throws Exception {
//    	return (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
//    }
    
    /**
     * metodo que recibe un object tipopago e inserta en la BDD
     * @param nuevoTipoPago
     * @throws Exception
     */
    public void insertarPago(Pago nuevoPago) throws Exception {
    	mDAO.insertar(nuevoPago);
    }
    
    public void actualizarPago(Pago edicionPago) throws Exception {
    	Pago pago=(Pago) mDAO.findById(Pago.class, edicionPago.getIdPago());
    	pago.setNumPago(edicionPago.getNumPago());
    	pago.setMonto(edicionPago.getMonto());
    	pago.setEstado(edicionPago.getEstado());
    	pago.setTipoPago(edicionPago.getTipoPago());
    	mDAO.actualizar(pago);
    }
    
    public void activarDesactivarPago(int idPago) throws Exception {
    	Pago pago=(Pago) mDAO.findById(Pago.class, idPago);    	
    	pago.setEstado(!pago.getEstado());
    	System.out.println("activar/desactivar "+pago.getEstado());
    	mDAO.actualizar(pago);
    }
    
    public void eliminarPago(int idPago) throws Exception {
    	Pago pago=(Pago) mDAO.findById(Pago.class, idPago);    	    	
    	mDAO.eliminar(Pago.class, pago.getIdPago());
    }
    
}
