import java.util.Scanner;
import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:27 18-8-15
 * 矩阵乘法计算量估算：别人解法
 **/
public class T69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nStr = sc.nextLine();
            int n = Integer.parseInt(nStr);
            int[][] matrix = new int[n][2];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                String[] tempArray = str.split(" ");
                matrix[i][0] = Integer.parseInt(tempArray[0]);
                matrix[i][1] = Integer.parseInt(tempArray[1]);
            }

            String expression = sc.nextLine();
            System.out.println(calculateMultiplyingCount(matrix,expression));

        }
    }
    private static int calculateMultiplyingCount(int[][] matrix, String ex) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for (int i = 0; i < ex.length(); i++) {
            char item = ex.charAt(i);
            if (Character.isLetter(item)) {//如果是字母，那么开始计算
                if (!stack.isEmpty() && stack.peek() != -1) {//如果栈非空且前面正好是个矩形
                    int col = stack.pop();//第一个矩形列
                    int row = stack.pop();//第一个矩形行
                    int col2 = matrix[index][1];//第二个矩形列
                    result += row * col2 * col;

                    stack.push(row);
                    stack.push(col2);
                } else {
                    stack.push(matrix[index][0]);
                    stack.push(matrix[index][1]);
                }
                index ++ ;
            } else if (item == '(') {//如果是左括号，用-1代替
                stack.push(-1);
            } else if (item == ')') {//如果是右括号，开始计算，前面的计算已经保证栈里每个左括号右边都保存有一个矩形
                int col1 = stack.pop();
                int row1 = stack.pop();
                stack.pop();
                if (stack.size() <= 1)
                    return result;
                if (stack.peek() != -1) {
                    stack.pop();
                    int row2 = stack.pop();
                    result += row2 * col1 * row1;
                    row1 = row2;
                }
                stack.push(row1);
                stack.push(col1);
            }

        }
        return result;
    }
}
