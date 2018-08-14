import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:42 18-8-14
 * 表达式求值：我的解法
 **/
public class T53 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            Stack<Character> stack=new Stack();
            List<Object> list=new ArrayList();

            for (int i=0;i<str.length();i++){
//                判断正负
                boolean isNeg=false;
                if (i==0&&str.charAt(i)=='-'){
                    isNeg=true;
                    i++;
                }else if (str.charAt(i)=='-'&&(str.charAt(i-1)=='+'||str.charAt(i-1)=='-'||str.charAt(i-1)=='*'
                ||str.charAt(i-1)=='/'||str.charAt(i-1)=='(')){
                    isNeg=true;
                    i++;
                }

//                计算当前数
                String T="";
                char op;
                while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    T+=str.charAt(i);
                    i++;
                }
                if (!T.equals("")){
                    i--;
                    if (isNeg)
                        list.add(0-new Integer(T));
                    else list.add(new Integer(T));
                }else {
                    op=str.charAt(i);
                    if (op=='+'||op=='-'||op=='*'||op=='/'){
                        if (stack.isEmpty()){
                            stack.push(op);
                        } else if (isUpperOp(op,(char)stack.peek())){
                            stack.push(op);
                        } else{
                            while (!stack.isEmpty()&&(char)stack.peek()!='('&&!isUpperOp(op,(char)stack.peek())){
                                list.add(stack.pop());
                            }
                            stack.push(str.charAt(i));
                        }
                    }else if (op=='(')
                        stack.push(op);
                    else if (str.charAt(i)==')'){
                        while ((char)stack.peek()!='(')
                            list.add(stack.pop());
                        stack.pop();
                    }
                }
            }
            while (!stack.isEmpty()){
                list.add(stack.pop());
            }

            Stack<Integer> PStack=new Stack();
            Iterator it=list.iterator();
            while (it.hasNext()){
                Object tmp=it.next();
                if (tmp instanceof Integer){
                    PStack.push((Integer)tmp);
                }else if (tmp instanceof Character){
                    int N2=PStack.pop();
                    int N1=PStack.pop();
                    PStack.push(getRes(N1,N2,(char)tmp));
                }
            }
            System.out.println(PStack.pop());
        }
    }

    public static int getRes(int n1, int n2, char temp) {
        if (temp == '-') {
            return n1 - n2;
        }
        if (temp == '+') {
            return n1 + n2;
        }
        if (temp == '*') {
            return n1 * n2;
        }
        if (temp == '/') {
            return n1 / n2;
        }
        return 0;
    }

    private static boolean isUpperOp(char op1,char op2){
        if (op2=='(')
            return true;
        if ((op1=='+'||op1=='-')&&(op2=='*'||op2=='/'))
            return false;
        if ((op1=='+'||op1=='-')&&(op2=='+'||op2=='-'))
            return false;
        if ((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'))
            return true;
        if ((op1=='*'||op1=='/')&&(op2=='*'||op2=='/'))
            return false;
        return false;
    }
}
