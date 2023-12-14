import java.util.HashMap;

public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        HashMap<Integer,int[]> row=new HashMap<>();
        HashMap<Integer,int[]> col=new HashMap<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!row.containsKey(i)){
                    row.put(i,new int[2]);
                }
                row.get(i)[grid[i][j]]++;
                if(!col.containsKey(j)){
                    col.put(j,new int[2]);
                }
                col.get(j)[grid[i][j]]++;
            }
        }
    }
}
