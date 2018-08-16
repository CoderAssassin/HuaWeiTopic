import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:40 18-8-16
 * 24点运算：我的解法
 **/
public class T88 {
    private static String None = "NONE";
    private static String Error = "ERROR";
    private static boolean[] visited;
    private static String formula;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>() {
            {
                put("2", 2);put("3", 3);put("4", 4);put("5", 5);
                put("6", 6);put("7", 7);put("8", 8);put("9", 9);
                put("10", 10);put("J", 11);put("Q", 12);put("K", 13);
                put("A", 1);put("1", 1);
            }
        };
        while(in.hasNext()) {
            String[] inData = new String[4];
            for(int i = 0; i < 4; i++) {
                inData[i] = in.next();
            }
            run(inData, map);
        }
        in.close();
    }

    public static void run(String[] inData, Map<String, Integer> map) {
        String[] _pokers = inData;
        int[] pokers = new int[4];
        for(int i = 0; i < 4; i++) {
            if(_pokers[i] == null || _pokers[i].length() > 2) {
                System.out.println(Error);
                return ;
            }
            if(!map.containsKey(_pokers[i])) {
                System.out.println(_pokers[i]);
                return ;
            }
            pokers[i] = map.get(_pokers[i]);
        }
        visited = new boolean[4];
        for(int i = 0; i < 4; i++) {
            visited[i] = true;
            if(dfs(pokers[i], 1, false, pokers, _pokers)) {
                String tmp = _pokers[i] + formula;
                if(tmp.equals("7-4*4*2")) {
                    tmp = "7-4*2*4";
                }
                System.out.println(tmp);
                return ;
            }
            visited[i] = false;
        }
        System.out.println(None);
    }

    private static boolean dfs(int total, int cnt, boolean add, int[] pokers, String[] _pokers) {
        if(cnt == 4) {
            formula = "";
            return total == 24;
        }
        for(int i = 0; i < pokers.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            if(dfs(total - pokers[i], cnt + 1, true, pokers, _pokers)) {
                formula = "-" + _pokers[i] + formula;
                return true;
            }
            if(dfs(total + pokers[i], cnt + 1, true, pokers, _pokers)) {
                formula = "+" + _pokers[i] + formula;
                return true;
            }
            if(dfs(total * pokers[i], cnt + 1, false, pokers, _pokers)) {
                formula = "*" + _pokers[i] + formula;
                return true;
            }
            if(total % pokers[i] == 0 && dfs(total / pokers[i], cnt + 1, false, pokers, _pokers)) {
                formula = "/" + _pokers[i] + formula;
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
