/**
 * 인텔리제이 내에선 잘 실행되고 출력되는데
 * 백준에서 런타임 에러가 뜬다.
 * 원인을 모르겠음
 */

package line

import java.util.*

fun main() {

    var scanner = Scanner(System.`in`)

    //println("학생의 수를 입력하시오.")
    var studentNumber = scanner.nextInt()
    var line_student = IntArray(5) { i -> i + 1 }

    //println("학생들이 뽑는 번호를 입력하시오.")
    var voteNumber = IntArray(studentNumber)

    for (i in 0 until studentNumber) {
        voteNumber[i] = scanner.nextInt()
    }

    for (i in voteNumber.indices) {
        if (voteNumber[i] == 0) {
            continue
        } else {
            var temp = line_student[i]
            for (j in i downTo i - voteNumber[i] + 1) {
                line_student[j] = line_student[j - 1]
            }
            line_student[i - voteNumber[i]] = temp
        }
    }

    for (i in 0 until studentNumber) {
        print("${line_student[i]} ")
    }

    /*
    for (i in 0 until studentNumber) {
        println("${i+1}번째 학생은 ${line_student[i]}번 학생입니다")
    }
     */

}