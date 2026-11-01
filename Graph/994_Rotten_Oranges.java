class Solution {
    private void dfs(int[][] grid,int row,int col,int time,int rows,int cols){
        if(row<0 || col<0 || row>=rows || col>=cols || grid[row][col]==0 || (grid[row][col]>1 && grid[row][col]<time) ){
            return;
        }
        grid[row][col]=time;
        dfs(grid,row-1,col,time+1,rows,cols);
        dfs(grid,row+1,col,time+1,rows,cols);
        dfs(grid,row,col-1,time+1,rows,cols);
        dfs(grid,row,col+1,time+1,rows,cols);
    }
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){

                if(grid[row][col]==2){
                    dfs(grid,row,col,2,rows,cols);
                }
            }
        }
        int minutes=2;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    return -1;
                }
                minutes=Math.max(minutes,grid[row][col]); 
            }
        }
        return minutes-2;
    }
}
