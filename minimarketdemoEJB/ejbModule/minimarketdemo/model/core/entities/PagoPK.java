package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pago database table.
 * 
 */
@Embeddable
public class PagoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pago", unique=true, nullable=false)
	private Integer idPago;

	@Column(name="id_cliente", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idCliente;

	@Column(name="id_tipo_pago", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idTipoPago;

	public PagoPK() {
	}
	public Integer getIdPago() {
		return this.idPago;
	}
	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}
	public Integer getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdTipoPago() {
		return this.idTipoPago;
	}
	public void setIdTipoPago(Integer idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PagoPK)) {
			return false;
		}
		PagoPK castOther = (PagoPK)other;
		return 
			this.idPago.equals(castOther.idPago)
			&& this.idCliente.equals(castOther.idCliente)
			&& this.idTipoPago.equals(castOther.idTipoPago);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPago.hashCode();
		hash = hash * prime + this.idCliente.hashCode();
		hash = hash * prime + this.idTipoPago.hashCode();
		
		return hash;
	}
}