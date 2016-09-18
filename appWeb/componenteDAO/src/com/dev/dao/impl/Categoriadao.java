package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.ICategoriadao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Categoria;

public class Categoriadao implements ICategoriadao {

	@Override
	public void create(Categoria o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_categoria(?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

	}

	@Override
	public void update(Categoria o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_update_categoria(?,?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getId());
		cs.setString(3, o.getNombre());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

	}

	@Override
	public void delete(int id) throws SQLException {
		String insert = "{call sp_delete_categoria(?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, id);

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

	}

	@Override
	public Categoria get(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_get_categoria(?)}";
		Connection cn = Dbconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		cs.setInt(1, id);

		ResultSet rs = cs.executeQuery();

		if (rs.next()) {
			mapRow(rs);
		}

		return mapRow(rs);
	}

	@Override
	public List<Categoria> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Categoria> lista = new ArrayList<>();
		String query = "{call sp_list_categoria()}";
		Connection cn = Dbconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();

		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Categoria mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		Categoria categoria=new Categoria();
		categoria.setId(rs.getInt(1));
		categoria.setNombre(rs.getString(2));
		return categoria;
	}

}
