import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:44 18-8-16
 * 将真分数分解为埃及分数：别人解法
设某个真分数的分子为a，分母为b;
把c=(b/a+1)作为分解式中第一个埃及分数的分母；
将a-b%a作为新的a；
将b*c作为新的b；
如果a等于1，则最后一个埃及分数为1/b,算法结束；
如果a大于1但是a能整除b，则最后一个埃及分数为1/(b/a),算法结束；
否则重复上面的步骤。
 **/
public class T81 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] str1=str.split("/");
            int a=Integer.parseInt(str1[0]);
            int b=Integer.parseInt(str1[1]);
            String res="";

            while (a!=1){
                if (b%(a-1)==0){
                    res=res+"1/"+(b/(a-1))+"+";
                    a=1;
                }else {
                    int c=b/a+1;
                    res=res+"1/"+c+"+";
                    a=a-b%a;
                    b=b*c;
                    if (b%a==0){
                        b=b/a;
                        a=1;
                    }
                }
            }
            res=res+""+a+"/"+b;
            System.out.println(res);
        }
    }
}
