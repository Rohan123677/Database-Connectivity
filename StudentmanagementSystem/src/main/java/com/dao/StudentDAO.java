package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.model.Student;

public class StudentDAO {

	// ================= CREATE =================

	public boolean addStudent(Student student) {

		String sql = "INSERT INTO students " + "(name, email, course, phone) " + "VALUES (?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();

				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setString(3, student.getCourse());
			statement.setString(4, student.getPhone());

			int rowsAffected = statement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// ================= READ ALL =================

	public List<Student> getAllStudents() {

		List<Student> studentList = new ArrayList<>();

		String sql = "SELECT * FROM students";

		try (Connection connection = DBConnection.getConnection();

				PreparedStatement statement = connection.prepareStatement(sql);

				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {

				Student student = new Student();

				student.setId(resultSet.getInt("id"));

				student.setName(resultSet.getString("name"));

				student.setEmail(resultSet.getString("email"));

				student.setCourse(resultSet.getString("course"));

				student.setPhone(resultSet.getString("phone"));

				studentList.add(student);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return studentList;
	}

	// ================= READ BY ID =================

	public Student getStudentById(int id) {

		Student student = null;

		String sql = "SELECT * FROM students WHERE id = ?";

		try (Connection connection = DBConnection.getConnection();

				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				student = new Student();

				student.setId(resultSet.getInt("id"));

				student.setName(resultSet.getString("name"));

				student.setEmail(resultSet.getString("email"));

				student.setCourse(resultSet.getString("course"));

				student.setPhone(resultSet.getString("phone"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return student;
	}

	// ================= UPDATE =================

	public boolean updateStudent(Student student) {

		String sql = "UPDATE students SET  name = ?, email = ?, course = ?, phone = ? WHERE id = ?";

		try (Connection connection = DBConnection.getConnection();

				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, student.getName());

			statement.setString(2, student.getEmail());

			statement.setString(3, student.getCourse());

			statement.setString(4, student.getPhone());

			statement.setInt(5, student.getId());

			int rowsAffected = statement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// ================= DELETE =================

	public boolean deleteStudent(int id) {

		String sql = "DELETE FROM students WHERE id = ?";

		try (Connection connection = DBConnection.getConnection();

				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, id);

			int rowsAffected = statement.executeUpdate();

			return rowsAffected > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}