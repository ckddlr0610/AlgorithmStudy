/**
 * 카카오 2019 인턴 호텔 방 배정
 * 입력값으로 10^18까지 올 수 있기 때문에 배열로 하면 메모리 초과가 된다.
 * 따라서 해시 맵으로 처리해야됨 맵으로 연습해보자
 */

package hotel;

class Solution {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};

        long[] result = solution(k, room_number);

        for (long i : result) {
            System.out.println(i);
        }
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = {};

        answer = new long[room_number.length];

        int a = (int) k;

        boolean[] isFull = new boolean[a];

        for(int i=0; i<room_number.length; i++) {
            for(int j=(int)room_number[i]; j<isFull.length; j++) {
                // 희망 방이 비었을 때
                int temp = (int)room_number[i];
                if(isFull[temp]==false) {
                    isFull[temp] = true;
                    answer[i] = room_number[i];
                    break;
                }
                // 희망 방이 예약 됐을 때
                if(isFull[j]==false) {
                    isFull[j] = true;
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}
