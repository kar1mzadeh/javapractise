import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;





public class Read
{
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));)
        {
           
            
            int num = Integer.parseInt(br.readLine());
            System.out.println(num/0);
        }
        catch(ArithmeticException e)
        {
            System.out.println("smth goes wrong"+ e);
        }
        finally
        {
            System.out.println("Yeap we are done");
        }

    }
}

// public class Read
// {
//  public static void main(String[] args) throws IOException {
//     System.out.println("Enter a Number");
//     // InputStreamReader in = new InputStreamReader(System.in);
//     // BufferedReader bf = new BufferedReader(in);
//     // int num = Integer.parseInt(bf.readLine());
//     Scanner scanner = new Scanner(System.in);
//     int num = scanner.nextInt();
//     System.out.println(num);
// // bf.close();
// scanner.close();
//  }
// }