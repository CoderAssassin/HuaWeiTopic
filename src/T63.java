import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:11 18-8-15
 * MP3光标位置：我的解法
 **/
public class T63 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String command=sc.next();
            int len=command.length();
            int now=1,start=1,end=0;//光标位置
            end=n<=4?n:4;
            for (int i=0;i<len;i++){
                if (command.charAt(i)=='U'){
                    if (now==1){
                        if (n>4){
                            end=n;
                            start=n-4+1;
                        }
                        now=n;
                    }else {
                        if (n>4){
                            if (start==now){//只有在start==now的时候才需要更新本页内容
                                start=now-1;
                                end=end-1;
                            }
                        }
                        now=now-1;
                    }
                }else{
                    if (now==n){
                        if (n>4){
                            end=4;
                            start=1;
                        }
                        now=1;
                    }else {
                        if (n>4){
                            if (end==now){
                                start=start+1;
                                end=end+1;
                            }
                        }
                        now++;
                    }
                }
            }

            for (int i=start;i<=end;i++){
                if (i==start)
                    System.out.print(i);
                else System.out.print(" "+i);
            }
            System.out.println();
            System.out.println(now);
        }
    }
}
