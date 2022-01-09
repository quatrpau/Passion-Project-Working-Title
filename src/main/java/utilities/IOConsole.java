package utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//add color functionality
//make static
//make enum?
public final class IOConsole {
    private final Scanner input;
    private final  PrintStream output;
    private final AnsiColor ansiColor;

    public IOConsole() {
        this(AnsiColor.AUTO);
    }

    public IOConsole(AnsiColor ansiColor) {
        this(ansiColor, System.in, System.out);
    }

    public IOConsole(AnsiColor ansiColor, InputStream in, PrintStream out) {
        this.ansiColor = ansiColor;
        this.input = new Scanner(in);
        this.output = out;
    }
    public void printReg(String val, Object... args){
        output.format(val, args);
    }
    public void print(String val, Object... args) {
        //try to make it so that new lines are printed regularly
        output.format(ansiColor.getColor() + val + "\u001b[0m", args);
    }
    public void println(String val, Object... vals) {
        print(val, vals);
        printReg("\n",vals);
    }
    public void printCheckError() { println("Try using 'check' for items in your inventory");}

}
