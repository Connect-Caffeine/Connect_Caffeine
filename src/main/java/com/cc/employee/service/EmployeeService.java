package com.cc.employee.service;

import org.springframework.stereotype.Service;

import com.cc.calendar.domain.CalendarDto;
import com.cc.employee.domain.Employee;
import com.cc.employee.domain.EmployeeDto;
import com.cc.employee.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
//	private final PasswordEncoder passwordEncoder;
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(
			EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeDto findByempName(String emp_name) {
		Employee employee = employeeRepository.findByempName(emp_name);
		
		EmployeeDto dto = EmployeeDto.builder()
						.emp_code(employee.getEmpCode())
						.build();
		return dto;
	}
	
}
