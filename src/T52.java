import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:19 18-8-14
 * iNOC产品部-杨辉三角的变形：我的解法
 * 坑点：题意是arr[i][j]=arr[i-1][j-2]+arr[i-1][j-1]+arr[i-1][j]
 **/
public class T52 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] arr=new int[n+1][2*n];//总共n+1行2×n列，下标都从1开始
            arr[1][1]=1;
            for (int i=2;i<=n;i++){
                for (int j=1;j<=2*i-1;j++){
                    int num=0;
                    if (j-2>=1)
                        num+=arr[i-1][j-2];
                    if (j-1>=1)
                        num+=arr[i-1][j-1];
                    num+=arr[i-1][j];
                    arr[i][j]=num;
                }
            }
            for (int i=1;i<=n;i++){
                if (arr[n][i]%2==0){
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
