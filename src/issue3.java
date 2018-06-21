import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 */
public class issue3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line1=sc.nextLine();
        String line2=sc.nextLine();
        int index=0;
        int length1=line1.length(),
                length2=line2.length(),
                length=0;
        length=length1+length2;
        int zero1=length1%8,
                zero2=length2%8;
        if (zero1!=0){
            int tmp=8-zero1;
            length+=tmp;
            while (tmp>0){
                line1=line1+"0";
                tmp--;
            }
        }
        if (zero2!=0){
            int tmp=8-zero2;
            length+=tmp;
            while (tmp>0){
                line2=line2+"0";
                tmp--;
            }
        }
        int count=length/8;
        String line=line1+line2;
        for (int i=0;i<count;i++){
            System.out.println(line.substring(8*i,8*i+8));
        }
    }
}
