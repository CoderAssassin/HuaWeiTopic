import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:17 18-8-17
 * 记票统计：我的解法
 **/
public class T93 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            Map<String,Integer> candidates=new LinkedHashMap<>();
            for (int i=0;i<n;i++)
                candidates.put(sc.next(),0);
            int m=sc.nextInt();
            List<String> votes=new ArrayList<>(m);
            for (int i=0;i<m;i++)
                votes.add(sc.next());

            int invalid=0;
            for (int i=0;i<m;i++)
                if (candidates.containsKey(votes.get(i)))
                    candidates.put(votes.get(i),candidates.get(votes.get(i))+1);
                else invalid+=1;

            Set<Map.Entry<String,Integer>> entries=candidates.entrySet();
            for (Map.Entry<String,Integer> entry:entries)
                System.out.println(entry.getKey()+" : "+entry.getValue());
            System.out.println("Invalid : "+invalid);
        }
    }
}
