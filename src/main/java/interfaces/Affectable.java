package interfaces;
//check if E is null before exec this class
public interface Affectable<E extends Usable>{
    //returns whether or not it was successful
    Boolean getAffected(E catalyst);
}
