import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:47 18-8-15
 * 参数解析：我的解法
 **/
public class T73 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            List<String> list=new ArrayList<>();

            int start=0;
            boolean yinhao=false;
            for (int i=0;i<str.length();i++){

                while (str.charAt(i)==' ')
                    i++;
                if (str.charAt(i)=='“'){
                    i++;
                    yinhao=true;
                }
                start=i;
                while (!yinhao&&i<str.length()&&str.charAt(i)!=' '||yinhao&&i<str.length()&&str.charAt(i)!='”')
                    i++;
                yinhao=false;
                list.add(str.substring(start,i));
//                if (str.charAt(i)=='”')
//                    list.add(str.substring(start,i));
//                else
//                    list.add(str.substring(start,i));
            }
            System.out.println(list.size());
            for (int i=0;i<list.size();i++)
                System.out.println(list.get(i));
        }
    }
}