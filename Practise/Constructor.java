

class Test
{
    private int age;
    private String name;
    public Test() // default constructor
    {
        name=("Camal");

        age=26;
    }
    public Test(String name, int age) // parameterized constructor
    {
       this.name=name;
       this.age=age;
    }

    public void setName(String name)
    {
        this.name= name;
    }
    public String getName()
    {
        return name;
    }
    public void setAge(int age)
    {
        this.age= age;
    }
    public int getAge()
    {
        return age;
    }

}


public class Constructor
{
    public static void main(String[] args)
    {
        Test test = new Test();
        Test test1 = new Test("Rahman", 18);
        System.out.println(test.getName() + "  " + "The age of the particpant should be above the" + ": " + test.getAge());
        System.out.println(test1.getName() + "  " + "The age of the particpant should be above the" + ": " + test1.getAge());
        test.setName("Rahman");
        test.setAge(20);
        //System.out.println(test.getName() + ": " + test.getAge);

    }
}