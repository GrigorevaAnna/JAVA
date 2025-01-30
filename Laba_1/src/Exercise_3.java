import java.util.Scanner;

public class Exercise_3 
{
    public static void main(String[] args)  
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую координату: ");
        int x = scanner.nextInt();  //юг-север
        System.out.print("Введите вторую координату: ");
        int y = scanner.nextInt();  //запад-восток
        scanner.nextLine();

        int X_0 = 0;  //Наши начальные координаты
        int Y_0 = 0;
        int min_steps = 0;        

        while (true) 
        {
            System.out.print("Введите направление: ");
            String side = scanner.nextLine(); 

            if (side.equals("stop")) 
            {
                break; 
            }

            System.out.print("Введите число: ");
            int count_steps = scanner.nextInt(); 
            scanner.nextLine();

            if (side.equals("north")) 
            {
                X_0 += count_steps;
            }
            if (side.equals("south")) 
            {
                X_0 -= count_steps;
            }
            if (side.equals("west")) 
            {
                Y_0 -= count_steps;
            }
            if (side.equals("east")) 
            {
                Y_0 += count_steps;
            }
            min_steps += 1; 

            if (X_0 == x && Y_0 == y) 
            {
                System.out.println(min_steps);
                break;
            }
        }
    }
}
