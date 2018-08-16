import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:11 18-8-16
 * 超长正整数相加：我的解法
 **/
public class T77 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String line1=sc.nextLine();
            String line2=sc.nextLine();

            if (line1.length()<line2.length())
                System.out.println(add(line1,line2));
            else System.out.println(add(line2,line1));
        }
    }

    private static String add(String line1,String line2){

        boolean flag=false;//进位标志
        int incre=0;//增量
        List<Integer> res=new LinkedList<>();
        String res1="";

        int i=line1.length()-1;
        int j=line2.length()-1;
        for (;i>=0;i--,j--){
            int num1=line1.charAt(i)-'0';
            int num2=line2.charAt(j)-'0';

            int now=(incre+num1+num2)%10;
            res.add(now);
            incre=(incre+num1+num2)/10;
        }

        for (;j>=0;j--){
            int num3=line2.charAt(j)-'0';
            int now=(incre+num3)%10;
            res.add(now);
            incre=(incre+num3)/10;
        }
        if (incre!=0)
            res.add(incre);
        Collections.reverse(res);
        i=0;
        while (i<res.size()&&res.get(i)==0)
            i++;
        for (;i<res.size();i++)
            res1+=res.get(i);
        return res1;
    }
}
