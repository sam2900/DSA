package DeleteGreatestValueInEachRow;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class BFA {

        public static int deleteGreatestValue(int[][] grid) {
            if(grid.length==1 && grid[0].length==1) return grid[0][0];
            int ans=0;
            int col=grid[0].length;
            TreeMap<Integer, PriorityQueue<Integer>> map=new TreeMap<>();
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(!map.containsKey(i)){
                        map.put(i,new PriorityQueue<>());
                    }
                    map.get(i).offer(grid[i][j]);
                }
            }
            int max=-1;
            while(col>0){
                for(PriorityQueue<Integer> pq:map.values()){
                    max=Math.max(max,pq.poll());
                }
                ans+=max;
                max=-1;
                col--;
            }
            return ans;
        }
        public static void main(String[] args){
            int[][] grid={{1,2,4},{3,3,1}};
            System.out.println(deleteGreatestValue(grid));
        }
    }

