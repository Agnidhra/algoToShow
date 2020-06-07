import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
1213. Intersection of Three Sorted Arrays

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.



Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.


Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000
*/

public class LC1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> output = new ArrayList<Integer>();
        HashSet<Integer> firstSet = new HashSet<Integer>();
        HashSet<Integer> secondSet = new HashSet<Integer>();
        for(int item: arr2) {
            firstSet.add(item);
        }
        for(int item: arr3) {
            secondSet.add(item);
        }
        for(int item: arr1) {
            if(firstSet.contains(item) && secondSet.contains(item)) {
                output.add(item);
            }
        }
        return output;
    }
}
