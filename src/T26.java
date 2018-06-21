import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:41 18-6-21
 * 查找兄弟单词：我的解法
 * 思路：这题题目不清楚，很坑，主要思路是找出长度等于目标字符串的所有的字符串，然后字典序排序，输出第目标个
 **/
public class T26 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            Map<Integer,ArrayList<String>> map=new HashMap<>();//存储长度-单词列表
            for (int i=0;i<n;i++){
                String tmp=sc.next();
                int len=tmp.length();
                if (!map.containsKey(len)){
                    ArrayList<String> arr=new ArrayList<>();
                    arr.add(tmp);
                    map.put(len,arr);
                }else {
                    map.get(len).add(tmp);
                }
            }
            String target=sc.next();
            char[] tar=target.toCharArray();
            Arrays.sort(tar);
            target=String.valueOf(tar);
            int index=sc.nextInt();

            ArrayList<String> nowArr=map.get(target.length());//获取目标长度的所有单词

            Iterator it=nowArr.iterator();
            while (it.hasNext()){
                char[] tmp=((String)it.next()).toCharArray();
                Arrays.sort(tmp);

                String tmpTarget=String.valueOf(tmp);
                if (!tmpTarget.equals(target))
                    it.remove();
            }
            Collections.sort(nowArr);

            if (nowArr.size()==0){
                System.out.println(0);
                return;
            }
            if (nowArr.size()<index)
                System.out.println(nowArr.size());

            System.out.println(nowArr.size());
            System.out.println(nowArr.get(index-1));
        }
    }

}
