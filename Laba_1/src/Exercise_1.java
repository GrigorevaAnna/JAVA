import java.util.Scanner;

public class Exercise_1 
{
    public static void main(String[] args)  //Точка входа Java программы
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();
        int step = 0;
        while (n != 1)
        {
            if (n % 2 == 0)
            {
                n = n / 2;
                step += 1;
            }
            else
            {
                n = 3*n + 1;
                step += 1;
            }
        }
        System.out.println(step); 
    }
}
