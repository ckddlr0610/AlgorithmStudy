/**
 * 카카오 2019 겨울 개발자 불량 사용자 문제
 * 틀렸다. 어떤 userId가 ban이 됐을 때 그럼 그 다음부터는
 * 불량 사용자 검사에 들어가면 안된다
 * 그것을 고려못했음
 * count의 초기화 역시 userid를 검사하는 반복문에서 초기화해줘야하는데 위치선정 잘못함
 */

package blackList;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    static int count;
    static ArrayList<ArrayList> list;
    static String[] user_id;
    static String[] banned_id;
    static boolean[] visited;
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        count = 0;
        list = new ArrayList<>();
//        this.user_id = user_id;
//        this.banned_id = banned_id;

        visited = new boolean[user_id.length];

        dfs(visited, 0);

        answer = count;

        return answer;
    }

    static void dfs(boolean[] visited, int idx) {
        if (idx==banned_id.length) {
            ArrayList<String> tempList = new ArrayList<>();
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    String temp = user_id[i];
                    tempList.add(temp);
                }
            }

            if (list.isEmpty()) {
                list.add(tempList);
                count++;
            }

            for (int i=0; i<list.size(); i++) {
                ArrayList<String> listCopy = list.get(i);
                if (!listCopy.contains(tempList)) {
                    list.add(tempList);
                    count++;
                }
            }
            return;
        }

        for (int i=0; i<user_id.length; i++) {
            String s = banned_id[idx].replace('*', '.');
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(user_id[i]);

            if (matcher.find() && (user_id[i].length() == banned_id[idx].length())) {
                    visited[i] = true;
                    dfs(visited, idx+1);
                    visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        banned_id = new String[]{"fr*d*", "*rodo", "******", "******"};

        int result = solution(user_id, banned_id);
        System.out.println(result);
    }
}
