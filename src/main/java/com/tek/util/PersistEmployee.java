package com.tek.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class PersistEmployee {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersistEmployee.class);
    public static void wrtieToFile(String s){

        Date date = new Date();
        long msec = date.getTime();


        try {
            File file = new File("employee-" + msec +  ".txt");
            file.createNewFile();
            LOGGER.info("file get created in the folder named: {}", file.getAbsolutePath());
            Files.write(Paths.get(file.getAbsolutePath()), s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            LOGGER.error("An error occurred.");

        }


    }
}
