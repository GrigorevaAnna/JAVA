import java.util.List;
import java.util.Scanner;

public class LibraryTest 
{
    public static void main(String[] args) 
    {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        library.addBook(new Book("Королевство шипов и роз", "Сара Маас", 2015));
        library.addBook(new Book("Королевство гнева и тумана", "Сара Маас", 2017));
        library.addBook(new Book("Королевство крыльев и руин", "Сара Маас", 2023));
        library.addBook(new Book("Гамлет", "Уильям Шекспер", 1603));
        library.addBook(new Book("Гордость и предубеждение", "Джейн Остин", 1813));
        library.addBook(new Book("Принц льда и крови", "Алиса Джукич", 2024));
        
        while (true) 
        {
            System.out.println("\n-----МЕНЮ БИБЛИОТЕКИ-----");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу по названию и автору");
            System.out.println("3. Показать все книги");
            System.out.println("4. Показать авторов");
            System.out.println("5. Показать статистику");
            System.out.println("6. Найти книги по автору");
            System.out.println("7. Найти книги по году");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) 
            {
                case 1:
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите год издания: ");
                    int year = scanner.nextInt();
                    
                    if (library.addBook(new Book(title, author, year))) 
                    {
                        System.out.println("Книга успешно добавлена!");
                    } 
                    else 
                    {
                        System.out.println("Такая книга уже существует!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Введите название книги для удаления: ");
                    String delTitle = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String delAuthor = scanner.nextLine();
                    
                    if (library.removeAllBooksByTitleAndAuthor(delTitle, delAuthor)) 
                    {
                        System.out.println("Книги успешно удалены!");
                    } 
                    else 
                    {
                        System.out.println("Книги не найдены!");
                    }
                    break;
                    
                case 3:
                    library.printAllBooks();
                    break;
                    
                case 4:
                    library.printUniqueAuthors();
                    break;
                    
                case 5:
                    library.printAuthorStatistics();
                    break;
                    
                case 6:
                    System.out.print("Введите автора для поиска: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> authorBooks = library.findBooksByAuthor(searchAuthor);
                    System.out.println("\nНайдено книг: " + authorBooks.size());
                    authorBooks.forEach(System.out::println);
                    break;
                    
                case 7:
                    System.out.print("Введите год для поиска: ");
                    int searchYear = scanner.nextInt();
                    List<Book> yearBooks = library.findBooksByYear(searchYear);
                    System.out.println("\nНайдено книг: " + yearBooks.size());
                    yearBooks.forEach(System.out::println);
                    break;
                    
                case 0:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}