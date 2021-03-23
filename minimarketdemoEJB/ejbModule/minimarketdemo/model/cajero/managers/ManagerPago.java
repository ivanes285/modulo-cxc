package minimarketdemo.model.cajero.managers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.AudBitacora;
import minimarketdemo.model.core.entities.Cliente;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.TipoPago;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerPago
 */
@Stateless
@LocalBean
public class ManagerPago {

	Pago pa = new Pago();

	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerPago() {
		// TODO Auto-generated constructor stub
	}

	public List<Pago> findAllPago() {
		Pago p = new Pago();
		System.out.println("FORANEA " + p.getTipoPago());
		return mDAO.findAll(Pago.class, "numPago");
	}

//    public SegUsuario findByIdSegUsuario(int idSegUsuario) throws Exception {
//    	return (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
//    }

	/**
	 * metodo que recibe un object tipopago e inserta en la BDD
	 * 
	 * @param nuevoTipoPago
	 * @throws Exception
	 */

	String num = "";

	public void insertarPago(Pago nuevoPago, Integer idCliente, Integer idTipoPago) throws Exception {
		descontarDeuda(idCliente, nuevoPago.getMonto());
		Cliente c = em.find(Cliente.class, idCliente);
		if (c == null)
			throw new Exception("No existe el cliente con id: (" + idCliente + ")");

		TipoPago tp = em.find(TipoPago.class, idTipoPago);
		if (tp == null)
			throw new Exception("No existe el tipo de pago con id: (" + idTipoPago + ")");

		nuevoPago.setCliente(c);
		nuevoPago.setTipoPago(tp);
		nuevoPago.setFechaPago(new Date());
		mDAO.insertar(nuevoPago);
	}

	public void descontarDeuda(int idcliente, BigDecimal monto) throws Exception {
		Cliente cliente = (Cliente) mDAO.findById(Cliente.class, idcliente);
		BigDecimal pago = cliente.getSaldoDeuda().subtract(monto);
		if (pago.doubleValue() < 0) {
			throw new Exception("El pago superó la deuda en: " + pago);
		} else {
			cliente.setSaldoDeuda(pago);
			mDAO.actualizar(cliente);
		}
	}

	public void actualizarPago(Pago edicionPago) throws Exception {
		Pago pago = (Pago) mDAO.findById(Pago.class, edicionPago.getIdPago());
		pago.getCliente().setNombreCliente(edicionPago.getCliente().getNombreCliente());
		pago.getCliente().setApellidoCliente(edicionPago.getCliente().getApellidoCliente());
		pago.getCliente().setTelf(edicionPago.getCliente().getTelf());
		pago.getCliente().setDir(edicionPago.getCliente().getDir());
		pago.getCliente().setCorreo(edicionPago.getCliente().getCorreo());
		pago.getCliente().setCedula(edicionPago.getCliente().getCedula());
		pago.setTipoPago(edicionPago.getTipoPago());
		pago.setCliente(edicionPago.getCliente());
		mDAO.actualizar(pago);
	}

	public void activarDesactivarPago(int idPago) throws Exception {
		Pago pago = (Pago) mDAO.findById(Pago.class, idPago);
		mDAO.actualizar(pago);
	}

	public void eliminarPago(int idPago) throws Exception {
		Pago pago = (Pago) mDAO.findById(Pago.class, idPago);
		mDAO.eliminar(Pago.class, pago.getIdPago());
	}

	public List<Pago> findPagoByFecha(Date fechaInicio,Date fechaFin){
    	SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	System.out.println("fecha inicio: "+format.format(fechaInicio));
    	System.out.println("fecha fin: "+format.format(fechaFin));
    	String consulta="select b from Pago b where b.fechaPago between :fechaInicio and :fechaFin order by b.fechaPago";
    	Query q=mDAO.getEntityManager().createQuery(consulta, Pago.class);
    	q.setParameter("fechaInicio", new Timestamp(fechaInicio.getTime()));
    	q.setParameter("fechaFin", new Timestamp(fechaFin.getTime()));
    	return q.getResultList();
    	
    }
	
}
