import java.util.Scanner;

/**
 * This class represents a Utility object
 *
 * @author Zhan Xiang Zheng
 */

public class U
{
    /** Creates scanner object */
    public static Scanner scanStr = new Scanner(System.in);

    /**
     * Prints line out slowly
     *
     */
    public static void println(String str)
    {
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                Thread.sleep(50);
                System.out.print(str.charAt(i));
            }
        }
        catch (Exception e)
        {

            System.out.println(e);
        }
        System.out.println();
    }


    /**
     * Clears the console
     * Doesn't work on intellj, so I added in empty print statements
     *
     */
    public static void clearScreen()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Scanner method
     *
     * @return user input
     */
    public static String scanStr(String s)
    {
        System.out.print(s);
        String temp = scanStr.nextLine();
        return temp;
    }


    /**
     * Clears the console on the user's command
     *
     */
    public static void clear()
    {
        scanStr("Click Enter to Continue");
        clearScreen();
    }

}