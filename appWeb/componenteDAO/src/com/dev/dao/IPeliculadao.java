package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Pelicula;

public interface IPeliculadao extends ICruddao<Pelicula>,IRowmapper<Pelicula> {

	List<Pelicula> listarPeliculasCategoria(String nombrecategoria) throws SQLException;
}
