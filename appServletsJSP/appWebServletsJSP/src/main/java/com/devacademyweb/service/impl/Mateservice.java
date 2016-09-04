package com.devacademyweb.service.impl;

import com.devacademyweb.service.IMateservice;

public class Mateservice implements IMateservice {

	@Override
	public int sumar(int n1, int n2) {
		// TODO Auto-generated method stub
		return (n1+n2);
	}

	@Override
	public int producto(int n1, int n2) {
		// TODO Auto-generated method stub
		return (n1*n2);
	}

	@Override
	public long factorial(int n) {
		// TODO Auto-generated method stub
		long f=1;
		while(n>1){
			f*=n--;
		}
		return f;
	}

}
