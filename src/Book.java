import java.util.*;

public class Book {
    private String title;
    int numCopies;
    private String[] reservedStatus;
    private int[] daysCheckedOut;
    private HashMap<Integer, User> idUser = new HashMap<Integer,User>(); //will map book id with user

    public Book(String title, int NumCopies){
        this.title = title;
        numCopies = NumCopies;

    }

    public String getName(){
        return title;
    }

    public void addCopies(int co){
        numCopies += co;
    }
    public void removeCopies(int co){
        numCopies = numCopies - co;
    }
    public void checkOut(){

    }
    public void reserve(){

    }

    public void overdue(){

    }
}
