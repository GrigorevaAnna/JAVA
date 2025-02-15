import java.util.Arrays;
import java.util.Scanner;

public class Exercise_2 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количеcтво элементов для первого массива: ");
        int N_1 = scanner.nextInt();

        if (N_1 <= 0) 
        {
            System.out.println("Ваш массив пуст.");
            return;
        }

        int[] massiv_1 = new int[N_1];
        System.out.println("Введите элементы первого массива через пробел:");
        for (int i = 0; i < N_1; i++) 
        {
            massiv_1[i] = scanner.nextInt();
        }

        Arrays.sort(massiv_1);

        System.out.print("Введите количеcтво элементов для второго массива: ");
        int N_2 = scanner.nextInt();

        if (N_2 <= 0) 
        {
            System.out.println("Ваш массив пуст.");
            return;
        }

        int[] massiv_2 = new int[N_2];
        System.out.println("Введите элементы второго массива через пробел:");
        for (int i = 0; i < N_2; i++) 
        {
            massiv_2[i] = scanner.nextInt();
        }

        Arrays.sort(massiv_2);

        int[] result_array = new int[N_1 + N_2];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < N_1 && j < N_2) 
        {
            if (massiv_1[i] <= massiv_2[j]) 
            {
                result_array[k++] = massiv_1[i++];
            } 

            else 
            {
                result_array[k++] = massiv_2[j++];
            }
        }
        
        while (i < N_1) 
        {
            result_array[k++] = massiv_1[i++];
        }
        
        while (j < N_2) 
        {
            result_array[k++] = massiv_2[j++];
        }

        System.out.println("Итоговый массив:");
        for (int result : result_array) 
        {
            System.out.print(result + " ");
        }

    }
}
