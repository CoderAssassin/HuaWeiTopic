import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:36 18-8-15
 * 输入n个整数，输出其中最小的k个：我的解法
 **/
public class T57 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            quickSort(arr,0,arr.length-1);

            for (int i=0;i<k;i++){
                if (i==0)
                    System.out.print(arr[i]);
                else System.out.print(" "+arr[i]);
            }
            System.out.println();
        }
    }

    private static void quickSort(int[] arr,int low,int high){

        int l=low,h=high;
        int pivot=arr[low];

        while (l<h){
            while (l<h&&arr[h]>=pivot)
                h--;
            if (l<h){
                int tmp=arr[l];
                arr[l]=arr[h];
                arr[h]=tmp;
                l++;
            }

            while (l<h&&arr[l]<=pivot)
                l++;
            if (l<h){
                int tmp=arr[l];
                arr[l]=arr[h];
                arr[h]=tmp;
                h--;
            }
        }
        arr[l]=pivot;
        if (l>low)
            quickSort(arr,low,l-1);
        if (h<high)
            quickSort(arr,h+1,high);
    }
}
