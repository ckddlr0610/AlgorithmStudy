/*
import java.util.*;

class Solution {

    static int target = 0;

    int searchTarget(String[] v) {
        List<String> tmp = new ArrayList<>();

        for (int i = 0; i < v.length; i++) {
            tmp.add(v[i]);
        }
        Collections.sort(tmp);

        int result = 1;
        for (int i = 1; i < v.length; i++) {
            if (tmp.get(i).equals(tmp.get(i - 1))) continue;
            result++;
        }

        return result;
    }

    public int[] solution(String[] gems) {
        target = searchTarget(gems);
        int size = gems.length;
        int min = 987654321;
        int[] answer = new int[2];
        Arrays.fill(answer, 987654321);

        for (int i = 0; i < size; i++) {
            int cnt = 0;import java.util. *;

            public class S3 {
                public static void main(String[] args) {
                    System.out.println(Arrays.toString(new Solution().solution(new String[]{
                            "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
                    })));
                }

                static class Solution {

                    static int target = 0;

                    int findTarget(String[] v) {
                        List<String> tmp = new ArrayList<>();

                        for (int i = 0; i < v.length; i++) {
                            tmp.add(v[i]);
                        }
                        Collections.sort(tmp);

                        int result = 1;
                        for (int i = 1; i < v.length; i++) {
                            if (tmp.get(i).equals(tmp.get(i - 1))) continue;
                            result++;
                        }

                        return result;
                    }

                    public int[] solution(String[] gems) {
                        target = findTarget(gems);
                        int size = gems.length;
                        int min = 987654321;
                        int[] answer = new int[2];
                        Arrays.fill(answer, 987654321);

                        for (int i = 0; i < size; i++) {
                            int cnt = 0;
                            Map<String, Integer> m = new HashMap<>();

                            m.put(gems[i], 2);
                            cnt++;

                            for (int j = i; j < size; j++) {
                                if (m.get(gems[j]) != null && m.get(gems[j]) != 0) continue;
                                m.put(gems[j], 2);
                                cnt++;
                                if (cnt == target) {
                                    if (min > j - i || (min == (j - i) && (answer[0] > i))) {
                                        min = j - i;
                                        answer[0] = i;
                                        answer[1] = j;
                                    }
                                }
                            }
                        }

                        answer[0] += 1;
                        answer[1] += 1;

                        return answer;
                    }
                }
            }
            Map<String, Integer> m = new HashMap<>();

            m.put(gems[i], 2);
            cnt++;

            for (int j = i; j < size; j++) {
                if (m.get(gems[j]) != null && m.get(gems[j]) != 0) continue;
                m.put(gems[j], 2);
                cnt++;
                if (cnt == target) {
                    if (min > j - i || (min == j - i && answer[0] > i)) {
                        min = j - i;
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
        }

        return answer;
    }
}*/
