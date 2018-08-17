import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:12 18-8-17
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序：我的解法
 **/
public class T100 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            int order=sc.nextInt();
            Arrays.sort(arr);
            if (order==0){
                for (int i=0;i<n;i++){
                    if (i==0)
                        System.out.print(arr[i]);
                    else System.out.print(" "+arr[i]);
                }
                System.out.println();
            }else {
                for (int i=n-1;i>=0;i--){
                    if (i==n-1)
                        System.out.print(arr[i]);
                    else System.out.print(" "+arr[i]);
                }
                System.out.println();
            }
        }
    }
}
