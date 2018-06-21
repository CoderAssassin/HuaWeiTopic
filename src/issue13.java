import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by AliYang on 2018/3/2.
 * 字串的连接最长路径查找
 */
class stringComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1=(String)o1;
        String s2=(String)o2;
        if (s1.compareTo(s2)<0)
            return -1;
        else if (s1.equals(s2))
            return 0;
        else return 1;
    }
}
public class issue13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> queue=new PriorityQueue<String>(new stringComparator());
        int n=Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            String word=br.readLine();
            queue.add(word);
        }
        for (int i=0;i<n;i++)
            System.out.println(queue.poll());
    }
}
