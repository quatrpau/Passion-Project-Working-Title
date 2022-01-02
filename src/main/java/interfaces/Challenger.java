package interfaces;
//how to do this with decoration?
public interface Challenger extends Being {
    Item giveReward();
    int decideTime();
    boolean surrenderDecision();
}
