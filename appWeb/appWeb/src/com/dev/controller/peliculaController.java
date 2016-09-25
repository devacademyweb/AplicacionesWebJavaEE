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
import com.dev.dto.Pelicula;
import com.dev.model.categoriaModel;
import com.dev.model.peliculaModel;

@WebServlet({ "/newp", "/insertp", "/listp" })
public class peliculaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private categoriaModel cmodel = null;
	private peliculaModel pmodel = null;
	private String mensaje = null;
	private String destino = "/panelp.jsp";

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel = new categoriaModel();
		pmodel = new peliculaModel();
	}

	public peliculaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		try {
			switch (path) {
			case "/newp":
				mensaje = listc(request, cmodel);
				destino = "createp.jsp";
				break;
			case "/insertp":
				insert(request);
				mensaje = listp(request, pmodel);
				destino = "/panelp.jsp";
				break;
			case "/listp":
				mensaje = listp(request, pmodel);
				destino = "/panelp.jsp";
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

	protected void insert(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Pelicula pel = new Pelicula();
		Categoria cate = new Categoria();
		pel.setNombre(request.getParameter("nombre"));
		pel.setPrecio(Double.parseDouble(request.getParameter("precio")));
		pel.setStock(Integer.parseInt(request.getParameter("stock")));
		pel.setImagen(request.getParameter("imagen"));

		cate.setId(Integer.parseInt(request.getParameter("categoria")));

		pel.setIdcategoria(cate);

		pmodel.RegistrarPelicula(pel);

	}

	protected String listc(HttpServletRequest request, categoriaModel cmodel)
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

	protected String listp(HttpServletRequest request, peliculaModel pmodel)
			throws ServletException, IOException, SQLException {
		String error = null;

		List<Pelicula> list = pmodel.Listarpeliculas();

		if (list != null) {
			request.setAttribute("lispeliculas", list);
		} else {
			error = "Sin acceso a base de datos";
		}

		return error;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
