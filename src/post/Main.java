package post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Person> frame = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int frameNum = 0; // 액자 수
        int total = 0; // 투표 수

        String temp = bufferedReader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(temp);
        for (int i = 0; i < total; i++) {
            int voteNum = Integer.parseInt(tokenizer.nextToken());

            // 이미 후보가 있을 때
            for (int j=0; j < frame.size(); j++) {
                frame.get(j).addVote();
            }

            //아직 자리가 있을 때
            if (frame.size() != frameNum) {
                frame.add(new Person(voteNum, 1));
                continue;
            }

        }
    }
}

class Person {
    int sNum; // student number
    int vote; // vote count

    public Person(int sNum, int vote){
        this.sNum = sNum;
        this.vote = vote;
    }

    public void addVote() {
        this.vote += 1;
    }
}