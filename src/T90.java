import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:48 18-8-16
 * 201301 JAVA 题目2-3级：我的解法
 **/
public class T90 {

    private static int res=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            res=0;
            boolean[][] board=new boolean[m+1][n+1];
            dfs(board,m+1,0,n+1,0);
            System.out.println(res);
        }
    }

    private static void dfs(boolean[][] board,int row,int row_now,int col,int col_now){

        if (row_now==row-1&&col_now==col-1){
            res+=1;
            return;
        }

        if (col_now+1<col&&!board[row_now][col_now+1]){
            board[row_now][col_now+1]=true;
            dfs(board,row,row_now,col,col_now+1);
            board[row_now][col_now+1]=false;
        }

        if (row_now+1<row&&!board[row_now+1][col_now]){
            board[row_now+1][col_now]=true;
            dfs(board,row,row_now+1,col,col_now);
            board[row_now+1][col_now]=false;
        }
    }
}
