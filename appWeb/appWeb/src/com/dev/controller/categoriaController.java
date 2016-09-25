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

@WebServlet({ "/newc", "/insertc", "/editc", "/updatec", "/removec", "/deletec", "/readc", "/listc", })
public class categoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private categoriaModel cmodel = null;
	private String mensaje = null;
	private String destino = "/panelc.jsp";

	public categoriaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel = new categoriaModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newc")) {
				destino = "createc.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertc")) {
				insert(request);
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";
				System.out.println("panelc");

			} else if (path.equals("/editc")) {
				read(request, cmodel);
				destino = "/updatec.jsp";
			} else if (path.equals("/updatec")) {
				update(request);
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";

			} else if (path.equals("/removec")) {
				read(request, cmodel);
				destino = "/deletec.jsp";
			} else if (path.equals("/deletec")) {
				delete(request);
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";

			} else if (path.equals("/listc")) {
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";
			} else if (path.equals("/readc")) {
				read(request, cmodel);
				destino = "/readc.jsp";
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
		Categoria cate = new Categoria();
		cate.setNombre(request.getParameter("nombre"));
		cmodel.RegistrarCategoria(cate);
	}

	protected void update(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Categoria cate = new Categoria();
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		cate.setId(id);
		cate.setNombre(nombre);

		cmodel.ActualizarCategoria(cate);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));

		cmodel.EliminarCategoria(id);
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

	protected String read(HttpServletRequest request, categoriaModel cmodel)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String error = null;

		int id=Integer.parseInt(request.getParameter("id"));
		Categoria cate = cmodel.BuscarCategoria(id);
		if (cate != null) {
			request.setAttribute("categoria", cate);
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
