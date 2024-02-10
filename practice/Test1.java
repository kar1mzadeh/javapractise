
class opp
{
    int a;
    int b;
    opp(int a, int b)
    {
        this.a=a;
        this.b=b;
    }
    public void setA(int a)
    {
        this.a=a;
    }
    public void setB(int b)
    {
        this.b=b;
    }
    public int getA()
    {
        return a;
    }
    public int getB()
    {
        return b;
    }
    public void display()
    {
        System.out.println(a + " " + b);
    }
}
public class Test1 {
    public static void main(String[] args) {
        opp obj = new opp(10, 20);
        obj.display(); 
    }
}
