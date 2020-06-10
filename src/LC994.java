import java.util.HashSet;
import java.util.Set;

/*
994. Rotting Oranges
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
*/
public class LC994 {
    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<String>();
        Set<String> rotten = new HashSet<String>();
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh.add("" + i + j );
                } else if(grid[i][j] == 2) {
                    rotten.add("" + i + j );
                }
            }
        }
        int[][] direction = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        int timer = 0;
        while(!fresh.isEmpty()) {
            Set<String> infected = new HashSet<String>();
            for(String eachRotten: rotten) {
                int rottentI = eachRotten.charAt(0) - '0';
                int rottentJ = eachRotten.charAt(1) - '0';
                for(int[] eachDirection: direction) {
                    if(((rottentI + eachDirection[0]) < grid.length && (rottentI + eachDirection[0]) >=0)
                            && ((rottentJ + eachDirection[1]) < grid[0].length && (rottentJ + eachDirection[1]) >=0)) {
                        if (grid[rottentI + eachDirection[0]][rottentJ + eachDirection[1]] == 1) {
                            grid[rottentI + eachDirection[0]][rottentJ + eachDirection[1]] = 2;
                            infected.add(""+ (rottentI + eachDirection[0]) + (rottentJ + eachDirection[1]));
                            fresh.remove(""+ (rottentI + eachDirection[0]) + (rottentJ + eachDirection[1]));
                        }
                    }
                }
            }
            if(infected.size() == 0) {
                break;
            }
            rotten = infected;
            timer++;
        }
        if(fresh.isEmpty()) {
            return timer;
        } else {
            return -1;
        }
    }
}
