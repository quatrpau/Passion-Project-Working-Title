//make this text yellow
package environments.desert;
import interfaces.Environment;
import models.Enemy;
import models.desert.DesertGuide;
import utilities.Battle;
import utilities.Display;
import utilities.InputTaker;
//GO BACK (but not when deep in desert) (or at home text)
//divide desert by half days or days? (should be reflected in text descriptor)
public class DesertEntrance implements Environment {
    //should i have a map or a list of surroundingsStrings
    private String flavorText = "You spot the entrance for the desert demarcated by a sign that says \"Yellow-Orange Desert\". A desolate place stretching as far as the eye can see.\n"
            + "Next to the signpost, you see an older woman reading a newspaper in a wooden chair wearing a tattered straw hat. It is labeled \"GUIDE\".\n" +
            "To your right, you see an abandoned cabin. To your left, a lone cactus." ;
    //GO CABIN // GO RIGHT // RIGHT // MOVE RIGHT // CABIN //
    private final Environment cabin = new Cabin();
    //GO CACTUS // GO LEFT // LEFT // MOVE LEFT // CACTUS //
    private final Environment cactus = new Cactus();
    //enter desert// desert// yellow-orange desert// enter yellow-orange desert// go desert
    //maybe have text for dessert misspelling
    private final Environment desert = new Desert();
    //guide
    private final DesertGuide guide = new DesertGuide();
    //kick door
    //force door
    //push door

    // how to represent things that you can use when you have but don't have yet(maybe [ITEM])

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
        Display.print("What will you do?");
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }
    //have all the variants translate to GO whatever
    @Override
    public Boolean start() {
        giveFlavorText();
        boolean keepGoing = true;
        boolean crossedDesert = false;
        while(keepGoing) {
            String decision;
            if((decision = inputRepair(InputTaker.getPlayerInput())) != null) {
                if(decision.equals("go cabin")){
                    //go cabin// go right // right // move right // cabin //
                    keepGoing = cabin.start();
                    if(keepGoing) giveFlavorText();
                }
                else if(decision.equals("go guide")){
                    //go woman// talk to woman// talk woman // woman
                    //go guide// talk to guide// talk guide // guide (this may be bound to help)
                    guide.speak();
                }
                else if(decision.equals("go cactus")){
                    keepGoing = cactus.start();
                    if(keepGoing) giveFlavorText();
                }
                //if desert
                //reprint (look around)
            }
            else{
                Display.print("Invalid input: try again");
            }
        }
        if(crossedDesert){
            return true;
        }
        return false;
    }
    private String inputRepair(String raw){
        if(raw.equals("go cabin")){
            return "go cabin";
        }
        else if(raw.equals("go guide")){
            return "go guide";
        }
        else if(raw.equals("go cactus")){
            return "go cactus";
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



//reprint desc if they come from another area