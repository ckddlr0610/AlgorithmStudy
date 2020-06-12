package test;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * findmaxsum 구현하는 것
 * 리스트에서 두 개의 가장 큰 수 더한 것 출력
 * 근데 largelist에서 시간초과 어떻게 효율적으로??
 */

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size()-1) + list.get(list.size()-2);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list));
    }
}