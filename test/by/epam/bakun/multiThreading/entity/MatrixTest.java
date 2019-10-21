package by.epam.bakun.multiThreading.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixTest {

    @Test(description = "each thread must to push new Value in matrix")
    public void testSetMatrix() {
        String path = "./src/by/epam/bakun/multiThreading/data/MatrixData";
        Matrix matrix = new Matrix(path);
        matrix.setMatrix();

        ArrayOfDiagonal list = ArrayOfDiagonal.getArray();
        int firstElem = list.getValueOfElement(0);
        boolean actual = false;
        int index = 1;
        while (firstElem == list.getValueOfElement(index)) {
            actual = true;
            index += 1;
        }
        boolean expected = false;
        Assert.assertEquals(actual, expected);
    }
}
