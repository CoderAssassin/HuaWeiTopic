import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:37 18-8-14
 * 四则运算：别人解法
 * 思路：关键是将中缀表达式转换成后缀表达式，首先判断当前符号是否是正负号，这里要注意当前是否是第一个符号，并且前面是否是数字；然后是读取数字；
 * 然后是判断当前是否是读到的数字，是的话将数字加入后缀表达式列表；不是的话判断当前的符号的优先级，如果符号不是括号，那么将高优先级的操作符加入
 * 中缀表达式，如果是括号，那么将右括号到左括号之间的所有的字符都加入后缀表达式。
 * 最后得到了后缀表达式之后就是对后缀表达式的计算了。
 **/
public class T49 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            Stack<Character> stack = new Stack<>();
            List<Object> list = new ArrayList<>();//后缀顺序

            for (int i = 0; i < line.length(); i++) {
                String T = "";
                boolean isN = false; // 负号
//                下面是判断当前的负号是否是负号
                if (i == 0 && line.charAt(i) == '-') {//字符串第一个字符是负号
                    isN = true;
                    ++i;
                } else if (line.charAt(i) == '-' && (line.charAt(i - 1) == '-' || line.charAt(i - 1) == '+'
                        || line.charAt(i - 1) == '*' || line.charAt(i - 1) == '/' || line.charAt(i - 1) == '('
                        || line.charAt(i - 1) == '[' || line.charAt(i - 1) == '{')) {//当前是负号并且前面的字符不是数字
                    isN = true;
                    ++i;
                }
//                读取完整的数字
                while (i < line.length() && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                    T = T + line.charAt(i++);
                }
                if (!T.equals("")) {//如果当前是数字，那么添加数字到列表
                    --i;
                    if (isN) {
                        list.add(0 - (new Integer(T)));
                    } else {
                        list.add(new Integer(T));
                    }
                } else {//如果不是数字，开始计算
                    char op = line.charAt(i);
                    if (op == '+' || op == '-' || op == '*' || op == '/') {
                        if (stack.isEmpty()) {
                            stack.push(op);
                        } else if (isUpperPro(op, (char) stack.peek())) {//如果当前操作op比前一个操作优先度高
                            stack.push(op);
                        } else {
                            while (!stack.isEmpty()
                                    && (stack.peek() != '(' || stack.peek() != '[' || stack.peek() != '{')
                                    && !isUpperPro(op, (char) stack.peek())) {//如果当前操作符优先级比前面的低
                                list.add(stack.pop());
                            }
                            stack.push(line.charAt(i));
                        }
                    } else if (op == '(' || op == '[' || op == '{') {//如果当前操作符是左括号，那么入栈
                        stack.push(op);
                    } else if (line.charAt(i) == ')') {//如果当前操作符是右括号，将栈中的非左括号的操作符都加入列表
                        while (stack.peek() != '(') {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    } else if (line.charAt(i) == ']') {
                        while (stack.peek() != '[') {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    } else if (line.charAt(i) == '}') {
                        while (stack.peek() != '{') {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            Stack<Integer> Pstack = new Stack<Integer>();
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {//后缀计算表达式
                Object temp = it.next();
                if (temp instanceof Integer) {
                    Pstack.push((Integer) temp);
                } else if (temp instanceof Character) {
                    int N2 = Pstack.pop();
                    int N1 = Pstack.pop();
                    int res = getRes(N1, N2, (char) temp);
                    Pstack.push(res);
                }
            }
            System.out.println(Pstack.pop());
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

//    判断op操作是否比peek操作优先
    public static boolean isUpperPro(char op, char peek) {
        if (peek == '(' || peek == '[' || peek == '{') {
            return true;
        }
        if ((op == '+' || op == '-') && (peek == '*' || peek == '/')) {
            return false;
        }
        if ((op == '*' || op == '/') && (peek == '+' || peek == '-')) {
            return true;
        }
        if ((op == '+' || op == '-') && (peek == '+' || peek == '-')) {
            return false;
        }
        if ((op == '*' || op == '/') && (peek == '*' || peek == '/')) {
            return false;
        }
        return false;
    }
}
