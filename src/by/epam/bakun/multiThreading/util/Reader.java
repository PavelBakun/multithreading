package by.epam.bakun.multiThreading.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    static Logger logger = Logger.getLogger(Reader.class.getName());

    ArrayList<String[]> listRow = new ArrayList<>();
    Scanner scn;
    String path;

    public Reader(String path) {
        this.path = path;
    }

    public ArrayList<String[]> readFile() {
        try {
            logger.debug("try to read the file");
            scn = new Scanner((new File(path)));
        } catch (Exception e) {
            logger.debug("FileException");
        }

        //begin to reade
        while (scn.hasNext()) {
            String row = scn.nextLine();
            String[] value = row.split("\\s+");
            listRow.add(value);
        }
        return listRow;
    }
}
