package by.epam.bakun.multiThreading.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ReaderTest {

    @Test(description = "try to read file")
    public void parseTest() {
        String path = "./src/by/epam/bakun/multiThreading/data/MatrixData";
        boolean actual = ((new File(path)).exists()) ;
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }


}