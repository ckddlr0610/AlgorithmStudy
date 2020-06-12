package test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 유니크한 값을 찾는 것
 * 콜렉션 주어지면
 * 한번이라도 빈도 넘어서면 반환하지 않는
 */

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        HashMap mResult = new HashMap<>();
        ArrayList<Integer> mNum = new ArrayList<>();
        mNum.addAll(numbers);

        for (int i=0; i<numbers.size(); i++) {
            if (!mResult.containsKey(mNum.get(i))) {
                mResult.put(mNum.get(i), 1);
            } else {
                mResult.replace(mNum.get(i), mResult.get(mNum.get(i)));
            }
        }
        return mNum;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}