package com.employee.service.impl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.employee.exception.BadRequestException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.dto.EmployeeDto;
import com.employee.model.entity.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepo employeeRepository;
	private final ModelMapper modelMapper;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepository,ModelMapper modelMapper) {
		this.employeeRepository=employeeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		if(employeeDto.getId() != null) {
			throw new RuntimeException("Employee already exist");
		}
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee savedEntity = employeeRepository.save(entity);
		
		return modelMapper.map(savedEntity, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		if(employeeDto.getId() == null || id == null) {
			throw new BadRequestException("Please provide employee id");
		}
		
		if(Objects.equals(id, employeeDto.getId())) {
			throw new BadRequestException("Id Mismatch");
		}
		
		 employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found With Id: "+id));
		
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee updatedEntity = employeeRepository.save(entity);
		
		return modelMapper.map(updatedEntity, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee emp =  employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found With Id : "+id));
		employeeRepository.delete(emp);
		
	}

	@Override
	public EmployeeDto getSingleEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee emp =  employeeRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("Employee Not Found With Id : "+id));

		return modelMapper.map(emp, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty()) {
			throw new ResourceNotFoundException("No Employees Found");
		}
		List<EmployeeDto> dtoList = employees.stream().map( emp -> modelMapper.map(emp, EmployeeDto.class)).toList();
		
		return dtoList;
	}

}
