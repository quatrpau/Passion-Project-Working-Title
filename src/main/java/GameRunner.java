//TODO
//finish second environment
//items in general & stat changing items (enum for flavor text?)
//puzzles
//implement verb system on game class
    //maybe add interfaces for each verb
    //update
//add self status update
//random battles
    //figure out how to structure levels to have design-
        //ated areas to have random battles
//king's quest style game-over puns?
//stat changing items
//use jpa instead of jdbc
//make playable
//serializability
//story
//better writing( make as descriptive as possible as player does not have visual element)
//title
public final class GameRunner {
    public static void main(String[] args) {
        //take command line args?
        new Thread(new Game()).start();
    }
}


//Monday todo:
//3 days in desert
    //update each enemies' decide times to allow for less or no surrender and more a