package interfaces;

public interface Being {
    int giveDamage();
    void takeDamage(int amt);
    boolean isAlive();
    int getHp();
}
