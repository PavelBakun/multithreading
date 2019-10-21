package by.epam.bakun.multiThreading.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Element {

    static Logger logger = Logger.getLogger(Element.class.getName());

    private int element = 0;
    public Lock lock = new ReentrantLock();

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        try {
            logger.debug("try to set element");
            lock.lock();
            TimeUnit.MILLISECONDS.sleep(200);
            this.element = element;
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.debug("InterruptedException");
        } finally {
            lock.unlock();
        }
    }
}
