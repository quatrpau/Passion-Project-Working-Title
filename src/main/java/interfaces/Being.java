package interfaces;
//maybe refactor this to Fighter
public interface Being {
    int giveDamage();
    void takeDamage(int amt);
    boolean isAlive();
    int getHp();
    int getSpeed();
    String getName();
}
