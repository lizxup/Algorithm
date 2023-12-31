import org.junit.Test;
import com.peanut.binarysearch.BinarySearch;

import java.util.Arrays;

public class TestEverCase {


    @Test
    public void test1(){
        int[] nums = new int[]{2,5,8};
        int target = 1;
        Arrays.sort(nums);
        int index = Arrays.binarySearch(nums, target);
        System.out.println(index);
    }


    @Test
    public void testFarLeft(){
        int[] nums = new int[]{2,2};
        int index = BinarySearch.binarySearchFarLeft(nums,3);
        System.out.println(index);
    }
    @Test
    public void testFarRight(){
        int[] nums = new int[]{2,2};
        int index = BinarySearch.binarySearchFarRight(nums,3);
        System.out.println(index);
    }
}
