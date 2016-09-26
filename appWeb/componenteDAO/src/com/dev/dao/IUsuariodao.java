package com.dev.dao;

import java.sql.SQLException;

import com.dev.dto.Usuario;

public interface IUsuariodao extends ICruddao<Usuario>,IRowmapper<Usuario> {
	Usuario autentica(String correo, String password)throws SQLException; 
}
