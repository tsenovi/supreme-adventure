package eDiary.inputoutput;

import java.util.List;

public interface InputOutput {
    void show(String text);

    <T> void printList(List<T> list);

    String getTextInput();

    int getDecimalInput();

    <T> int getListIndexInput(List<T> list);
}
