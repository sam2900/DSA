package DPP;

public class MinTimeToVisitPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        //count to keep track of time or we can say steps we take to change coordinates
        int count=0;
        int x,y,x1,y1;
        //x and y represents current points and x1 and y1 represents destination points
        for(int i=0;i<points.length-1;i++){
            //now we visit each coordinate and set both source and destination points
            x=points[i][0];
            y=points[i][1];
            x1=points[i+1][0];
            y1=points[i+1][1];
            while(x!=x1 || y!=y1){
                //here basically we increment or decrement the coordinates until we reach
                //destination by 1 unit only
                //and after each change either in x or y or both we take it as 1 unit step time
                x=(x<x1) ? ++x:(x>x1) ? --x:x;
                y=(y<y1) ? ++y:(y>y1) ? --y:y;
                count++;
            }
        }
        return count;
    }
}

/**
 * 1266. Minimum Time Visiting All Points
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.
 *
 * You can move according to these rules:
 *
 * In 1 second, you can either:
 * move vertically by one unit,
 * move horizontally by one unit, or
 * move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
 * You have to visit the points in the same order as they appear in the array.
 * You are allowed to pass through points that appear later in the order, but these do not count as visits.
 *
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 *
 * so basically my first approach is we will keep a count var to count time
 * x y x1 y1 vars to keep track of source destination coordinates
 *
 * now from the 2d matrix we get the source and destination coordinates and then
 * we run a while loop until we reach the destination from source
 *
 * in the loop we just increment/decrement the coordinates x and y 1 by 1 based on the
 * difference from the destination coordinates
 * and after each iteration we increase the count
 *
 * basically each iteration indicates a change in coordinate by 1 step
 *
 *
 */


//better Approach
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count=0;
        for(int i=1;i<points.length;i++){
            count+=helper(points[i-1],points[i]);
        }
        return count;
    }

    public int helper(int[] currPoints, int[] destPoints){
        //max x coordinate difference
        int x=Math.abs(destPoints[0]-currPoints[0]);
        //max y coordinate difference
        int y=Math.abs(destPoints[1]-currPoints[1]);

        //return the max of them
        return Math.max(x,y);
    }

    /**
     the approach is we will pass the current coordinates and the target coordinates to calculating
     function and that function will basically find the  maximum difference between x and y points,
     and we return the max difference and add to count
     */
}
