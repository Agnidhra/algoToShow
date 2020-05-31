package Design;

/*
346. Moving Average from Data Stream
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

import java.util.LinkedList;
import java.util.Queue;

public class LC346 {

    Queue<Integer> data = new LinkedList<Integer>();
    int Size = 0;
    double sum = 0.0;
    /** Initialize your data structure here. */
    //public MovingAverage(int size) {
    public LC346(int size) {
        Size = size;
    }

    public double next(int val) {
        if(data.size()<Size) {
            sum+=val;
            data.add(val);
        } else {
            sum -= data.poll();
            sum+=val;
            data.add(val);
        }
        return sum/data.size();
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */