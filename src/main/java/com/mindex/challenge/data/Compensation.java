package com.mindex.challenge.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Compensation {

	private Employee employee;
	private int salary;


	private String effectiveDate; //Keeping it string as no description was given. Can use Date types instead.

	public Compensation(){

	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

}