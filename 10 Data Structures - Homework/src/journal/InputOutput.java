package journal;

import java.util.Scanner;

public class InputOutput {

    private Scanner sc;

    public InputOutput() {
        this.sc = new Scanner(System.in);
    }

    public void show(String text){
        System.out.println(text);
    }

    public String getTextInput(){
        return sc.nextLine();
    }

    public int getDecimalInput(){
        return Integer.parseInt(getTextInput());
    }
}
