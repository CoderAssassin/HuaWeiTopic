import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 购物单
 */
public class issue15 {

    private static int NUM=61;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt(),
                m=sc.nextInt();//N为总的金额数，m为物品数

        int[] v=new int[NUM];//物品的价格
        int[] p=new int[NUM];//物品价格*重要度
        int[] q=new int[NUM];//物品的主件id

        for (int i=0;i<m;i++){
            v[i]=sc.nextInt();
            p[i]=sc.nextInt()*v[i];
            q[i]=sc.nextInt();
        }

        int[][] max=new int[m+1][N+1];//记录价格*重要度和的最大值
        int[] mainPrice=new int[m+1];//记录主件的价格和编号
        int count=1;//索引主件，这里讲附件+组件的组合也算为一个组件

        for (int i=1;i<=m;i++){//表示装i件物品
            for (int j=1;j<=N;j++){//表示资金总额为j的时候
                if (q[i-1]==0){//如果是主件，那么直接计算主件的价格和重要度
                    mainPrice[count]=v[i-1];//记录主件价格
                    if (v[i-1]<=j){//如果当前的物品价格小于当前资金上限
                        max[i][j]=Math.max(max[i-1][j-v[i-1]]+p[i-1],max[i-1][j]);
                    }
//                    else {
//                        max[i][j]=max[i-1][j];
//                    }
                }else {
//                    若附件的主件的资金已经超过资金上限，那么只买主件；否则算上附件
//                    if (mainPrice[q[i-1]]>j){
//                        max[i][j]=max[i-1][j];
//                    }else {
//                        if (mainPrice[q[i-1]]+v[i-1]<=j){//若附件加上去也小于资金上限
//                            max[i][j]=Math.max(max[i-1][j],max[i-1][j-v[i-1]]+p[i-1]);
//                        }else {
//                            max[i][j]=max[i-1][j];
//                        }
//                    }
                    if (v[i]+v[q[i]]<=j)
                        max[i][j]=Math.max(max[i-1][j],max[i-1][j-v[i-1]]+p[i-1]);
//                    else max[i][j]=max[i-1][j];
                }
            }
            count++;
        }
        System.out.println(max[m][N]);
    }
}
