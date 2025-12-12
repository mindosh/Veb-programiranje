package mk.ukim.finki.wp.labaratoriska233155.model.LabExceptions;

public class NotSelectedChefException extends RuntimeException{
    public NotSelectedChefException(){
        super("Please select a chef!");
    }
}
