package big

import java.util.*

/**
 * 백준 7568번 덩치 문제
 * 브루트 포스 연습
 *
 * 제출 성공
 */

fun main(){

    lateinit var arr_big : Array<Array<Int>> // 2차원 배열
    var num_people = 0
    var scanner = Scanner(System.`in`)

    //println("사람 수를 입력하십시오.")
    num_people = scanner.nextInt()
    arr_big = Array(num_people){Array(3){1} }

    for(i in 0 until num_people){
        //println("키와 몸무게를 차례대로 입력하십시오.")
        for (j in 0 until 2){
            arr_big[i][j] = scanner.nextInt()
        }
    }

    for (i in 0 until num_people){
        for (j in 0 until num_people) {
            if ((arr_big[i][0] < arr_big[j][0])&&(arr_big[i][1] < arr_big[j][1])) {
                arr_big[i][2] += 1
            }
        }
    }

    for (i in 0 until num_people) {
        println(arr_big[i][2])
    }
}

/*
2차원 배열로 키와 몸무게를 입력받는다. 또 각 배열마다 등수 데이터까지 더해서
각 배열에 키 몸무게 등수를 가진 2차원 배열을 만든다

키와 몸무게를 비교해서 둘 다 작을 때 등수를 높인다 긍까 데이터를 높이면 되
그러면 제일 작은놈은 낮게 큰 놈은 크게 나온다
 */