package com.dev.test;

import java.sql.SQLException;

import com.dev.dao.IUsuariodao;
import com.dev.dao.impl.Usuariodao;
import com.dev.dto.Usuario;

public class Test1 {
	public static void main(String[] args) throws SQLException {

		IUsuariodao udao=new Usuariodao();
		Usuario u=new Usuario();
		u.setApellidos("hh");
		u.setNombres("hh");
		u.setCorreo("hh@gmail.com");
		u.setPassword("123");
		
		udao.create(u);
		
		
		
	}
}
