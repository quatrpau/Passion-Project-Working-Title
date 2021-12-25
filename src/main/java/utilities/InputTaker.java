package utilities;

import java.util.Locale;
import java.util.Scanner;

public class InputTaker {
    private final Scanner inputTaker;
    public InputTaker() {
        this.inputTaker = new Scanner(System.in);
    }
    public String getPlayerInput(){
        return inputTaker.nextLine();
    }
    //translate player input here
    //how to boot player back out?
    private boolean yesOrNo(String input){
        switch(input.toLowerCase(Locale.ROOT)){
            case "y": case "yes":
                return true;
            case "n": case "no":
                return false;
            default:
                System.out.println("what?");
                return false;
        }
    }
    public boolean getYesOrNo(){
        return yesOrNo(getPlayerInput());
    }
}
