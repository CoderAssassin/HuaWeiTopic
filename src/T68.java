import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:18 18-8-15
 * 矩阵乘法：我的解法
 **/
public class T68 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int row1=sc.nextInt();
            int col1=sc.nextInt();
            int row2=col1;
            int col2=sc.nextInt();

            int[][] matrix1=new int[row1][col1];
            int[][] matrix2=new int[row2][col2];

            for (int i=0;i<row1;i++)
                for (int j=0;j<col1;j++)
                    matrix1[i][j]=sc.nextInt();
            for (int i=0;i<row2;i++)
                for (int j=0;j<col2;j++)
                    matrix2[i][j]=sc.nextInt();

            for (int i=0;i<row1;i++){//结果行
                for (int j=0;j<col2;j++){//结果列
                    int sum=0;
                    int m=0,n=0;
                    while (m<col1&&n<row2){
                        sum+=matrix1[i][m]*matrix2[n][j];
                        m++;
                        n++;
                    }
                    if (j==0)
                        System.out.print(sum);
                    else System.out.print(" "+sum);
                }
                System.out.println();
            }
        }
    }
}
