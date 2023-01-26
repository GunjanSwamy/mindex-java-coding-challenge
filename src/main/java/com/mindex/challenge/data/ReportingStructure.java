package com.mindex.challenge.data;
import java.util.List;

/**
 * Task#1 Reporting Structure having two properties Employee and number of reports.
 */
public class ReportingStructure {
	public ReportingStructure() {
	}

	private Employee employee;
	private int numberOfReports;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setNumberOfReports(int numberOfReports) {
		this.numberOfReports = numberOfReports;
	}
	public int getNumberOfReports() {
		return numberOfReports;
	}

}