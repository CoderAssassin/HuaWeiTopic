import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午8:58 18-8-16
 * 尼科彻斯定理：我的解法
 **/
public class T75 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int m=sc.nextInt();
            int[] res=new int[m];
            int mid=m*m;//平均每个数大小
            int left=m/2;//每半边的数的个数
            int index=left-1;//左边索引结尾
            int k;
            if (mid%2==0)
                k=1;
            else k=2;
            while (index>=0){
                res[index--]=mid-k;
                k+=2;
            }
            index=left;
            if (m%2==1)//奇数的中点正好是mid
                res[index++]=mid;

            if (mid%2==0)
                k=1;
            else k=2;
            while (index<m){
                res[index++]=mid+k;
                k+=2;
            }

            for (int i=0;i<m;i++){
                if (i==0)
                    System.out.print(res[i]);
                else System.out.print("+"+res[i]);
            }
            System.out.println();
        }
    }
}
