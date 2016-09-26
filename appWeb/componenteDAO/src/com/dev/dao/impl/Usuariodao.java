package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IUsuariodao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Usuario;

public class Usuariodao implements IUsuariodao {

	@Override
	public void create(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
		String insert = "{call insert_usuario(?,?,?,?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getApellidos());
		cs.setString(3, o.getNombres());
		cs.setString(4, o.getCorreo());
		cs.setString(5, o.getPassword());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

	}

	@Override
	public void update(Usuario o) throws SQLException {

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Usuario u=new Usuario();
		u.setId(rs.getInt(1));
		u.setApellidos(rs.getString(2));
		u.setNombres(rs.getString(3));
		u.setCorreo(rs.getString(4));
		u.setAutorizacion(rs.getString(5));
		u.setAutorizacion(rs.getString(6));
		return u;
	}

	@Override
	public Usuario autenticar(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		
		String query="{call sp_autentica_usuario(?,?)}";
		Connection cn=Dbconnection.getInstance();
		
		CallableStatement cs=cn.prepareCall(query);
		
		cs.setString(1, correo);
		cs.setString(2, password);
		
		ResultSet rs=cs.executeQuery();
		if(rs.next()){
			mapRow(rs);
		}
		return mapRow(rs);
	}

}
