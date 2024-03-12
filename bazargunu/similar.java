package bazargunu;
class A
{
 public void show(){
System.out.println("In A show");
 }
static class B {
    public void show()
    {
     System.out.println("In B show");
    }
 }


}


public class similar {
    public static void main(String[] args) {
        A.B obj = new A.B();
        obj.show();
    }
}
