package com.devacademyweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devacademyweb.factory.Factory;
import com.devacademyweb.service.IMateservice;
import com.devacademyweb.service.impl.Mateservice;


/**
 * Servlet implementation class Servlemate
 */
@WebServlet({"/Basico","/Factorial"})
public class Servlemate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlemate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path=request.getServletPath();
		if(path.equals("/Basico")){
			basico(request,response);
		}else if(path.equals("/Factorial")){
			factorial(request, response);
		}
	}

	protected void basico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacion=null;
		int rpta=0,n1=0,n2=0,opera=0;
		
		try {
			//Datos
			opera=Integer.parseInt(request.getParameter("opera"));
			n1=Integer.parseInt(request.getParameter("n1"));
			n2=Integer.parseInt(request.getParameter("n2"));
			
			//Proceso
			IMateservice service=Factory.getInstance().getMateservice();//new Mateservice();
			if(opera==1){
				operacion="suma";
				rpta=service.sumar(n1, n2);
			}else if(opera==2){
				operacion="producto";
				rpta=service.producto(n1, n2);
			}else{
				operacion="no se";
				rpta=0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			operacion="Desconocida";
			rpta=0;
		}
		
		//Salida
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>MATEMATICA</h1>");
		out.println("N1:"+n1+"</br>");
		out.println("N2:"+n2+"</br>");
		out.println("Operacion:"+operacion+"</br>");
		out.println("Rpta:"+rpta+"</br>");
	}
	
	protected void factorial(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int n = 0;
		long f = 0;
		String mensaje = null;
		try {
			// Datos
			n = Integer.parseInt(request.getParameter("n"));
			// Proceso
			IMateservice service = Factory.getInstance().getMateservice();//new Mateservice();
			f = service.factorial(n);
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		// Salida
		PrintWriter out;
		out = response.getWriter();
		response.setContentType("text/html");
		out.print("<h1>MATEMATICA</h1>");
		if (mensaje == null) {
			out.print("N: " + n + "<br/>");
			out.print("Factorial: " + f + "<br/>");
		} else {
			out.print("Error: " + mensaje + "<br/>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
