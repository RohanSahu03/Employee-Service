package com.employee.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class EmployeeDto {
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public EmployeeDto(Long id, String empName, String empEmail, String empCode, String companyName) {
		super();
		this.id = id;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empCode = empCode;
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empEmail=" + empEmail + ", empCode=" + empCode
				+ ", companyName=" + companyName + "]";
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	private String empName;
	private String empEmail;
	private String empCode;
	private String companyName;

}
