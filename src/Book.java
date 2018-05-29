import java.util.*;

public class Book {
    private String title;
    private int numCopies;
    private int checkedOut;
    private String[] reservedStatus;
    private int[] daysCheckedOut;
    private HashMap<Integer, User> userBookMap = new HashMap<Integer,User>(); //will map book name with user

    public Book(String title, int NumCopies){
        this.title = title;
        numCopies = NumCopies;
        //assign a number to all copies of the book and place in map
        for(int i = 1; i <= numCopies; i++){
            userBookMap.put(i, null);
        }
    }

    public String getName(){
        return title;
    }

    public int getCopies(){
        return numCopies;
    }

    public int getNumCheckedOut(){
        return checkedOut;
    }

    //can only be changed by the admin
    public void addCopies(int co){
        numCopies += co;
    }

    //can only be changed by the admin
    public void removeCopies(int co){
        numCopies = numCopies - co;
    }

    //can only be changed by the student
    public void returnBook(Student student){
        for(int i = 1; i <= numCopies; i++){
            if((userBookMap.get(i)).equals(student)){
                System.out.println("Student who is returning is " + student.getName());
                userBookMap.replace(i, null);
                checkedOut--;
                break;
            }
        }
    }

    //can only be changed by the student
    public void checkOut(Student student){
        for(int i = 1; i <= numCopies; i++){
            if(userBookMap.get(i) == null){
                userBookMap.replace(i, student);
                checkedOut++;
                break;
            }
            System.out.println(userBookMap.get(i).getName());
        }
    }

    //can only be changed by the student
    public void reserve(Student student){

    }


    public void overdue(){

    }
}
