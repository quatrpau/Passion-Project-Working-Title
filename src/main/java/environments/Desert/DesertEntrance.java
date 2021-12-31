//make this text yellow
package environments.Desert;
//maybe make a bunch of subenvironments?
import interfaces.Environment;
import models.Enemy;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;
//GO BACK (but not when deep in desert) (or at home text)
//divide desert by half days or days? (should be reflected in text descriptor)
public class DesertEntrance implements Environment {
    //should i have a map or a list of surroundingsStrings
    private String flavorText = "You spot the entrance for the desert demarcated by a sign that says \"Yellow-Orange Desert\". A desolate place stretching as far as the eye can see. " +
            "Next to the signpost, you see an older woman reading a newspaper in a wooden chair wearing a tattered straw hat.  \n" +
            "To your right, you see an abandoned cabin. To your left, a lone cactus. You must cross the desert to get to the dragon.  It will take 3 days by foot." ;
    //GO CABIN // GO RIGHT // RIGHT // MOVE RIGHT // CABIN //
    private Environment cabin = new Cabin();
    //GO CACTUS // GO LEFT // LEFT // MOVE LEFT // CACTUS //
    private Environment cactus = new Cactus();
    private Environment desert = new Desert();
    //have variable for woman?

    //kick door
    //force door
    //push door

    // how to represent things that you can use when you have but don't have yet(maybe [ITEM])
    private String cactusText = "You approach the cactus. You've heard that you can extract inside a cactus by cutting it open. If only you had a way to do that. \n" +
            "A large rock is propped up at the base of the cactus";
    //get rock: custom text, edit cactus text and text that says you have rock if you do get rock again
    //use rock on door: text; edit cabinOutside & text stating you can't do it again & allow entrance
        //maybe edit cabinOutside to cabinInside

    @Override
    public Battle triggerBattle(Enemy opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        Display.print(flavorText);
    }

    @Override
    public void setFlavorText(String flavorText) {

    }
    //have all the variants translate to GO whatever
    @Override
    public Boolean start() {
        boolean keepGoing = true;
        while(keepGoing) {
            giveFlavorText();
            Display.print("What will you do?");
            String decision;
            if((decision = inputRepair(InputTaker.getPlayerInput())) != null) {
                //if cabin
                if(decision.equals("GO CABIN")){
                    cabin.start();
                }
                //if woman
                //if cactus
                //if desert
                //reprint (look around)
                //confusion
            }
            else{
                Display.print("Invalid input: try again");
            }
        }
        return false;
    }
    private String inputRepair(String raw){
        if(raw.equals("GO CABIN")){
            return raw;
        }
        else{
            return null;
        }
    }
}
//desert enemies
    //snake
    //giant scorpion
    //vulture

//implement monetary system? //must find way to make money