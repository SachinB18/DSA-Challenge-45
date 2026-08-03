// Problem 2: Spiral Matrix Traversal
// Given a 2D matrix, return all elements in spiral order.

// Input: 
// [[1,2,3],
//  [4,5,6],
//  [7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]



import java.util.*;

public class Problem2 {

// Approach 1: Simulation using Visited Matrix
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0)return result;
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        int row=0,col=0,dir=0;
        for(int i=0;i<rows*cols;i++){
            result.add(matrix[row][col]);
            visited[row][col]=true;
            int newRow=row+dr[dir];
            int newCol=col+dc[dir];
            if(newRow<0||newRow>=rows||newCol<0||newCol>=cols||visited[newRow][newCol]){
                dir=(dir+1)%4;
            }
            row+=dr[dir];
            col+=dc[dir];
        }
        return result;
    }


    // Approach 2: Boundary Traversal
// Time Complexity: O(m*n)
// Space Complexity: O(1)

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0)return result;
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++)result.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bottom;i++)result.add(matrix[i][right]);
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--)result.add(matrix[bottom][i]);
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--)result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }


    // Approach 3: Recursive Layer Traversal
// Time Complexity: O(m*n)
// Space Complexity: O(min(m,n))


    public List<Integer> spiralOrder3(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0)return result;
        traverse(matrix,0,matrix.length-1,0,matrix[0].length-1,result);
        return result;
    }
    private void traverse(int[][] matrix,int top,int bottom,int left,int right,List<Integer> result){
        if(top>bottom||left>right)return;
        for(int i=left;i<=right;i++)result.add(matrix[top][i]);
        for(int i=top+1;i<=bottom;i++)result.add(matrix[i][right]);
        if(top<bottom){
            for(int i=right-1;i>=left;i--)result.add(matrix[bottom][i]);
        }
        if(left<right){
            for(int i=bottom-1;i>top;i--)result.add(matrix[i][left]);
        }
        traverse(matrix,top+1,bottom-1,left+1,right-1,result);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Problem2 obj = new Problem2();
        System.out.println(obj.spiralOrder(matrix));
        System.out.println(obj.spiralOrder1(matrix));
        System.out.println(obj.spiralOrder3(matrix));
    }
}
