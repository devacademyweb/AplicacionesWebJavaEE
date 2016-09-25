package com.dev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.Categoria;
import com.dev.model.categoriaModel;

/**
 * Servlet implementation class homeController
 */
@WebServlet("/home")
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private categoriaModel cmodel = null;
	private String mensaje = null;
	private String destino = "/catalogo.jsp";

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel = new categoriaModel();
	}

	public homeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();

		try {

			switch (path) {
			case "/home":
				mensaje = list(request, cmodel);
				break;

			}
			if (mensaje != null) {
				request.setAttribute("mensaje", mensaje);
			} else {
				request.removeAttribute("mensaje");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	protected String list(HttpServletRequest request, categoriaModel cmodel)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String error = null;

		List<Categoria> list = cmodel.Listarcategorias();
		if (list != null) {
			request.setAttribute("liscategorias", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
