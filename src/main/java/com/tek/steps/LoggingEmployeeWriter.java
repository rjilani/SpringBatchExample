package com.tek.steps;

import com.tek.dto.employee.Employee;
import com.tek.util.PersistEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * This custom {@code ItemWriter} writes the information of the Employee to
 * the log.
 *
 * @author Rashid Jilani
 */
public class LoggingEmployeeWriter implements ItemWriter<Employee> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    int n = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingEmployeeWriter.class);

    @Override
    public void write(List<? extends Employee> items) throws Exception {
        LOGGER.info(jdbcTemplate.toString());
        LOGGER.info("Received the information of {} employee", items.size());


        if (items.get(0).getName() != null) {
            PersistEmployee.wrtieToFile(items.toString());
        }


        items.forEach(i -> {
                    LOGGER.info("Received the information of a employee: {}", i);

//                   This block of code demonstrate the transaction failure, and the transaction boundaries related to chunk
//                    n++;
//                    if (n > 3) {
//                        throw new RuntimeException();
//                    }

                    jdbcTemplate.update(
                            "INSERT INTO people (name, emailAddress, title) VALUES (?, ?, ?)",
                            i.getName(), i.getEmailAddress(), i.getTitle()
                    );
                }

        );
    }
}
