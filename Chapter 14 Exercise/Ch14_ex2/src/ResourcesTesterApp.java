import java.io.*;

public class ResourcesTesterApp
{


    public static void main(String[] args)
    {
        String s1 = readLineWithResources();
        String s2 = readLineWithFinally();
    }



    public static String readLineWithResources()
    {
        System.out.println("Starting readLineWithResources.");

        try (RandomAccessFile in = new RandomAccessFile("products.ran", "r")){
            String s = in.readLine();
            return s;
        }

        catch (IOException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }



    public static String readLineWithFinally()
    {
        System.out.println("Starting readLineWithFinally.");
        RandomAccessFile in = null;

        try {
            in = new RandomAccessFile("products.ran", "r");
            String s = in.readLine();
            return s;
        }

        catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }


        //displays a message if it closes a file
        finally {
            try {
                if (in != null)
                    in.close();
                System.out.println("File will now close.");
            }

            //if unable to close file it will display Error 404
            catch (Exception e){
                System.out.println("Error 404: Unable to close file.");
            }

        }
        
    }


}