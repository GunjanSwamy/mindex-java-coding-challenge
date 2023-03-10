package com.mindex.challenge.service.impl;

        import com.mindex.challenge.dao.CompensationRepository;
        import com.mindex.challenge.data.Employee;
        import com.mindex.challenge.data.Compensation;
        import com.mindex.challenge.service.EmployeeService;
        import com.mindex.challenge.service.CompensationService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * Create compensation for the employee
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation: [{}]", compensation);

        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(employee);
        compensationRepository.insert(compensation);
        return compensation;
    }


    /**
     *  Takes employeeID as parameter and reads the compensation for the employee
     *  if the employee or compensation doesn't exist it will throw an exception
     */
    @Override
    public Compensation read(String employeeId) {
        LOG.debug("Reading compensation with employeeId: [{}]", employeeId);

        Employee employee = employeeService.read(employeeId);
        Compensation compensation = compensationRepository.findByEmployee(employee);

        if (compensation == null) {
            throw new RuntimeException("No compensation on record for employeeId: " + employeeId);
        }

        return compensation;
    }

}