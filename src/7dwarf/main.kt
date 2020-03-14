package `7dwarf`

import java.util.*
import kotlin.collections.ArrayList

/**
 * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 *
 * 예제를 입력하면 그대로 출력이 되는데 백준에서 테스트 돌리면 틀린걸로 나옴
 * 왜 에러가 나오는지 못찾았음
 */
fun main(){
    var scanner = Scanner(System.`in`)
    var nineDwarf = ArrayList<Int>(9)
    var sum = 0
    var check = false

    for (i in 0 until 9) {
        var input : Int
        println("${i+1}번째 숫자를 입력하시오.")
        input = scanner.nextInt()
        nineDwarf.add(input)
        sum += nineDwarf[i]
    }

    for (i in 0 until 9){
        if (check) break
        for (j in i+1 until 9){
            if ((sum-nineDwarf[i]-nineDwarf[j]) == 100) {
                nineDwarf.removeAt(i)
                nineDwarf.removeAt(j-1)

                check = true
                break
            }
        }
    }

    nineDwarf.sort()

    for (i in nineDwarf)
        println(i)
}

/*
아홉개의 배열을 입력받는 데이터
아홉개의 수를 다 더한 sum데이터

아홉개 중 두개만 선택하는 테스트
선택된 두개를 sum에서 빼서 100이 되면 테스트 성공
성공되면 나머지 7개 수를 정렬해서 출력한다
 */