//
//  LC1266.swift
//  
//
//  Created by Agnidhra Gangopadhyay on 6/10/20.
//

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
