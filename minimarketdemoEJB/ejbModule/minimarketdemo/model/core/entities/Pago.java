package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@Table(name="pago")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago", unique=true, nullable=false)
	private Integer idPago;

	@Column(nullable=false, length=20)
	private String estado;

	@Column(nullable=false, precision=7, scale=2)
	private BigDecimal monto;

	@Column(name="num_pago", nullable=false, length=10)
	private String numPago;

	//bi-directional many-to-one association to TipoPago
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_pago", nullable=false)
	private TipoPago tipoPago;

	public Pago() {
	}

	public Integer getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

}