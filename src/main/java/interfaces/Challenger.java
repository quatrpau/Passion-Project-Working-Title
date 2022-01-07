package interfaces;
//how to do this with decoration?
public interface Challenger extends Being {
    Obtainable giveReward();
    int decideTime();
    boolean surrenderDecision();
    void giveFlavorText();
}
