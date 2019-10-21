package by.epam.bakun.multiThreading.entity;

import org.apache.log4j.Logger;

public class MatrixThread extends Thread {

    static Logger logger = Logger.getLogger(MatrixThread.class.getName());

    int valueOfElement;

    public MatrixThread() {
        super();
    }

    public int numberOfThread (Thread thread) { //this method convert name of Thread (String "Thread-1" -> int 1)
        String name = thread.getName();
        String[] p = name.split("-");
        return Integer.parseInt(p[1]);
    }

    public void run() {
        logger.debug("begin run");
        ArrayOfDiagonal matrix = ArrayOfDiagonal.getArray();
        this.valueOfElement = numberOfThread(Thread.currentThread())+10;
        for (int i = 0; i < ArrayOfDiagonal.numberOfElement; i++) {
            if ((matrix.getValueOfElement(i)==0) && (matrix.getElement(i).lock.tryLock())) {
                logger.debug(Thread.currentThread().getName() + " set a new value "
                        + (valueOfElement) + " in element N:" + i);
                matrix.setElement(i,valueOfElement);
            } else {
                logger.debug(Thread.currentThread().getName()
                        + " doesn't set a new value in element N:" + i);
            }
        }
    }
}
