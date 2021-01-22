package com.kovalivlesia.menu;

import com.kovalivlesia.Main;
import com.kovalivlesia.RepoBasedTest;
import com.kovalivlesia.services.ReadWriteServiceTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MenuTest extends RepoBasedTest {
    static InputStream def = System.in;

    @BeforeClass
    public static void beforeClass() {
        String in = "2\r\n1\r\n" + ReadWriteServiceTest.filenameWriter +
                "\r\n2\r\n2\r\n" + ReadWriteServiceTest.filename +
                "\r\n3\r\n1\r\n" +
                "4\r\n1\r\n0\r\n0\r\n" +
                "0";
        System.setIn(new ByteArrayInputStream(in.getBytes()));
    }

    @Test
    public void testMenu() {
        Main.main(new String[]{});
    }

    @AfterClass
    public static void afterAll() {
        System.setIn(def);
    }
}
