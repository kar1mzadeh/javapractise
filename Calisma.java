
@FunctionalInterface
 interface A {

    int calc(int i, int a);
}
public class Calisma {

    public static void main(String[] args) {
        A obj = (i, a) -> a*i;
        int result = obj.calc(8, 9);
System.out.println(result);
    } 
} // it only works within functional interface

// the types of interface: functional , normal, and marcer
// if your interface has 2 + method it is normal
// SAM is if it has a only one method it is SAM
// mancer interface is that interface without method

