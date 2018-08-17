import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:18 18-8-17
 * 字符统计：我的解法
 **/
public class T101 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            Map<Character,Integer> map=new TreeMap<>();
            for (int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if (map.containsKey(c))
                    map.put(c,map.get(c)+1);
                else {
                    map.put(c,1);
                }
            }

            Set<Map.Entry<Character,Integer>> entries=map.entrySet();
            List<Map.Entry<Character,Integer>> list=new LinkedList<>(entries);
            Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {
                @Override
                public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
                    if (o1.getValue()>o2.getValue())
                        return -1;
                    else if (o1.getValue()==o2.getValue())
                        return 0;
                    else return 1;
                }
            });

            for (int i=0;i<list.size();i++)
                System.out.print(list.get(i).getKey());
            System.out.println();
        }
    }
}
