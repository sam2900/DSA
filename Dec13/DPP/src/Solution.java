class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){

                    boolean isTrue=true;
                    for(int k=0;k<mat[0].length;k++){
                        if(mat[i][k]==1 && k!=j){
                            isTrue=false;
                            break;
                        }
                    }
                    if(isTrue){
                        for(int k=0;k<mat.length;k++){
                            if(mat[k][j]==1 && k!=i){
                                isTrue=false;
                                break;
                            }
                        }
                    }
                    if(isTrue){
                        count++;
                    }
                }
            }
        }
        return count;
    }

}