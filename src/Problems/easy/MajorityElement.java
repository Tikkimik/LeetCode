package Problems.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();

        int[] nums = {3, 2, 3};

        System.out.println(obj.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int majorityElement = 0;
//        int maxCount = 0;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > maxCount) {
//                majorityElement = entry.getKey();
//                maxCount = entry.getValue();
//            }
//        }
//
//        return majorityElement;
    }
}
