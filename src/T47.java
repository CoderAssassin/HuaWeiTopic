import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:15 18-8-14
 * 从单向链表中删除指定值的节点：我的解法
 * 坑点：输入的组数里第一个数表示是新的数，第二个数表示第一个数插入到第二个数的节点的后边；另外一个坑点是输出都是后边带括号的；另外输入是一串的带有空格的数
 **/
public class T47 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            handle(scanner);
        }
        scanner.close();
    }
    public static void handle(Scanner scanner){
        String str = scanner.nextLine();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int loc = str.indexOf(" ");
        int num = Integer.parseInt(str.substring(0,loc));
        str = str.substring(loc+1);
        loc = str.indexOf(" ");
        linkedList.add(Integer.parseInt(str.substring(0,loc)));
        str = str.substring(loc+1);
        int start,end;
        end = -1;
        for(int i=0;i<num-1;i++){
            start = end+1;
            int loc1 = str.indexOf(" ",start);
            end = str.indexOf(" ",loc1+1);
            int node = Integer.parseInt(str.substring(start,loc1));
            int after = Integer.parseInt(str.substring(loc1+1,end));
            int location = linkedList.indexOf(after);
            linkedList.add(location+1,node);
        }
        int deleteData = Integer.parseInt(str.substring(end+1));
        linkedList.remove(new Integer(deleteData));
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }
}
