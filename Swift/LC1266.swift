// 1266. Minimum Time Visiting All Points
// On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
//
// You can move according to the next rules:
//
// In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
// You have to visit the points in the same order as they appear in the array.
//
//
// Example 1:
//
//
// Input: points = [[1,1],[3,4],[-1,0]]
// Output: 7
// Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
// Time from [1,1] to [3,4] = 3 seconds
// Time from [3,4] to [-1,0] = 4 seconds
// Total time = 7 seconds
// Example 2:
//
// Input: points = [[3,2],[-2,2]]
// Output: 5

import Foundation

class LC1266 {
    func minTimeToVisitAllPoints(_ points: [[Int]]) -> Int {
        if(points == nil || points[0].count == 0) {
            return 0
        }
        var step: Int = 0
        for index in 1...points.count-1 {
            var x = abs(points[index][0] - points[index-1][0])
            var y = abs(points[index][1] - points[index-1][1])
            step += max(x, y)
        }
        return step
    }
}
