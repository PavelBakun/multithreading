package by.epam.bakun.multiThreading.entity;

import by.epam.bakun.multiThreading.util.Reader;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Matrix {

    static Logger logger = Logger.getLogger(Matrix.class.getName());

    private int numberOfRow;
    private int numberOfColumn;
    private static String path;
    private int[][] matrix;
    private static int numberOfThread;
    private static int numberOfElement; //number of diagonal elements

    //make singleton
    public static final Matrix MATRIX = new Matrix(path);

    public Matrix(String path) {
        Matrix.path = path;
    }

    public ArrayList<String[]> getDataFromFile() {
        Reader reader = new Reader(path);
        ArrayList<String[]> array = reader.readFile();
        setNumberOfRow(array.size());
        setNumberOfColumn(array.get(1).length);
        numberOfElement = (numberOfColumn > numberOfRow) ? numberOfRow: numberOfColumn;
        return array;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow - 1;
    } // -1  - because in first row there is not matrix information (number of thread)

    public void setNumberOfColumn(int numberOfColumn) {
        this.numberOfColumn = numberOfColumn;
    }

    public static int getNumberOfElement() {
        return numberOfElement;
    }

    public int[][] setMatrix() {
        ArrayList<String[]> array = getDataFromFile();

        { //in this block read "numberOfThread" from file
            String[] firstRow = array.get(0);
            StringBuilder sb = new StringBuilder();
            for (String el : firstRow) {
                sb.append(el);
            }
            String[] parse = sb.toString().split("-");
            numberOfThread = Integer.parseInt(parse[1]);//take "int number" element of row: "Number of Thread: 6"
        }

        int i = 1;
        this.matrix = new int[numberOfRow][numberOfColumn];
        for (i = 1; i < numberOfRow+1; i++) {
            for(int j = 0; j < numberOfColumn; j++) {
                matrix[i-1][j] = Integer.parseInt(array.get(i)[j]);
            }
        }
        setDiagonal();
        return matrix;
    }
    public void setDiagonal() {
        ComplitterOfDiagonal complite = new ComplitterOfDiagonal();
        ArrayOfDiagonal matr = ArrayOfDiagonal.getArray();
        complite.compliteOfDiagonal(numberOfThread);
        for (int i = 0; i < numberOfElement; i++)
        matrix[i][i] = matr.getValueOfElement(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int elem : row) {
                sb.append(elem);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
