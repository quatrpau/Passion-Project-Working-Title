package utilities;

import models.Player;

import java.util.Locale;
import java.util.Scanner;
public final class InputTaker {
    private static final Scanner inputTaker = new Scanner(System.in);
    public static String getPlayerInput(){
        return inputTaker.nextLine().toLowerCase(Locale.ROOT);
    }
    public static String getPlayerName(){
        return inputTaker.nextLine();
    }
    //translate player input here
    private static Boolean yesOrNo(String input){
        switch(input.toLowerCase(Locale.ROOT)){
            case "y": case "yes":
                return true;
            case "n": case "no":
                return false;
            default:
                Display.print("what?");
                return null;
        }
    }
    private static Boolean isPlayerCommand(String input){
        input = input.toLowerCase(Locale.ROOT);
        if (input.equals("status") || input.equals("stats"){
            Player.getYou().statusUpdate();
            return true;
        }
        String[] wordar = input.split(" ");
        if(wordar.length == 2 && (wordar[0].equals("check") || wordar[0].equals("look")){
            Player.getYou().describeItem(wordar[1]);
            return true;
        }

    }
    public static boolean getYesOrNo(){
        return Boolean.TRUE.equals(yesOrNo(getPlayerInput()));
    }
    //global verb check (status, stat, inventory, //look around, //exit)
}
