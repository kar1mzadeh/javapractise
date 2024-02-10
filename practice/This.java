

class Test
{
    private int age;
    private String name;

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


public class This
{
    public static void main(String[] args)
    {
        Test test = new Test();
        test.setName("Rahman");
        test.setAge(20);
        System.out.println(test.getName());
        System.out.println(test.getAge());

    }
}