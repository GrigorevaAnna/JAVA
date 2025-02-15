import java.util.Scanner;

public class Exercise_3 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int N = scanner.nextInt();
        int[] numbers = new int[N];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < N; i++) 
        {
            numbers[i] = scanner.nextInt();
        }

        int SUM = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < numbers.length - 1; i++) 
        {
            sum = numbers[i] + numbers[i+1];
            SUM = Math.max(SUM, sum);
        }

        System.out.println("Максимальная сумма: " + SUM);
    }
}
