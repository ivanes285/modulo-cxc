package minimarketdemo.model.cajero.dtos;

import java.util.Date;

public class DTOFacturas {


	private double descuento;
	private String numfactura;
	private double subtotal;
	//private Date fecha;
	private double total;
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public String getNumfactura() {
		return numfactura;
	}
	public void setNumfactura(String numfactura) {
		this.numfactura = numfactura;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
//	public Date getFecha() {
//		return fecha;
//	}
//	public void setFecha(Date fecha) {
//		this.fecha = fecha;
//	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
