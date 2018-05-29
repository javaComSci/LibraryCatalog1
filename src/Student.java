public class Student extends User {

    public Student(String name){
        super(name);
    }

    public void checkOut(Book book){
        if(book != null && book.getCopies() >= 1){
            book.checkOut(this);
            userBooks.add(book);
        }else{
            System.out.println("No copies available");
        }
    }
    public void returnBook(Book book){
        if(book != null && userBooks.contains(book)) {
            book.returnBook(this);
            userBooks.remove(book);
        }
    }
    public void reserveBook(Book book){
        book.reserve(this);
    }
}
