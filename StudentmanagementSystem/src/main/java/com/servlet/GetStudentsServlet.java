package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;

/**
 * Servlet implementation class GetStudentsServlet
 */
@WebServlet("/GetStudentsServlet")
public class GetStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO = new StudentDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetStudentsServlet() {
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
		List<Student> students = studentDAO.getAllStudents();

		response.setContentType("application/json");

		PrintWriter out = response.getWriter();

		out.print("[");

		for (int i = 0; i < students.size(); i++) {

			Student student = students.get(i);

			out.print("{");

			out.print("\"id\":" + student.getId() + ",");

			out.print("\"name\":\"" + student.getName() + "\",");

			out.print("\"email\":\"" + student.getEmail() + "\",");

			out.print("\"department\":\"" + student.getCourse() + "\",");

			out.print("\"salary\":" + student.getPhone());

			out.print("}");

			if (i < students.size() - 1) {

				out.print(",");
			}
		}

		out.print("]");

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
