package com.dev.factory;

import com.dev.dao.ICategoriadao;
import com.dev.dao.IPeliculadao;
import com.dev.dao.impl.Categoriadao;
import com.dev.dao.impl.Peliculadao;

public class Factory {

	private static Factory fac;
	
	private Factory(){
		
	}
	
	
	public static Factory getInstance(){
		if(fac==null)
			fac=new Factory();
		return fac;
	}
	
	
	public ICategoriadao getCategoriasdao(){
		return new Categoriadao();
	}
	
	public IPeliculadao getPeliculasdao(){
		return new Peliculadao();
	}
}
