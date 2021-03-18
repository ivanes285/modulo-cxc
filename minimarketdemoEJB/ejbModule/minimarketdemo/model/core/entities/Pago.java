package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@Table(name="pago")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PagoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago", nullable=false)
	private Date fechaPago;

	@Column(nullable=false, precision=7, scale=2)
	private BigDecimal monto;

	@Column(name="num_pago", nullable=false, length=10)
	private String numPago;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false, insertable=false, updatable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to TipoPago
	@ManyToOne
	@JoinColumn(name="id_tipo_pago", nullable=false, insertable=false, updatable=false)
	private TipoPago tipoPago;

	public Pago() {
	}

	public PagoPK getId() {
		return this.id;
	}

	public void setId(PagoPK id) {
		this.id = id;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNumPago() {
		return this.numPago;
	}

	public void setNumPago(String numPago) {
		this.numPago = numPago;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

}