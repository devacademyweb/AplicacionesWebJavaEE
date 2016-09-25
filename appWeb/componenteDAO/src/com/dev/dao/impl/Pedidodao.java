package com.dev.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IPedidodao;
import com.dev.dto.Pedido;
import com.dev.dto.Usuario;

public class Pedidodao implements IPedidodao{

	@Override
	public void create(Pedido o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pedido o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarPedidosUsuario(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarPedidosFecha(String fecha) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
