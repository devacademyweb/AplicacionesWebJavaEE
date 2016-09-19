package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.ICategoriadao;
import com.dev.dto.Categoria;
import com.dev.factory.Factory;

public class categoriaModel {
 
  private ICategoriadao cdao=null;
  
  public categoriaModel(){
	  cdao=Factory.getInstance().getCategoriasdao();
  }
	
  
  public void RegistrarCategoria(Categoria cate) throws SQLException{
	  cdao.create(cate);
  }
  
  
  public void EliminarCategoria(int id) throws SQLException{
	  cdao.delete(id);
  }
  
  public void ActualizarCategoria(Categoria cate) throws SQLException{
	  cdao.update(cate);
  }
  
  public Categoria BuscarCategoria(int id) throws SQLException{
	  return cdao.get(id);
  }
  
  public List<Categoria> Listarcategorias() throws SQLException{
	  return cdao.getAll();
  }
  
}
