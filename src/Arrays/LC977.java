package Arrays;

/*
LeetCode
977. Squares of a Sorted Array
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
* */


public class LC977 {
    public int[] sortedSquares(int[] A) {
        int start = 0 ;
        int end = A.length - 1;
        int outputend = A.length - 1;
        int [] output = new int [A.length];
        while(start<=end) {
            if(Math.abs(A[start]) > Math.abs(A[end])) {
                output[outputend] = A[start] * A[start];
                start ++;
                outputend--;
            } else {
                output[outputend] = A[end] * A[end];
                end--;
                outputend--;
            }
        }
        return output;
    }
}
