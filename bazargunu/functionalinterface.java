package bazargunu;
@FunctionalInterface
 interface A {

    void show();
}
public class functionalinterface {

    public static void main(String[] args) {
        A obj = new A() {
            public void show()
            {
                System.out.println("Oha diyorum");
            }
        };
        obj.show();
    } 
} 

