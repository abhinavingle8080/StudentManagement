package com.nctech.studentmanagement.repository.impl;

import com.nctech.studentmanagement.dto.StudentDTO;
import com.nctech.studentmanagement.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private Connection getConnection() throws SQLException {
        // Establish a connection to your Oracle database
        String url = "jdbc:h2:file:./stddb"; // Replace with your database connection URL
        String username = "sa";
        String password = "sa";
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public void save(StudentDTO student) {
        try (Connection connection = getConnection()) {
            // Prepare the SQL statement to insert data into the database
//            String sql = "INSERT INTO StudentManagement (ID, FIRSTNAME, MIDDLENAME, LASTNAME, GENDER, DOB, AGE, EMAIL, CONTACT, FATHERNAME, HIGHESTEDUCATION, CURRENTEDUCATION, FAMILYEDUCATION, ANNUALINCOME, ADDRESS) VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
            String sql = "INSERT INTO StudentManagement VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getMiddleName());
            statement.setString(4, student.getLastName());
            statement.setString(5, student.getGender());
            statement.setString(7, student.getDob());
            statement.setInt(6, student.getAge());
            statement.setString(8, student.getEmail());
            statement.setString(9, student.getContact());
            statement.setString(10, student.getFatherName());
            statement.setString(11, student.getHighestEducation());
            statement.setString(12, student.getCurrentEducation());
            statement.setString(13, student.getFamilyEducation());
            statement.setDouble(14, student.getAnnualIncome());
            statement.setString(15, student.getAddress());

            // Execute the SQL statement
            statement.executeUpdate();
            System.out.println("Saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StudentDTO> get() {
        List<StudentDTO> students = new ArrayList<>();

        try (Connection connection = getConnection()) {
            // Prepare the SQL statement to retrieve data from the database
            String sql = "SELECT id, firstName, middleName, lastName, gender, dob, age, email, contact, fatherName, highestEducation, currentEducation, familyEducation, annualIncome, address FROM StudentManagement";
            Statement statement = connection.createStatement();

            // Execute the SQL statement
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String middleName = resultSet.getString("middleName");
                String lastName = resultSet.getString("lastName");
                String gender = resultSet.getString("gender");
                String dob = resultSet.getString("dob");
                Integer age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String contact = resultSet.getString("contact");
                String fatherName = resultSet.getString("fatherName");
                String highestEducation = resultSet.getString("highestEducation");
                String currentEducation = resultSet.getString("currentEducation");
                String familyEducation = resultSet.getString("familyEducation");
                Double annualIncome = resultSet.getDouble("annualIncome");
                String address = resultSet.getString("address");

                StudentDTO student = new StudentDTO(id, firstName, middleName, lastName, gender, dob, age, email, contact, fatherName, highestEducation, currentEducation, familyEducation, annualIncome, address);
                students.add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}

