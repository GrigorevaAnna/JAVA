import java.util.*;
import java.util.stream.Collectors;

public class Library 
{
    private List<Book> books;
    private Set<String> authors;
    private Map<String, Integer> authorStatistics;

    public Library() 
    {
        books = new ArrayList<>();
        authors = new HashSet<>();
        authorStatistics = new HashMap<>();
    }

    public boolean addBook(Book book) 
    {
        if (books.contains(book))
        {
            return false;
        }
        books.add(book);
        updateAuthorsAndStatistics();
        return true;
    }

    public boolean removeAllBooksByTitleAndAuthor(String title, String author) 
    {
        int initialSize = books.size();
        books.removeIf(b -> b.getTitle().equals(title) && b.getAuthor().equals(author));
        
        if (books.size() < initialSize) 
        {
            updateAuthorsAndStatistics();
            return true;
        }
        return false;
    }

    private void updateAuthorsAndStatistics() 
    {
        authors.clear();
        authorStatistics.clear();
        
        for (Book book : books) 
        {
            authors.add(book.getAuthor());
            authorStatistics.put(book.getAuthor(), 
                authorStatistics.getOrDefault(book.getAuthor(), 0) + 1);
        }
    }

    public List<Book> findBooksByAuthor(String author)
    {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByYear(int year) 
    {
        return books.stream().filter(book -> book.getYear() == year).collect(Collectors.toList());
    }

    public void printAllBooks() 
    {
        System.out.println("\n-----СПИСОК КНИГ В БИБЛИОТЕКЕ:-----");
        books.forEach(System.out::println);
    }

    public void printUniqueAuthors() 
    {
        System.out.println("\n-----СПИСОК УНИКАЛЬНЫХ АВТОРОВ:-----");
        authors.forEach(System.out::println);
    }

    public void printAuthorStatistics() 
    {
        System.out.println("\n-----СТАТИСТИКА ПО КОЛИЧЕСТВУ КНИГ:-----");
        authorStatistics.forEach((author, count) -> System.out.println(author + ": " + count + " книг(а/и)"));
    }
}