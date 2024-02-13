package week03practise;

import java.util.Arrays;

public class exercise {
    public static void main(String[] args) {
        
        int [] array = {1,5,4,32};
    
        System.out.println(Arrays.toString(array));
        System.out.println(Sum(array));
    }
    

public static int Sum (int[] a)

{
     int sum=0;
     

    for (int i=0; i<a.length; i++)
     {
        sum= sum +a[i];
     }
     return sum;
}



}
