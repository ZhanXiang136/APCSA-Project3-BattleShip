import java.util.Scanner;
//Untility class
public class U
{
    public static Scanner scanStr = new Scanner(System.in);
    public static Scanner scanInt = new Scanner(System.in);

    //no construtor needed

    //prints string slowly
    public static void print(String str)
    {
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                Thread.sleep(50);
                System.out.print(str.substring(i, i+1));
            }
        }
        catch (Exception e)
        {

            System.out.println(e);
        }
    }

    public static void print(String str, int speed)
    {
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                Thread.sleep(speed);
                System.out.print(str.substring(i, i+1));
            }
        }
        catch (Exception e)
        {

            System.out.println(e);
        }
    }

    //prints string slowly + next line
    public static void println(String str)
    {
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                Thread.sleep(50);
                System.out.print(str.substring(i, i+1));
            }
        }
        catch (Exception e)
        {

            System.out.println(e);
        }
        System.out.println();
    }

    public static void println(String str, int speed)
    {
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                Thread.sleep(speed);
                System.out.print(str.substring(i, i+1));
            }
        }
        catch (Exception e)
        {

            System.out.println(e);
        }
        System.out.println();
    }

    //clear screen
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //scanner method
    public static String scanStr()
    {
        return scanStr.nextLine();
    }
    public static int scanInt()
    {
        return scanInt.nextInt();
    }

    //sleep
    public static void sleep(int milSecond)
    {
        try
        {
            Thread.sleep(milSecond);
        }
        catch (Exception e)
        {

            System.out.println(e);
        }
    }

    //clears the screen when user is ready to move on
    //clearScreen() + scanStr
    public static void clear()
    {
        scanStr();
        clearScreen();
    }
}