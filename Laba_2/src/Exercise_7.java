import java.util.Scanner;

public class Exercise_7 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк массива: ");
        int N_lines = scanner.nextInt();

        System.out.print("Введите количество столбцов массива: ");
        int N_columns = scanner.nextInt();

        int[][] numbers = new int[N_lines][N_columns];

        System.out.println("Введите элементы массива через пробелы (каждая строка на новой строке):");
        scanner.nextLine(); 

        for (int i = 0; i < N_lines; i++) 
        {
            String line = scanner.nextLine(); 
            String[] tokens = line.split(" ");  
            
            for (int j = 0; j < N_columns; j++) 
            {
                numbers[i][j] = Integer.parseInt(tokens[j]);  
            }
        }

        int[] result = new int[N_lines];

        for (int i = 0; i < N_lines; i++) 
        {
            int max = numbers[i][0]; 

            for (int j = 1; j < N_columns; j++) 
            {
                if (numbers[i][j] > max) 
                {
                    max = numbers[i][j];  
                }
            }
            result[i] = max; 
        }

        System.out.print("Максимальные элементы в каждой строке: ");
        for (int i = 0; i < result.length; i++)
        {
            int res = result[i];
            System.out.print(res + " ");
        }

    }
}
