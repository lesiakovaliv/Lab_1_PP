package com.kovalivlesia;

import com.kovalivlesia.services.ReadAndWriteService;
import com.kovalivlesia.services.ReadWriteServiceTest;
import lombok.extern.java.Log;
import org.junit.BeforeClass;

import java.io.IOException;

@Log
public class RepoBasedTest {

    @BeforeClass
    public static void beforeClass() throws IOException {
        log.info("Start repo fill");
        ReadAndWriteService.readFromFile(ReadWriteServiceTest.filename);
    }
}
