package InputUtil;

import java.util.Scanner;

public final class InputUtil //Represents general utility for taking user input, may ot be inherited from
{
    private InputUtil() //Private constructor to ensure class is not instantiated
    {
        throw new RuntimeException("Static class may not be instantiated."); //Throw exception if instantiated
    }
    public static float InputFloat(String prompt, String error, Scanner sc) //Take user input in float form and redo if wrong format
    {
        while(true)
        {
            try
            {
                System.out.println(prompt);
                return sc.nextFloat();
            } catch (Exception e)
            {
                System.out.println(error);
            }
        }
    }
    public static int InputInt(String prompt, String error, int min, int max, Scanner sc) //Take user input in float form and redo if wrong format
    {
        while(true)
        {
            try
            {
                System.out.print(prompt);
                int temp = sc.nextInt();
                if(temp >= min && temp <= max)
                {
                    return temp;
                }
                else
                {
                    System.out.println(error);
                }
            }
            catch (Exception e)
            {
                System.out.println(error);
                sc.next();
            }
        }
    }
}