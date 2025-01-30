import java.util.Scanner;

public class Exercise_5 
{
    public static void main(String[] args)  
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите трёхзначное число: ");
        int N = scanner.nextInt(); 
        int sum = 0;
        int proizv = 1;
        if (N > 0)
        {
            sum = (N / 100) + ((N / 10) % 10) + (N % 10);
            proizv = (N / 100) * ((N / 10) % 10) * (N % 10);
            if ((sum % 2 == 0) & (proizv % 2 == 0))
            {
                System.out.println("Введёное число является дважды четным!"); 
            }
            else
            {
                System.out.println("Введёное число не является дважды четным!"); 
            }
        }
        if (N <= 0)
        {
            System.out.println("Неверное число ввода...");
        }
    }
}
