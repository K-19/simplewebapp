package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee findById(int id) {
        return jdbcTemplate.query("SELECT * FROM employee WHERE employee_id=?", new Object[]{id}, new EmployeeMapper())
                .stream().findAny().orElse(new Employee());
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES(?, ?, ?, ?, ?, ?)",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getGender().toString(),
                employee.getDateOfBirth());
    }

    public void update(int id, Employee employee) {
        jdbcTemplate.update("UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getGender().toString(),
                employee.getDateOfBirth(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", id);
    }
}
