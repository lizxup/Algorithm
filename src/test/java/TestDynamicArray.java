import com.peanut.datastructure.DynamicArray;
import org.junit.Test;

public class TestDynamicArray {



    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);

        int removed = dynamicArray.remove(3);
        System.out.println(removed);

        dynamicArray.stream().forEach(ele->{
            System.out.println(ele);
        });
    }
}
