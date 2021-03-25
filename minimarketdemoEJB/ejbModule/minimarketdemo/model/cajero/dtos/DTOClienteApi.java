package minimarketdemo.model.cajero.dtos;

import java.math.BigDecimal;

public class DTOClienteApi {

	private int idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String cedula;
	private double saldo;
	private double valorLimiteCredito;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getValorLimiteCredito() {
		return valorLimiteCredito;
	}
	public void setValorLimiteCredito(double valorLimiteCredito) {
		this.valorLimiteCredito = valorLimiteCredito;
	}


}
