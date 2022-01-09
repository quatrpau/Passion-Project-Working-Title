//make this text yellow
package environments.desert;
import interfaces.Challenger;
import interfaces.Environment;
import models.desert.DesertGuide;
import utilities.AnsiColor;
import utilities.Battle;
import utilities.IOConsole;
import utilities.InputTaker;
//GO BACK (but not when deep in desert) (or at home text)
public class DesertEntrance implements Environment {
    //should i have a map or a list of surroundingsStrings
    private IOConsole console = AnsiColor.ORANGE.ioConsole;
    private String flavorText = "You spot the entrance for the desert demarcated by a sign that says \"Yellow Desert\". A desolate place stretching as far as the eye can see.\n"
            + "Next to the signpost, you see an older woman reading a newspaper in a wooden chair wearing a tattered straw hat. It is labeled \"GUIDE\".\n" +
            "To your right, you see an abandoned cabin. To your left, a lone cactus." ;
    //GO CABIN // GO RIGHT // RIGHT // MOVE RIGHT // CABIN //
    private final Environment cabin = new Cabin();
    //GO CACTUS // GO LEFT // LEFT // MOVE LEFT // CACTUS //
    private final Environment cactus = new CactusArea();
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
    public Battle triggerBattle(Challenger opponent) {
        return null;
    }

    @Override
    public void giveFlavorText() {
        console.println(flavorText);
        console.println("What will you do?");
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
            String input;
            if(((input = InputTaker.getPlayerInput()) != null) && (decision = inputRepair(input)) != null) {
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
                else if(decision.equals("go desert")){
                    crossedDesert = desert.start();
                    keepGoing = false;
                }
                //reprint (look around)
                else if(decision.equals("look")){
                    giveFlavorText();
                }
                else if(decision.equals("look signpost")){
                    console.println("YELLOW DESERT");
                }
                else if(decision.equals("look woman")){
                    console.println("She seems to be very engrossed in her newspaper.");
                }
            }
            else if(input == null){
                giveFlavorText();
            }
            else{
                console.println("Invalid input: try again");
            }
        }
        if(crossedDesert){
            return true;
        }
        return false;
    }
    private String inputRepair(String raw){
        if(raw.equals("go cabin") || raw.equals("go left")){
            return "go cabin";
        }
        else if(raw.equals("go woman") || raw.equals("talk to woman")
                || raw.equals("go guide") || raw.equals("talk to guide") ){
            return "go woman";
        }
        else if(raw.equals("go cactus") || raw.equals("go right")){
            return "go cactus";
        }
        else if(raw.equals("go desert") || raw.equals("enter desert")){
            return "go desert";
        }
        else if(raw.equals("look around") || raw.equals("look")){
            return "look";
        }
        else if(raw.equals("look signpost") || raw.equals("look at signpost")){
            return "look signpost";
        }
        else if(raw.equals("look woman") || raw.equals("look at woman")
                || raw.equals("look at guide") || raw.equals("look guide")){
            return "look woman";
        }
        else{
            return null;
        }
    }
}
//implement monetary system? //must find way to make money

//reprint desc if they come from another area