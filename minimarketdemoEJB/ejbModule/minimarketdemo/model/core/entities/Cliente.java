package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente", unique=true, nullable=false)
	private Integer idCliente;

	@Column(name="apellido_cliente", nullable=false, length=20)
	private String apellidoCliente;

	@Column(nullable=false, length=10)
	private String cedula;

	@Column(nullable=false, length=20)
	private String correo;

	@Column(name="deuda_incial", nullable=false, precision=7, scale=2)
	private BigDecimal deudaIncial;

	@Column(nullable=false, length=50)
	private String dir;

	@Column(name="nombre_cliente", nullable=false, length=20)
	private String nombreCliente;

	@Column(name="saldo_deuda", nullable=false, precision=7, scale=2)
	private BigDecimal saldoDeuda;

	@Column(nullable=false, length=10)
	private String telf;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="cliente")
	private List<Pago> pagos;

	public Cliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidoCliente() {
		return this.apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public BigDecimal getDeudaIncial() {
		return this.deudaIncial;
	}

	public void setDeudaIncial(BigDecimal deudaIncial) {
		this.deudaIncial = deudaIncial;
	}

	public String getDir() {
		return this.dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public BigDecimal getSaldoDeuda() {
		return this.saldoDeuda;
	}

	public void setSaldoDeuda(BigDecimal saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}

	public String getTelf() {
		return this.telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setCliente(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setCliente(null);

		return pago;
	}

}