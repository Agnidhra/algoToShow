package Arrays;

/*
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class LC283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int numberOfZeros = 0;
        for(int i =0 ;i <= nums.length-1; i++) {
            if(nums[i] == 0) {
                numberOfZeros++;
            } else {
                nums[i-numberOfZeros] = nums[i];
                if(numberOfZeros>0) {
                    nums[i] = 0;
                }
            }
        }
    }
}
