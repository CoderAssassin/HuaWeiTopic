import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:46 18-8-14
 * 输出单向链表中倒数第k个结点：我的解法
 * 坑点：最后一个输入是k=0，这时候要输出0
 **/
public class T50 {

    private static class ListNode {
        int key;
        ListNode next;
        public ListNode(int key){
            this.key=key;
            next=null;
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            ListNode head=new ListNode(-1);
            ListNode tmp=head;
            for (int i=0;i<N;i++){
                tmp.next=new ListNode(sc.nextInt());
                tmp=tmp.next;
            }
            int k=sc.nextInt();
            ListNode slow=head,fast=head;

            if (k==0){
                System.out.println("0");
                continue;
            }

            for (int i=0;i<k;i++)
                fast=fast.next;

            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            System.out.println(slow.next.key);
        }
        sc.close();
    }
}
