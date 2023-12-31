package src.binarysearch;


//线性查找
public class LinearSearch {


    public static int LinearSearch(int[] nums , int target){
        //不需要对nums数组进行排序
        for (int i = 0 ; i < nums.length ; i+=1){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
