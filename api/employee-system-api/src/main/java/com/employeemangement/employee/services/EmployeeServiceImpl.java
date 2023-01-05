package com.employeemangement.employee.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.employeemangement.employee.entity.EmployeeEntity;
import com.employeemangement.employee.model.Employee;
import com.employeemangement.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }
    
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity =  new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }



}