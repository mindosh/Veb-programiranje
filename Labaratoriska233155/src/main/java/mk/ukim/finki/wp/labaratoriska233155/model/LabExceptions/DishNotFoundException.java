package mk.ukim.finki.wp.labaratoriska233155.model.LabExceptions;

public class DishNotFoundException extends RuntimeException{
    public DishNotFoundException() {
        super("Dish was not found!");
    }
}
