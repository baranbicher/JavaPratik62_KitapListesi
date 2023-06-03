import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
            PatikaDev Java102 - Book List
            Book class consists of book name, number of pages, author's name, and publication date variables.
            Generate 10 objects from the Book class and store them in an ArrayList structure.
            Using the stream structure and lambda expressions, write a new Map<String, String> with the author name opposite the book name.
            From this 10-element Booklist, develop a new list that filters the books with more than 100 pages and gives it as a new list.
            (You can use Stream and Lambda expressions.)

            https://academy.patika.dev/referral/rfcnr
        */

        ArrayList<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Pride and Prejudice", "Jane Austen", 367, LocalDate.of(1813, 1, 28)));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 281, LocalDate.of(1960, 7, 11)));
        bookList.add(new Book("The Little Prince", "Antoine de Saint-Exupery", 96, LocalDate.of(1943, 4, 6)));
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 218, LocalDate.of(1925, 4, 10)));
        bookList.add(new Book("Things Fall Apart", "Chinua Achebe", 209, LocalDate.of(1958, 6, 17)));
        bookList.add(new Book("The Giving Tree", "Shel Silverstein", 64, LocalDate.of(1964, 10, 7)));
        bookList.add(new Book("Animal Farm", "George Orwell", 112, LocalDate.of(1945, 8, 17)));
        bookList.add(new Book("Lord of the Flies", "William Golding", 224, LocalDate.of(1954, 9, 17)));
        bookList.add(new Book("Of Mice and Men", "John Steinbeck", 107, LocalDate.of(1937, 2, 6)));
        bookList.add(new Book("The Very Hungry Caterpillar", "Eric Carle", 26, LocalDate.of(1969, 6, 3)));

        Map<String,String> bookMap = bookList.stream().collect(Collectors.toMap(Book::getBookName, Book::getAuthorName));
        //or
        //Map<String,String> bookMap = bookList.stream().collect(Collectors.toMap(book -> book.getBookName(), book -> book.getAuthorName()));

        System.out.println("\nALL BOOKS:");
        bookList.forEach(book -> System.out.println(book.toStringAllInfo()));
        //or, without page count and publication year info:
        //bookList.forEach(System.out::println);
        System.out.println("******************************");

        System.out.println("\nBOOKS WITH 100 OR MORE PAGES:");
        List<Book> filteredBookList = getTheBookListFilteredByPageCount(bookList, 101, Integer.MAX_VALUE);
        filteredBookList.forEach(System.out::println);
        //or,
        //filteredBookList.forEach(book -> System.out.println(book.toString()));
        System.out.println("******************************");

        System.out.println("\nBOOKS WITH 100 OR LESS PAGES:");
        List<Book> filteredBookList2 = getTheBookListFilteredByPageCount(bookList, 0, 100);
        filteredBookList2.forEach(System.out::println);
        System.out.println("******************************");
    }

    private static List<Book> getTheBookListFilteredByPageCount(ArrayList<Book> mainList, int minPageCount, int maxPageCount){
        return mainList.stream().filter(book -> book.getPageCount() >= minPageCount && book.getPageCount() <= maxPageCount).toList();
    }
}