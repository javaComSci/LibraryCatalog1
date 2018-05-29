import java.util.ArrayList;
import java.util.HashMap;

public class User {

    String name;
    //for each user, has a list of the books checked out or list of books added
    protected ArrayList<Book> userBooks = new ArrayList<Book>();

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
