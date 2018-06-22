import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:51 18-6-22
 * 称砝码：我的解法
 * 思路：用一个set避免重复，依次遍历每个重量的砝码，依次增加数量
 **/
public class T40 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] weight=new int[n];
            int[] nums=new int[n];
            for (int i=0;i<n;i++)
                weight[i]=sc.nextInt();
            for (int i=0;i<n;i++)
                nums[i]=sc.nextInt();

            System.out.println(function(n,weight,nums));
        }
    }


    public static int function(int n,int[] weights,int[] numbers){
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<=numbers[0];i++)
            set.add(i*weights[0]);
        for(int i=1;i<n;i++){//从第二个砝码开始
            List<Integer>list =new ArrayList<Integer>(set);
            for(int j=1;j<=numbers[i];j++){//遍历砝码的个数
                for(int k=0;k<list.size();k++)
                    set.add(list.get(k)+j*weights[i]);
            }
        }
        return set.size();
    }
}
