package by.epam.bakun.multiThreading.runner;

import by.epam.bakun.multiThreading.entity.Matrix;

public class Runner {
    public static void main(String[] args) {
        String path = "./src/by/epam/bakun/multiThreading/data/MatrixData";
        Matrix matrix = new Matrix(path);
        matrix.setMatrix();
        System.out.println(matrix.toString());
    }
}
