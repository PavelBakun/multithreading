package by.epam.bakun.multiThreading.entity;

public class ArrayOfDiagonal {
    public static int  numberOfElement = Matrix.getNumberOfElement();
    private Element[] array;
    private static ArrayOfDiagonal ar = new ArrayOfDiagonal();

    private ArrayOfDiagonal() {
        super();
        array = new Element[numberOfElement];
        for (int i = 0; i < numberOfElement; i++) {
            array[i] = new Element();
       }
    }
    public static ArrayOfDiagonal getArray() {
        return ar;
    }
    public Element[] getArrayOfElement() {
        return array;
    }
    public Element getElement(int index) {
        return array[index];
    }
    public int getValueOfElement(int index) {
        return array[index].getElement();
    }

    public void setElement(int index, int elem) {
        array[index].setElement(elem);
    }
}
