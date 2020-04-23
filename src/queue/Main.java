/**
 * 백준 18258 성공
 * 배열 대신 링 버퍼로 큐를 만들자
 * 배열로 하면 pop할 때 배열을 밀어내는 과정이 너무 오래 걸린다
 */

package queue;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(reader.readLine());

        Queue queue = new Queue(num);

        for (int i=0; i<num; i++){
            int res = 0;
            String input = reader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input," ");
            String message = tokenizer.nextToken();

            if (message.contains("push")){
                int item = Integer.parseInt(tokenizer.nextToken());
                queue.push(item);
            } else if (message.contains("pop")) {
                res = queue.pop();
                writer.write(res +"\n");
            } else if (message.contains("size")) {
                res = queue.size();
                writer.write(res +"\n");
            } else if (message.contains("empty")) {
                boolean isEmpty = queue.empty();
                if (isEmpty) {
                    writer.write(1 +"\n");
                } else {
                    writer.write(0 +"\n");
                }
            } else if (message.contains("front")) {
                res = queue.front();
                writer.write(res +"\n");
            } else if (message.contains("back")) {
                res = queue.back();
                writer.write(res +"\n");
            }
            writer.flush();
        }
        writer.close();
    }
}

class Queue {
    int[] arrQueue;
    int front;
    int rear;
    int num;
    int max;

    Queue(int max){
        this.arrQueue = new int[max];
        this.max = max;
        this.front = 0;
        this.rear = 0;
        this.num = 0;
    }

    public void push(int item){
        arrQueue[rear++] = item;
        num++;
        if (rear == max)
            rear = 0;
    }

    public int pop(){
        if (empty()){
            return -1;
        } else {
            int res = arrQueue[front++];
            num--;
            if (front == max)
                front = 0;
            return res;
        }
    }

    public int size(){
        return num;
    }

    public boolean empty(){
        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int front(){
        if (empty()){
            return -1;
        } else {
            return arrQueue[front];
        }
    }

    public int back(){
        if (empty()){
            return -1;
        } else {
            return arrQueue[rear-1];
        }
    }
}
