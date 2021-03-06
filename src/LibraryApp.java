import java.util.*;

import static java.util.Objects.nonNull;

public class LibraryApp {

    public static void main(String [] args){
        Scanner reader = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Book> books = new ArrayList<Book>();
        User currUser = null;
        while(true) {
            System.out.println("Menu\n1.Student Mode\n2.Admin Mode\n3.Quit");
            int option;
            if (reader.hasNextInt()) {
                option = reader.nextInt();
                reader.nextLine();
                if (option == 1 || option == 2) {
                    System.out.println("Enter name");
                    if (reader.hasNextLine()){
                        String name = reader.nextLine();
                        currUser = checkUser(name, users);
                        if(nonNull(currUser)){
                            System.out.println("Already in system");
                        }else{
                            System.out.println("Adding to system");
                            if(option == 1){
                                currUser = new Student(name);
                                users.add(currUser);
                            }else{
                                currUser = new Admin(name);
                                users.add(currUser);
                            }
                        }
                    }
                    if(option == 1){
                        studentOptions(users,books,(Student)currUser);
                    }else{
                        adminOptions(users,books,(Admin)currUser);
                    }
                } else if (option == 3) {
                    break;
                }
            }else{
                System.out.println("Enter valid number.");
            }
        }
    }

    public static void studentOptions(ArrayList<User> users, ArrayList<Book> books, Student currUser){
        Scanner reader = new Scanner(System.in);
        while(true) {
            System.out.println("1.Check out\n2.Return\n3.Reserve\n4.Quit");
            int option = reader.nextInt();
            reader.nextLine();
            if(option == 4){
                break;
            }else if(option > 4 || option <= 0){
                System.out.println("Enter valid input.");
                continue;
            }else{
                System.out.println("Enter the title of the book.");
                String title = reader.nextLine();
                Book b = null;
                for(Book book: books){
                    if(book.getName().equals(title)){
                       b = book;
                       break;
                    }
                }
                if(option == 1){
                    currUser.checkOut(b);
                }else if(option == 2){
                    currUser.returnBook(b);
                }else if(option == 3){
                    currUser.reserveBook(b);
                }
            }
        }
    }

    public static void adminOptions(ArrayList<User> users, ArrayList<Book> books, User currUser){
        Scanner reader = new Scanner(System.in);
        while(true){
            System.out.println("1.Add new title\n2.Remove book\n3.Change number of copies\n4.All books\n" +
                                "5.View user info\n6.Quit");
            int option = reader.nextInt();
            reader.nextLine();
            if(option == 6){
                break;
            }else if(option == 1){
                //add a new title with the copies
                System.out.println("Enter title of book to add");
                String title = "Untitled";
                if(reader.hasNextLine()){
                    title = reader.nextLine();
                }
                System.out.println("How many copies of the book are there?");
                int copies = 1;
                if(reader.hasNextInt()){
                    copies = reader.nextInt();
                    reader.nextLine();
                }
                Book book = new Book(title,copies);
                books.add(book);
            }else if(option == 2){
                //title of the book that needs to be removed from the list of books
                System.out.println("Enter title of book to remove");
                String title = reader.nextLine();
                checkTitle(title, books, true);
            }else if(option == 3){
                //number of copies of the book needs to be changed
                System.out.println("Enter title of book to change number of copies");
                String title = reader.nextLine();
                Book b = checkTitle(title,books,false);
                if(b != null){
                    System.out.println("1.Add copies\n2.Remove copies");
                    int op = reader.nextInt();
                    reader.nextLine();
                    if(op == 1){
                        System.out.println("Enter number of copies to add");
                        int copies = reader.nextInt();
                        b.addCopies(copies);
                    }else{
                        System.out.println("Enter number of copies to remove");
                        int copies = reader.nextInt();
                        b.removeCopies(copies);
                    }
                }
            }else if(option == 4){
                //prints out all titles of book in the library
                for(Book book: books){
                    System.out.println(book.getName() + " " + book.getCopies());
                    if(book.getNumCheckedOut() != 0){
                        System.out.println("This book is currently checked out");
                    }
                }
            }else if(option == 5) {
                System.out.println("Enter name of user to view information");
                String userName = reader.nextLine();
                User userInfo = checkUser(userName, users);
                System.out.println(userInfo);
            }else{
                //invalid input
                System.out.println("Enter valid input");
                continue;
            }
        }
    }


    public static Book checkTitle(String name, ArrayList<Book> books, boolean remove){
        for(Book book: books){
            if(name.equals(book.getName())){
                if (remove == true) {
                    books.remove(book);
                    System.out.println("Book removed");
                }
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }
    public static User checkUser(String name, ArrayList<User> users){
        for(User user: users){
            if(name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }
}
