package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    public Employee getById(int id) {
        return employeeDao.findById(id);
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public void update(int id, Employee employee) {
        employeeDao.update(id, employee);
    }

    public void delete(int id) {
        employeeDao.delete(id);
    }
}
