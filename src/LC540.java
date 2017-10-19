/**
 * Created by u8j8u on 2017/10/17.
 */
public class LC540 {
    public int singleNonDuplicate(int[] nums) {
        int idx = findSingle(nums, 0, nums.length-1);
        return nums[idx];
    }
    private int findSingle(int[] nums, int start, int end){
        if(start == end)
            return start;
        else if(start > end || start + 1 == end)
            return -1;
        else{
            int mid = (start + end) / 2;
            if(nums[mid] == nums[mid+1]){
                int leftRet = findSingle(nums, start,mid-1);
                if(leftRet != -1)
                    return leftRet;
                int rightRet = findSingle(nums, mid+2, end);
                if(rightRet != -1)
                    return rightRet;
            }
            else if(nums[mid] == nums[mid-1]){
                int leftRet = findSingle(nums, start,mid-2);
                if(leftRet != -1)
                    return leftRet;
                int rightRet = findSingle(nums, mid+1, end);
                if(rightRet != -1)
                    return rightRet;
            }
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC540 solution = new LC540();
        int[] input = new int[]{1,1,2};
        System.out.println(solution.singleNonDuplicate(input));
    }
}
