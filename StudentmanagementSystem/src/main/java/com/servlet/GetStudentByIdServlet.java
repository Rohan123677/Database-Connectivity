package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;

/**
 * Servlet implementation class GetStudentByIdServlet
 */
@WebServlet("/GetStudentByIdServlet")
public class GetStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO = new StudentDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetStudentByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		Student student = studentDAO.getStudentById(id);

		response.setContentType("application/json");

		PrintWriter out = response.getWriter();

		if (student != null) {

			out.print("{");

			out.print("\"id\":" + student.getId() + ",");

			out.print("\"name\":\"" + student.getName() + "\",");

			out.print("\"email\":\"" + student.getEmail() + "\",");

			out.print("\"department\":\"" + student.getCourse() + "\",");

			out.print("\"salary\":" + student.getPhone());

			out.print("}");

		} else {

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);

			out.print("{\"message\":\"Student not found\"}");
		}

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
