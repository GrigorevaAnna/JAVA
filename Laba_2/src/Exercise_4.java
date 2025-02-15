import java.util.Scanner;

public class Exercise_4 
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

        int[][] newArray = new int[N_columns][N_lines];  

        for (int i = 0; i < N_lines; i++) 
        {
            for (int j = 0; j < N_columns; j++) 
            {
                newArray[j][N_lines - i - 1] = numbers[i][j];  
            }
        }

        System.out.println("Итоговый массив: ");
        for (int i = 0; i < newArray.length; i++)
         {
            for (int j = 0; j < newArray[i].length; j++) 
            {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
