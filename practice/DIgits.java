import java.util.Scanner;

class Digits {
    
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Please Enter Your Number : " );
        int number=scanner.nextInt();
        int sum=0; // we take the sum first 0 because to sum all numbers easily.
        int product=1; // we take the product 1 because to product all numbers. If we take it zero then it will be unmeaningful.
        int average=0;
        int count=0; // it is for calculating the average
        if (number<0)
        {
            number= -number;
        }
        // if our number is negative, we will consider as positive.
    
        while(number!=0) 
        {
            
            int digit=number%10;
            number/=10;
           
            sum +=digit;
            product*=digit;
            count++;
            average=sum/count;
           
        }
        System.out.println("Sum "+ sum);
        System.out.println("Product "+ product);
        System.out.println("Average "+ average);
        
        scanner.close();
    }



}