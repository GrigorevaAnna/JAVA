import java.util.*;
import java.time.*;

class Main 
{
    static Map<String, String> users = new HashMap<>();
    static List<Cinema> cinemas = new ArrayList<>();
    static List<Movie> movies = new ArrayList<>();
    static String currentUser = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        users.put("admin", "admin123");
        users.put("user", "user123");
        
        movies.add(new Movie("Гордость и предубеждение", 129));
        movies.add(new Movie("Вторжение", 137));
        
        Cinema cinema1 = new Cinema("Заря");
        cinema1.addHall(new Hall("Зал 1", 5, 10));
        cinema1.addHall(new Hall("Зал 2", 8, 8));
        
        Cinema cinema2 = new Cinema("Плаза");
        cinema2.addHall(new Hall("Зал 1", 10, 15));
        
        cinemas.add(cinema1);
        cinemas.add(cinema2);

        while (currentUser == null) 
        {
            System.out.print("Логин: ");
            String login = scanner.nextLine();
            System.out.print("Пароль: ");
            String password = scanner.nextLine();
            
            if (users.containsKey(login) && users.get(login).equals(password))
            {
                currentUser = login;
                System.out.println("Добро пожаловать, " + login + "!");
            } 
            else 
            {
                System.out.println("Неверный логин или пароль");
            }
        }

        boolean isAdmin = currentUser.equals("admin");
        while (true) 
        {
            System.out.println("\nГлавное меню:");
            System.out.println("1. Поиск сеанса");
            System.out.println("2. Купить билет");
            System.out.println("3. План зала");
            if (isAdmin) 
            {
                System.out.println("4. Добавить кинотеатр");
                System.out.println("5. Добавить зал");
                System.out.println("6. Создать сеанс");
                System.out.println("7. Добавить фильм");
            }
            System.out.println("0. Выход");
            
            try 
            {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) searchSession();
                else if (choice == 2) buyTicket();
                else if (choice == 3) showHallPlan();
                else if (isAdmin && choice == 4) addCinema();
                else if (isAdmin && choice == 5) addHall();
                else if (isAdmin && choice == 6) createSession();
                else if (isAdmin && choice == 7) addMovie();
                else if (choice == 0) System.exit(0);
                else System.out.println("Неверный выбор");
            } 
            catch (Exception e) 
            {
                System.out.println("Ошибка ввода");
            }
        }
    }

    static void searchSession() 
    {
        System.out.println("Доступные фильмы:");
        for (int i = 0; i < movies.size(); i++) 
        {
            System.out.println((i+1) + ". " + movies.get(i).title);
        }
        System.out.print("Выберите фильм: ");
        Movie movie = movies.get(Integer.parseInt(scanner.nextLine()) - 1);
        
        Session nearestSession = null;
        LocalDateTime now = LocalDateTime.now();
        
        for (Cinema cinema : cinemas) 
        {
            for (Hall hall : cinema.halls) 
            {
                for (Session session : hall.sessions) 
                {
                    if (session.movie.equals(movie) && session.time.isAfter(now) && session.hasAvailableSeats()) 
                        {
                        if (nearestSession == null || session.time.isBefore(nearestSession.time))
                        {
                            nearestSession = session;
                        }
                    }
                }
            }
        }
        
        if (nearestSession != null) 
        {
            System.out.println("Ближайший сеанс:");
            System.out.println("Кинотеатр: " + nearestSession.hall.cinema.name);
            System.out.println("Зал: " + nearestSession.hall.name);
            System.out.println("Время: " + nearestSession.time);
            System.out.println("Свободных мест: " + nearestSession.getAvailableSeatsCount());
        } 
        else 
        {
            System.out.println("Нет доступных сеансов");
        }
    }

    static void buyTicket() 
    {
        Session session = selectSession();
        showSeats(session);
        
        System.out.print("Введите ряд и место (например '3 5'): ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int seat = Integer.parseInt(input[1]);
        
        System.out.println(session.bookSeat(row, seat) ? "Билет куплен!" : "Место занято/не существует");
    }

    static void showHallPlan() 
    {
        showSeats(selectSession());
    }

    static void addCinema() 
    {
        System.out.print("Название кинотеатра: ");
        cinemas.add(new Cinema(scanner.nextLine()));
        System.out.println("Кинотеатр добавлен");
    }

    static void addHall() 
    {
        Cinema cinema = selectCinema();
        System.out.print("Название зала: ");
        String name = scanner.nextLine();
        System.out.print("Рядов: ");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.print("Мест в ряду: ");
        int seats = Integer.parseInt(scanner.nextLine());
        cinema.addHall(new Hall(name, rows, seats));
        System.out.println("Зал добавлен");
    }

    static void createSession() 
    {
        Hall hall = selectHall();
        Movie movie = selectMovie();
        System.out.print("Дата и время (гггг-мм-дд чч:мм): ");
        String[] dt = scanner.nextLine().split(" ");
        LocalDateTime time = LocalDateTime.parse(dt[0] + "T" + dt[1] + ":00");
        hall.addSession(new Session(movie, time, hall));
        System.out.println("Сеанс создан");
    }

    static void addMovie() 
    {
        System.out.print("Название фильма: ");
        String title = scanner.nextLine();
        System.out.print("Продолжительность (мин): ");
        movies.add(new Movie(title, Integer.parseInt(scanner.nextLine())));
        System.out.println("Фильм успешно добавлен");
    }

    static Movie selectMovie() 
    {
        System.out.println("Фильмы:");
        for (int i = 0; i < movies.size(); i++) 
        {
            System.out.println((i+1) + ". " + movies.get(i).title);
        }
        System.out.print("Выберите: ");
        return movies.get(Integer.parseInt(scanner.nextLine()) - 1);
    }

    static Cinema selectCinema() 
    {
        System.out.println("Кинотеатры:");
        for (int i = 0; i < cinemas.size(); i++) 
        {
            System.out.println((i+1) + ". " + cinemas.get(i).name);
        }
        System.out.print("Выберите: ");
        return cinemas.get(Integer.parseInt(scanner.nextLine()) - 1);
    }

    static Hall selectHall() 
    {
        Cinema cinema = selectCinema();
        System.out.println("Залы:");
        for (int i = 0; i < cinema.halls.size(); i++) 
        {
            System.out.println((i+1) + ". " + cinema.halls.get(i).name);
        }
        System.out.print("Выберите: ");
        return cinema.halls.get(Integer.parseInt(scanner.nextLine()) - 1);
    }

    static Session selectSession() 
    {
        Hall hall = selectHall();
        System.out.println("Сеансы:");
        for (int i = 0; i < hall.sessions.size(); i++) 
        {
            Session s = hall.sessions.get(i);
            System.out.printf("%d. %s в %s (свободно %d мест)\n", i+1, s.movie.title, s.time, s.getAvailableSeatsCount());
        }
        System.out.print("Выберите: ");
        return hall.sessions.get(Integer.parseInt(scanner.nextLine()) - 1);
    }

    static void showSeats(Session session) 
    {
        System.out.println("Экран\n----------------");
        for (int r = 1; r <= session.seats.length; r++) 
        {
            System.out.print("Ряд " + r + ": ");
            for (int s = 1; s <= session.seats[r-1].length; s++) 
            {
                System.out.print(session.seats[r-1][s-1] ? "[X]" : "[ ]");
            }
            System.out.println();
        }
    }
}

