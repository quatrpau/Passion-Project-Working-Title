package utilities;

import java.util.Locale;
import java.util.Scanner;
//make functions static?
public final class InputTaker {
    private static final Scanner inputTaker = new Scanner(System.in);
    public static String getPlayerInput(){
        return inputTaker.nextLine().toLowerCase(Locale.ROOT);
    }
    public static String getPlayerName(){
        return inputTaker.nextLine();
    }
    //translate player input here
    //how to boot player back out?
    private static boolean yesOrNo(String input){
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
    public static boolean getYesOrNo(){
        return yesOrNo(getPlayerInput());
    }
    //somehow implement verb system
}
