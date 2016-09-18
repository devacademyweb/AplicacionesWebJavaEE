package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IPeliculadao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Categoria;
import com.dev.dto.Pelicula;

public class Peliculadao implements IPeliculadao {

	@Override
	public void create(Pelicula o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_pelicula(?,?,?,?,?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setDouble(3, o.getPrecio());
		cs.setInt(4, o.getStock());
		cs.setString(5, o.getImagen());
		cs.setInt(6, o.getIdcategoria().getId());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}

	}

	@Override
	public void update(Pelicula o) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pelicula get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Pelicula> lista = new ArrayList<>();
		String query = "{call sp_list_pelicula()}";
		Connection cn = Dbconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();

		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Pelicula mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Pelicula pelicula=new Pelicula();
		Categoria categoria=new Categoria();
		
		pelicula.setId(rs.getInt(1));
		pelicula.setNombre(rs.getString(2));
		pelicula.setStock(rs.getInt(3));
		pelicula.setPrecio(rs.getDouble(4));
		pelicula.setImagen(rs.getString(5));
		
		categoria.setId(rs.getInt(6));
		categoria.setNombre(rs.getString(7));
		
		pelicula.setIdcategoria(categoria);
		
		return pelicula;
	}

	@Override
	public List<Pelicula> listarPeliculasCategoria(String nombrecategoria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
