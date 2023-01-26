package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * ServiceImpl class to get the employee information from DB.
 * It has two methods getDirectReports and findNumberOfReports.
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    /** getDirectReports takes employee id as parameter and fetches the data if the employee id exists
     *  if the employeeId doesn't exist it will throw an Exception
     */

    @Override
    public ReportingStructure getDirectReports(String id) {
        LOG.debug("Getting report structure for id [{}]: ",id);
        ReportingStructure report = new ReportingStructure();
        Employee employee = employeeRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        report.setEmployee(employee);
        int numberOfReports = findNumberOfReports(employee);
        report.setNumberOfReports(numberOfReports);
        return report;
    }

    /**
     * findNumberOfReports will fetch the direct reports for the employee passed as the parameter, and will
     * check if they have any direct reports as well by recursively calling findNumberOfReports
     * and update the employee structure with the employee information.
     */
    public int findNumberOfReports(Employee employee){
        List<Employee> directReports = employee.getDirectReports();
        if (directReports == null || directReports.size()==0){
            return 0;
        }
        int numberOfReportsCount = 0;

        for(Employee directReport:directReports){
            Employee emp = employeeRepository.findByEmployeeId(directReport.getEmployeeId());

            directReport.setFirstName(emp.getFirstName());
            directReport.setLastName(emp.getLastName());
            directReport.setPosition(emp.getPosition());
            directReport.setDepartment(emp.getDepartment());
            directReport.setDirectReports(emp.getDirectReports());

            numberOfReportsCount += findNumberOfReports(emp) + 1;
        }
        return numberOfReportsCount;
    }
}