package utilities;

import models.Player;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
public final class InputTaker {
    private static final String HELP = "Available Commands: \n" +
    "check: check an item in your inventory \n" +
    "stats: get your status \n" +
    "look: check environment or an item in the environment \n" +
    "use: use an item in your inventory \n" +
    "\t use ___ on ___: for item interactions \n" +
    "go: move between environments \n" +
    "help: triggers this command \n" +
    "Feel free to experiment with these commands and discover alternative versions!";
    private static final IOConsole console = AnsiColor.BLACK_AND_WHITE.ioConsole;
    private static final Scanner inputTaker = new Scanner(System.in);
    public static String getPlayerInput(){
        String choice = inputTaker.nextLine().toLowerCase(Locale.ROOT);
        if(isPlayerCommand(choice)){
            return null;
        }
        return lookCheck(choice);
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
                console.println("what?");
                return null;
        }
    }
    private static Boolean isPlayerCommand(String input){
        input = input.toLowerCase(Locale.ROOT);
        if (input.equals("status") || input.equals("stats")){
            Player.getYou().statusUpdate();
            return true;
        }
        String[] wordar = input.split(" ");
        if(wordar.length == 2 && (wordar[0].equals("check"))){
            Player.getYou().describeItem(wordar[1]);
            return true;
        }
        if(input.equals("help")){
            console.println(HELP);
            return true;
        }
        return false;
    }
    public static boolean getYesOrNo(){
        return Boolean.TRUE.equals(yesOrNo(Objects.requireNonNull(getPlayerInput())));
    }
    //global verb check (status, stat, inventory, //look around, //exit)
    private static String lookCheck(String raw){
        String looker = raw.split(" ")[0];
        if(looker.equals("observe") || looker.equals("describe") || looker.equals("inspect")){
            return raw.replace(looker,"look");
        }
        return raw;
    }
}
//implement exit;
