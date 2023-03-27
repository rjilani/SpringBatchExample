package com.tek.steps;

import com.tek.dto.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * This custom {@code ItemProcessor} simply writes the information of the
 * processed employee to the log and returns the processed object.
 *
 * @author Rashid Jilani
 */
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProcessor.class);

    @Override
    public Employee process(Employee item) throws Exception {
        LOGGER.info("Processing employee information: {}", item);
        return item;
    }
}
