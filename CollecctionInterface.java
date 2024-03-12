import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;




public class CollecctionInterface
{


   

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(21);
        nums.add(2);
        nums.add(3);
        for ( int i =0; i< nums.size(); ++i )
        {
            System.out.println(nums.get(i));
        }
        for (int x:nums)
        {
            System.out.println(x);
        }
        Iterator<Integer> it = nums.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println(nums);
        
    //     Map<String, Integer> students = new HashMap<>();

    //     students.put(null, null)

    //     for ( String name : students.keySet())
    //     {
    //         System.out.println(name + " : "+ students.get(name));
    //     }
       
    //     // Set<Integer> nums = new TreeSet<Integer>();

    //     // nums.add(55);
    //     // nums.add(65);
    //     // nums.add(85);
    //     // nums.add(84);
    //     // nums.add(78);
    //     // System.out.println(nums);
    // //     ArrayList<Integer> nums = new ArrayList<Integer>();

    // //     nums.add(5);
    // //     nums.add(6);
    // //     nums.add(8);
    // //     nums.add(8);
    // //     nums.add(7);

    // //    System.out.println(nums.get(0));
   
    // //     System.out.println(nums);
 
    }
}