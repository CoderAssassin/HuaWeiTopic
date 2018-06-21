import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 句子逆序
 */
public class issue12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(" ");
        int i;
        for (i = lines.length - 1; i > 0; i--) {
            System.out.print(lines[i] + " ");
        }
        System.out.print(lines[i]);
    }
}
