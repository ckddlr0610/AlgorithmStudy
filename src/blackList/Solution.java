/**
 * 카카오 2019 겨울 개발자 불량 사용자 문제
 * 틀렸다. 어떤 userId가 ban이 됐을 때 그럼 그 다음부터는
 * 불량 사용자 검사에 들어가면 안된다
 * 그것을 고려못했음
 * count의 초기화 역시 userid를 검사하는 반복문에서 초기화해줘야하는데 위치선정 잘못함
 */

package blackList;

class Solution {
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int[] result = new int[banned_id.length];

        for (int i=0; i<banned_id.length; i++){
            String bannedId = banned_id[i];
            int len = bannedId.length();
            for (int j=0; j<user_id.length; j++){
                String userId = user_id[j];
                int count = 0;
                if (!(len==userId.length())){
                    continue;
                }
                for (int z=0; z<len; z++){
                    if (bannedId.charAt(z)=='*'){
                        count++;
                        continue;
                    }
                    if (bannedId.charAt(z)==userId.charAt(z)){
                        count++;
                        continue;
                    }
                }
                if (count == len) {
                    result[i]++;
                }
            }
        }
        answer = result[0];
        for (int i=1; i<result.length; i++) {
            answer = answer*result[i];
        }

        return answer;
    }

    public static void main(String[] args){
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "*rodo", "******", "******"};

        int result = solution(userId,bannedId);
        System.out.println(result);
    }
}
