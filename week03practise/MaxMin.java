package week03practise;

import java.util.Arrays;

public class MaxMin {
    
    public static void main(String[] args) {
        int arrays[]={5,8,9,0,3,2,1};
        int[][] salam= {{5,5,3,2,2},{3,4,2,1,2},{9,3,2,43,354,43,53,3,43,43,43,34,45,4,3,4343,432},{32,32,32,43,54,4,5,4554,54,23,32,2332,23,434,342,32,32,2323,1}};
        int sum=0;
        int sumOFSalam=0;

        


// for (int i=0; i< arrays.length; i++)
// {
    // if (arrays[i]<min)
    // {
    //     min=arrays[i];
    // }
    // if (arrays[i]>max)
    // {
    //     max=arrays[i];
    // }
    for (int x : arrays)
    {
        sum+=x;

    }
    for (int x[] : salam)
    {
        for (int y:x)
        {
            sumOFSalam +=y;
        }
    }

    Arrays.sort(arrays);

    int min=arrays[0];
        int max=arrays[arrays.length-1];
    

    
    System.out.println("Arrays of elements: "+ Arrays.toString(arrays)+ " "+ "Max: " + min + " "+ "Min: " +max + " Sum: " + sum + " Sum of Salam: " + sumOFSalam);
    }

}