class Cinema 
{
    String name;
    List<Hall> halls = new ArrayList<>();
    
    Cinema(String name) 
    { 
        this.name = name; 
    }
    
    void addHall(Hall hall) 
    { 
        halls.add(hall); 
        hall.cinema = this; 
    }
}

class Hall 
{
    String name;
    int rows, seatsPerRow;
    List<Session> sessions = new ArrayList<>();
    Cinema cinema;
    
    Hall(String name, int rows, int seatsPerRow) 
    {
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }
    
    void addSession(Session session) 
    { 
        sessions.add(session); 
        session.hall = this; 
    }
}

class Session 
{
    Movie movie;
    LocalDateTime time;
    boolean[][] seats;
    Hall hall;
    
    Session(Movie movie, LocalDateTime time, Hall hall) 
    {
        this.movie = movie;
        this.time = time;
        this.hall = hall;
        this.seats = new boolean[hall.rows][hall.seatsPerRow];
    }
    
    boolean hasAvailableSeats() 
    {
        for (boolean[] row : seats) 
        {
            for (boolean seat : row) 
            {
                if (!seat) return true;
            }
        }
        return false;
    }
    
    int getAvailableSeatsCount() 
    {
        int count = 0;
        for (boolean[] row : seats) 
        {
            for (boolean seat : row) 
            {
                if (!seat) count++;
            }
        }
        return count;
    }
    
    boolean bookSeat(int row, int seat) 
    {
        if (row < 1 || row > seats.length || seat < 1 || seat > seats[0].length || seats[row-1][seat-1])
        {
            return false;
        }
        seats[row-1][seat-1] = true;
        return true;
    }
}

class Movie 
{
    String title;
    int duration;
    
    Movie(String title, int duration) 
    {
        this.title = title;
        this.duration = duration;
    }
}