import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:26 18-8-15
 * 24点游戏算法：我的解法
 **/
public class T66 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int[] nums=new int[4];
            for (int i=0;i<4;i++)
                nums[i]=sc.nextInt();
            boolean[] visit=new boolean[4];
            if (dfs(nums,0,0,visit))
                System.out.println("true");
            else System.out.println("false");
        }
    }

    private static boolean  dfs(int[] nums,int count,int sum,boolean[] visit){

        if (count==4){
            if (sum==24)
                return true;
            return false;
        }
        int tmp=sum;
        for (int i=0;i<4;i++){
            if (visit[i])
                continue;
            visit[i]=true;
            tmp+=nums[i];
            if (dfs(nums,count+1,tmp,visit))
                return true;
            tmp=sum;

            tmp-=nums[i];
            if (dfs(nums,count+1,tmp,visit))
                return true;
            tmp=sum;

            tmp*=nums[i];
            if (dfs(nums,count+1,tmp,visit))
                return true;
            tmp=sum;

            tmp/=nums[i];
            if (count==3&&sum%nums[i]!=0){
                tmp=sum;
                visit[i]=false;
                continue;
            }
            if (dfs(nums,count+1,tmp,visit))
                return true;
            tmp=sum;
            visit[i]=false;
        }
        return false;
    }
}
