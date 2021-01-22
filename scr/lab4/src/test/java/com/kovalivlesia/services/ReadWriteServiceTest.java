package com.kovalivlesia.services;

import org.junit.Test;

import java.io.IOException;

public class ReadWriteServiceTest {
    public static String filename = "src/test/resources/test_in.txt";
    public static String filenameWriter = "src/test/resources/w_test_in.txt";

    @Test
    public void testRead() throws IOException {
        ReadAndWriteService.readFromFile(filename);
    }

    @Test
    public void testWrite() throws IOException {
        ReadAndWriteService.writeToFile(filenameWriter);
    }
}
