import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:42 18-8-15
 * DNA序列：我的解法
 **/
public class T62 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int sublen=sc.nextInt();
            int len=str.length();

            if (sublen>=len){
                System.out.println(str);
                continue;
            }

            Map<Integer,Integer> gc=new LinkedHashMap<>(len-sublen+1);//记录从第i位置开始的连续子串的gc-ratio

            int start=0,end=sublen-1;
            int count=0;
            for (int i=0;i<=sublen;i++){
                if (str.charAt(i)=='G'||str.charAt(i)=='C')
                    count++;
            }
            gc.put(0,count);

            while (start<len-sublen&&end<len-1){
                if (str.charAt(start)=='G'||str.charAt(start)=='C')
                    count--;
                start++;
                if (str.charAt(end+1)=='G'||str.charAt(end+1)=='C')
                    count++;
                end++;
                gc.put(start,count);
            }

            List<Map.Entry> list=new LinkedList<>(gc.entrySet());
            Collections.sort(list, new Comparator<Map.Entry>() {
                @Override
                public int compare(Map.Entry o1, Map.Entry o2) {
                    if ((int)o1.getValue()>(int)o2.getValue())
                        return -1;
                    else if ((int)o1.getValue()==(int)o2.getValue())
                        return 0;
                    else return 1;
                }
            });
            start=(int)list.get(0).getKey();
            int tmpstart=start;
            for (;start<tmpstart+sublen;start++)
                System.out.print(str.charAt(start));
            System.out.println();
        }
    }
}
