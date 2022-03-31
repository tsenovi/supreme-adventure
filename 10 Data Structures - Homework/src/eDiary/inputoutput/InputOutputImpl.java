package eDiary.inputoutput;

import java.util.*;

public class InputOutputImpl implements InputOutput {

    private final Scanner sc;

    public InputOutputImpl() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).toString());
        }
    }

    @Override
    public String getTextInput() {
        return sc.nextLine();
    }

    @Override
    public int getDecimalInput() {
        String numberInput;
        do {
            numberInput = getTextInput();
        } while (!numberInput.matches("[0-9]+"));
        return Integer.parseInt(numberInput);
    }

    @Override
    public <T> int getListIndexInput(List<T> list) {
        int indexInput = getDecimalInput();
        while (indexInput < 1 || indexInput > list.size()) {
            show("Invalid input, try again: ");
            indexInput = getDecimalInput();
        }

        return indexInput - 1;
    }
}
