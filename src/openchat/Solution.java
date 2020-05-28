package openchat;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] answer = solution(record);

        for (String i : answer) {
            System.out.println(i);
        }
    }

    public static String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> profileMap = new HashMap<>();
        int cnt = 0;

        for (int i=0; i<record.length; i++) {
            String[] splitedStr = record[i].split(" ");
            if (!(splitedStr[0].equals("Leave"))) {
                profileMap.put(splitedStr[1], splitedStr[2]);
                cnt++;
            }
        }

        answer = new String[cnt];

        for(int i=0; i<record.length; i++) {
            String[] tempStr = record[i].split(" ");
            String event = tempStr[0];

            if (event.equals("Enter")) {
                answer[i] = profileMap.get(tempStr[1]) + "님이 들어왔습니다.";
            } else if (event.equals("Leave")) {
                answer[i] = profileMap.get(tempStr[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
