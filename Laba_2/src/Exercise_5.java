import java.util.Scanner;

public class Exercise_5 
{
public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int N = scanner.nextInt();
        int[] numbers = new int[N];

        if (N <= 0) 
        {
            System.out.println("В массиве должны быть хоть какие-то элементы...");
            return;
        }

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < N; i++) 
        {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Введите число для поиска: ");
        int target = scanner.nextInt();
        int[] result = null;


        for (int i = 0; i < numbers.length; i++) 
        {
            for (int j = i + 1; j < numbers.length; j++) 
            {
                if (numbers[i] + numbers[j] == target) 
                {
                    result = new int[]{numbers[i], numbers[j]};
                    break;
                }
            }

            if (result != null) 
            {
                break;
            }
        }

        if (result != null) 
        {
            System.out.println("Пара элементов с суммой " + target + ": " + result[0] + " и " + result[1]);
        } 

        else 
        {
            System.out.println("Сумма " + target + " не найдена в массиве.");
        }

    }
}
