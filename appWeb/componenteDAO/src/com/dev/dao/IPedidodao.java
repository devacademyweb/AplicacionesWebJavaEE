package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Pedido;
import com.dev.dto.Usuario;

public interface IPedidodao extends ICruddao<Pedido>, IRowmapper<Pedido> {
	List<Pedido> listarPedidosUsuario(Usuario o) throws SQLException;

	List<Pedido> listarPedidosFecha(String fecha) throws SQLException;

}
