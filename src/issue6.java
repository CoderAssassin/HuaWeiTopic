import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 取近似值
 */
public class issue6 {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        String num=sc.nextLine();
        int index=num.indexOf(".");
        if (index==num.length())
            System.out.println(num);
        else {
            String[] nums=num.split("\\.");
            int c=num.charAt(nums[0].length()+1);
            if (c>='5'){
                System.out.println((int)Math.ceil(Double.parseDouble(num)));
            }else System.out.println((int)Math.floor(Double.parseDouble(num)));
        }
    }
}
