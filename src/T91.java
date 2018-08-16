import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:57 18-8-16
 * 在字符串中找出连续最长的数字串：我的解法
 **/
public class T91 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            if (str.equals(""))
                System.out.println("");
            Map<Integer,List<String>> map=new HashMap<>();
            int max=0,count=0;
            boolean flag=false;

            int i=0;
            for (i=0;i<str.length();i++){
                if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    count++;
                    if (!flag)
                        flag=true;
                }else {
                    if (count>=max){
                        max=count;
                        if (flag){
                            if (!map.containsKey(max)){
                                List<String> list=new ArrayList<>();
                                list.add(str.substring(i-max,i));
                                map.put(max,list);
                            }else {
                                map.get(max).add(str.substring(i-max,i));
                            }
                        }
                    }
                    flag=false;
                    count=0;
                }
            }
            if (flag&&count>=max){
                max=count;
                if (!map.containsKey(max)){
                    List<String> list=new ArrayList<>();
                    list.add(str.substring(i-max,i));
                    map.put(max,list);
                }else {
                    map.get(max).add(str.substring(i-max,i));
                }
            }

            if (max==0){
                System.out.println("");
                continue;
            }

            List<String> res=map.get(max);
            for(String s:res)
                System.out.print(s);
            System.out.println(","+max);
        }
    }
}
