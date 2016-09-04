package com.devacademyweb.factory;

import com.devacademyweb.service.IMateservice;
import com.devacademyweb.service.impl.Mateservice;

//Patron Singleton
public class Factory {
  private static Factory fac;
  
  static{
	  fac=new Factory();
  }
  
  public static Factory getInstance(){
	  return fac;
  }
  
  //Registrar servicios
  public IMateservice getMateservice(){
	  return new Mateservice();
  }
}
