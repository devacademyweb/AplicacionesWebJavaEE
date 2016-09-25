package com.dev.dto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private int idpedido;
	private String fecha;
	private double total;
	
	private Usuario usu;
	
	private List<Item> lstItem=null;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
		lstItem=new ArrayList<>();//Composicion
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public List<Item> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<Item> lstItem) {
		this.lstItem = lstItem;
	}
	
	

}
