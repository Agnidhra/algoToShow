package Arrays;

/*

Leetcode

1086. High Five

Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.



Example 1:

Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation:
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.


Note:

1 <= items.length <= 1000
items[i].length == 2
The IDs of the students is between 1 to 1000
The score of the students is between 1 to 100
For each student, there are at least 5 scores
*/

import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC1086 {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> trackingData = new TreeMap<Integer, PriorityQueue<Integer>>();
        for(int[] item: items) {
            if(trackingData.containsKey(item[0])){
                trackingData.get(item[0]).add(item[1]);
                if(trackingData.get(item[0]).size()>5) {
                    trackingData.get(item[0]).remove();
                }
            } else {
                PriorityQueue<Integer> scores = new PriorityQueue<Integer>();
                scores.add(item[1]);
                trackingData.put(item[0], scores);
            }
        }

        int[][] result= new int[trackingData.size()][2];
        int Counter = 0;
        for(int data: trackingData.keySet()) {
            result[Counter][0] = data;
            int sum = 0;
            int scoreLength = trackingData.get(data).size();
            while(trackingData.get(data).size()>0) {
                sum = sum + trackingData.get(data).poll();
            }
            result[Counter][1] = sum/scoreLength;
            Counter++;
        }
        return result;

    }
}
