package minimarketdemo.model.cajero.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Cliente;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerCliente
 */
@Stateless
@LocalBean
public class ManagerCliente {
	
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerCliente() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Cliente> findAllCliente(){
    	return mDAO.findAll(Cliente.class, "apellidoCliente");
    }
    
//    public SegUsuario findByIdSegUsuario(int idSegUsuario) throws Exception {
//    	return (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
//    }
    
    /**
     * metodo que recibe un object tipopago e inserta en la BDD
     * @param nuevoTipoPago
     * @throws Exception
     */
    public void insertarCliente(Cliente nuevoCliente) throws Exception {
    	mDAO.insertar(nuevoCliente);
    }
    
    public void actualizarCliente(Cliente edicionCliente) throws Exception {
    	Cliente cliente=(Cliente) mDAO.findById(Cliente.class, edicionCliente.getIdCliente());
    	cliente.setNombreCliente(edicionCliente.getNombreCliente());
    	cliente.setApellidoCliente(edicionCliente.getApellidoCliente());
    	cliente.setTelf(edicionCliente.getTelf());
    	cliente.setDir(edicionCliente.getDir());
    	cliente.setCorreo(edicionCliente.getCorreo());
    	cliente.setCedula(edicionCliente.getCedula());
    	cliente.setDeudaIncial(edicionCliente.getDeudaIncial());
    	cliente.setSaldoDeuda(edicionCliente.getSaldoDeuda());
    	mDAO.actualizar(cliente);
    }
      
    public void eliminarCliente(int idCliente) throws Exception {
    	Cliente cliente=(Cliente) mDAO.findById(Cliente.class, idCliente);    	    	
    	mDAO.eliminar(Cliente.class, cliente.getIdCliente());
    }

}
