package week03practise;

import java.util.Arrays;

public class exercise {
    public static void main(String[] args) {
        

        
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Sum(array));
    }
    

public static int Sum (int[] a)

{
     int sum=0;
     

    for (int i=0; i<a.length; i++)
     {
        sum +=a[i];
     }
     return sum;
}



}
