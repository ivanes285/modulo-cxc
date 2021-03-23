package minimarketdemo.model.cajero.dtos;

import java.math.BigDecimal;

public class DTOCliente {
	private int idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String cedula;
	private String correo;
	private BigDecimal deudaInicial;
	private String dir;
	private BigDecimal saldoDeuda;	
	
	public DTOCliente(int idCliente, String nombreCliente, String apellidoCliente, String cedula, String correo,
			BigDecimal deudaInicial, String dir, BigDecimal saldoDeuda) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.cedula = cedula;
		this.correo = correo;
		this.deudaInicial = deudaInicial;
		this.dir = dir;
		this.saldoDeuda = saldoDeuda;
	}
	
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public BigDecimal getDeudaInicial() {
		return deudaInicial;
	}
	public void setDeudaInicial(BigDecimal deudaInicial) {
		this.deudaInicial = deudaInicial;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public BigDecimal getSaldoDeuda() {
		return saldoDeuda;
	}
	public void setSaldoDeuda(BigDecimal saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}
}
