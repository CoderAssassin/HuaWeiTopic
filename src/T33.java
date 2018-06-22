import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:41 18-6-22
 * 图片整理：我的解法
 * 思路：这题本意应该是考排序，这里偷鸡了下
 **/
public class T33 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){

            String str=sc.nextLine();
            char[] strs=str.toCharArray();
            Arrays.sort(strs);
            System.out.println(String.valueOf(strs));
        }
    }
}
