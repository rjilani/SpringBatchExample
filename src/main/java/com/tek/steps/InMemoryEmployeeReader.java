package com.tek.steps;

import com.tek.dto.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates how we can create a custom item reader.
 *
 * @author Rashid Jilani
 */
public class InMemoryEmployeeReader implements ItemReader<Employee> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryEmployeeReader.class);

    private int nextemployeeIndex;
    private List<Employee> employee;

    public InMemoryEmployeeReader() {
        initialize();
    }

    private void initialize() {
        Employee jony = new Employee();
        jony.setEmailAddress("jony.tester@gmail.com");
        jony.setName("jony Tester");
        jony.setTitle("Tester");

        Employee rick = new Employee();
        rick.setEmailAddress("rick.newbie@gmail.com");
        rick.setName("Rick junior");
        rick.setTitle("junior devloper");

        Employee jane = new Employee();
        jane.setEmailAddress("jane.intermediate@gmail.com");
        jane.setName("jane Intermediate");
        jane.setTitle("intermediate developer");

        Employee tom = new Employee();
        tom.setEmailAddress("tom.po@gmail.com");
        tom.setName("tom Po");
        tom.setTitle("Produc Owner");

        Employee ram = new Employee();
        ram.setEmailAddress("ram.newbie@gmail.com");
        ram.setName("Ram dev");
        ram.setTitle("Ram devloper");

        Employee rekha = new Employee();
        rekha.setEmailAddress("rekha.intermediate@gmail.com");
        rekha.setName("rekha Intermediate");
        rekha.setTitle("rekha developer");

        Employee rich = new Employee();
        rich.setEmailAddress("rich.delivery@gmail.com");
        rich.setName("Rich Lead");
        rich.setTitle("Lead");

        Employee sonu = new Employee();
        sonu.setEmailAddress("sonu.newbie@gmail.com");
        sonu.setName("sonu dev");
        sonu.setTitle("sonu devloper");

        Employee javed = new Employee();
        javed.setEmailAddress("javed.senior@gmail.com");
        javed.setName("javed Senior");
        javed.setTitle("Senior developer");

        Employee raghav = new Employee();
        raghav.setEmailAddress("ragahav.senior@gmail.com");
        raghav.setName("Ragahav Senior");
        raghav.setTitle("Senior developer");


        employee = Collections.unmodifiableList(Arrays.asList(jony, rick, jane, tom, ram, rekha, rich, sonu, javed, raghav));
        nextemployeeIndex = 0;
    }

    @Override
    public Employee read() throws Exception {
        LOGGER.info("Reading the information of the next employee");

        Employee nextemployee = null;

        if (nextemployeeIndex < employee.size()) {
            nextemployee = employee.get(nextemployeeIndex);
            nextemployeeIndex++;
        }

        LOGGER.info("Found employee: {}", nextemployee);

        return nextemployee;
    }
}
