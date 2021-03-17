package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the deuda database table.
 * 
 */
@Entity
@Table(name="deuda")
@NamedQuery(name="Deuda.findAll", query="SELECT d FROM Deuda d")
public class Deuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_deuda", unique=true, nullable=false)
	private Integer idDeuda;

	@Column(name="monto_inicial", nullable=false, precision=7, scale=2)
	private BigDecimal montoInicial;

	@Column(nullable=false, precision=7, scale=2)
	private BigDecimal saldo;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="deuda")
	private List<Cliente> clientes;

	public Deuda() {
	}

	public Integer getIdDeuda() {
		return this.idDeuda;
	}

	public void setIdDeuda(Integer idDeuda) {
		this.idDeuda = idDeuda;
	}

	public BigDecimal getMontoInicial() {
		return this.montoInicial;
	}

	public void setMontoInicial(BigDecimal montoInicial) {
		this.montoInicial = montoInicial;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setDeuda(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setDeuda(null);

		return cliente;
	}

}