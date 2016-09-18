package com.dev.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IUsuariodao;
import com.dev.dto.Usuario;

public class Usuariodao implements IUsuariodao {

	@Override
	public void create(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
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
		return null;
	}

	@Override
	public Usuario autenticar(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
