package minimarketdemo.model.gestion.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.SegAsignacion;
import minimarketdemo.model.core.entities.SegModulo;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerTipoPago
 */
@Stateless
@LocalBean
public class ManagerTipoPago {

	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
    /**
     * Default constructor. 
     */
    public ManagerTipoPago() {
        // TODO Auto-generated constructor stub
    }

    public List<TipoPago> findAllTipoPago(){
    	return mDAO.findAll(TipoPago.class, "descripcion");
    }
    
//    public SegUsuario findByIdSegUsuario(int idSegUsuario) throws Exception {
//    	return (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
//    }
    
    /**
     * metodo que recibe un object tipopago e inserta en la BDD
     * @param nuevoTipoPago
     * @throws Exception
     */
    public void insertarTipoPago(TipoPago nuevoTipoPago) throws Exception {
    	mDAO.insertar(nuevoTipoPago);
    }
    
    public void actualizarTipoPago(TipoPago edicionTipoPago) throws Exception {
    	TipoPago tipo=(TipoPago) mDAO.findById(TipoPago.class, edicionTipoPago.getIdTipoPago());
    	tipo.setNombre(edicionTipoPago.getNombre());
    	tipo.setDescripcion(edicionTipoPago.getDescripcion());
    	tipo.setEstado(edicionTipoPago.getEstado());
    	mDAO.actualizar(tipo);
    }
    
    public void activarDesactivarTipo(int idTipoPago) throws Exception {
    	TipoPago tipo=(TipoPago) mDAO.findById(TipoPago.class, idTipoPago);    	
    	tipo.setEstado(!tipo.getEstado());
    	System.out.println("activar/desactivar "+tipo.getEstado());
    	mDAO.actualizar(tipo);
    }
    
    public void eliminarTipo(int idTipoPago) throws Exception {
    	TipoPago tipo=(TipoPago) mDAO.findById(TipoPago.class, idTipoPago);    	    	
    	mDAO.eliminar(TipoPago.class, tipo.getIdTipoPago());
    }
}
