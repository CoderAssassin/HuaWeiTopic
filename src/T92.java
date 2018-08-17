import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:13 18-8-17
 * 201301 JAVA题目0-1级：别人解法
 **/
public class T92 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] other=new int[n];
            int count=0;

            int sum_three=0,sum_five=0;
            for (int i=0;i<n;i++){
                int tmp=sc.nextInt();
                if (tmp%5==0)
                    sum_five+=tmp;
                else if (tmp%5!=0&&tmp%3==0)
                    sum_three+=tmp;
                else
                    other[count++]=tmp;
            }

            int diff=Math.abs(sum_five-sum_three);

            if (dfs(0,count,other,0,diff)){
                System.out.println("true");
                continue;
            }else {
                System.out.println("false");
                continue;
            }
        }
    }

    private static boolean dfs(int i,int n,int[] a,int result,int sum){
        if (i==n)
            return Math.abs(result)==sum;//result是正的表示都加到一边，负的表示都加到另一边
        else return (dfs(i+1,n,a,result+a[i],sum)||(dfs(i+1,n,a,result-a[i],sum)));
    }
}