package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IPeliculadao;
import com.dev.dto.Pelicula;
import com.dev.factory.Factory;

public class peliculaModel {
	
	private IPeliculadao pdao=null;
	
	public peliculaModel() {
		pdao=Factory.getInstance().getPeliculasdao();
	}

	
	public void RegistrarPelicula(Pelicula pel)throws SQLException{
		pdao.create(pel);
	}
	
	public List<Pelicula> Listarpeliculas()throws SQLException{
		return pdao.getAll();
	}
}
