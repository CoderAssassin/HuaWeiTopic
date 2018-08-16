import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:29 18-8-16
 * 火车进站：别人解法
 **/
public class T76 {

    private static Stack<String> list=new Stack<>();
    private static Stack<String> stack=new Stack<>();
    private static List<String> res=new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            sc.nextLine();
            String str=sc.nextLine();
            String[] trains=str.split(" ");

            for (int i=N-1;i>=0;i--)
                list.add(trains[i]);

            dfs("");
            Collections.sort(res);
            for (String s:res)
                System.out.println(s);

        }

    }

    private static void dfs(String cur){
        if (list.isEmpty()&&stack.isEmpty()){
            res.add(cur.trim());
            return;
        }

        if (!stack.isEmpty()){//这种情况是中间提前出栈
            String str1=stack.pop();
            dfs(cur+" "+str1);
            stack.push(str1);
        }

        if (!list.isEmpty()){//这种情况是将新的数入栈
            String str2=list.pop();
            stack.push(str2);
            dfs(cur);
            stack.pop();
            list.push(str2);
        }

    }

}
