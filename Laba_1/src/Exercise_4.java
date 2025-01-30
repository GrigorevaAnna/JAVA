import java.util.Scanner;
import java.util.Arrays;

public class Exercise_4 
{
    public static void main(String[] args)  
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество дорог: ");
        int N = scanner.nextInt();  
        int height_gruz = 0;
        int road_num = 0;
        for (int i = 1; i <= N; i++)
        {
            // System.out.print("Введите количество тунелей: ");
            int n_tuneli = scanner.nextInt();
            int [] array = new int[n_tuneli];
            int min_height = 100000;

            // System.out.print("Введите высоты тунелей: ");
            for (int j = 0; j < n_tuneli; j++)
            {
                array[j] = scanner.nextInt(); 
                min_height = Math.min(min_height, array[j]);    
            }

            // System.out.println("Высоты тунелей: " + Arrays.toString(array));

            if (min_height > height_gruz)
            {
                height_gruz = min_height;
                road_num = i;
            }
        }
        System.out.println(road_num + " " + height_gruz);
    }
}
