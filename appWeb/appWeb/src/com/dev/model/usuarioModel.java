package com.dev.model;

import java.sql.SQLException;

import com.dev.dao.IUsuariodao;
import com.dev.dto.Usuario;
import com.dev.factory.Factory;

public class usuarioModel {
	
	private IUsuariodao udao=null;
	
	public usuarioModel() {
		// TODO Auto-generated constructor stub
		udao=Factory.getInstance().getUsuariodao();
	}
	
	public Usuario inicioSesion(String correo,String password) throws SQLException{
		Usuario u=udao.autentica(correo, password);
		return u;
	}
	
	public void registrarUsuario(Usuario u)throws SQLException{
		udao.create(u);
	}
	

}
