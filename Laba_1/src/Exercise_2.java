import java.util.Scanner;

public class Exercise_2 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число: ");
        int N = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++)
        {
            int n = scanner.nextInt();
            if (i % 2 == 0)
            {
                count += n;
            }
            else
            {
                count -= n;
            }
        }
        System.out.println(count);
    }
}
