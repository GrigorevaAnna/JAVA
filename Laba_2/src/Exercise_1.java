import java.util.Scanner;

public class Exercise_1 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Напишите строку: ");
        String s = scanner.nextLine();
        
        String result = "";
        String string = "";
        char[] array = s.toCharArray();

        if (s.length() == 0) 
        {
            System.out.println("Строка пустая. Нужно написать хоть что-нибудь..");
        } 
        else 
        {
            for (char symbol : array) 
            {
                boolean repeat = false;
                for (int i = 0; i < string.length(); i++)
                {
                    if (string.charAt(i) == symbol) 
                    {
                        repeat = true;  
                        break;
                    }
                }

                if (repeat) 
                {
                    string = "";  
                }
    
                string += symbol; 
    
                if (string.length() > result.length()) 
                { 
                    result = string;
                }
            }
    
            System.out.println("Наибольшая подстрока без повторяющихся символов: " + result);
        }

    }

}
