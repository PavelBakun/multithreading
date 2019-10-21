package by.epam.bakun.multiThreading.entity;

import org.apache.log4j.Logger;

public class ComplitterOfDiagonal {

    static Logger logger = Logger.getLogger(ComplitterOfDiagonal.class.getName());

    public void compliteOfDiagonal(int numberOfThread) {

        logger.debug("get Array of Diagonal");
        ArrayOfDiagonal matrix = ArrayOfDiagonal.getArray();
        Thread[] arrayOfThread = new Thread[numberOfThread];
        logger.debug("create new threads");
        for (int i = 0; i < arrayOfThread.length; i++) {
            arrayOfThread[i] = new MatrixThread();
            arrayOfThread[i].start();
        }
        for (int i = 0; i < arrayOfThread.length; i++) {
            try {
                arrayOfThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < matrix.numberOfElement; i++) {
            logger.debug(" " + matrix.getValueOfElement(i));
        }
    }
}
