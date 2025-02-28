package Problems.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {return null;}


    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums = {4, 2, 3, 5, 2, 536, 3};
        int target = 6;

        var a = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(a));
    }

//    Runtime 6ms Beats 52.36%
//    Memory 46.46MB Beats 9.66%
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for (int b = 0; b < nums.length; b++) {
//            map.computeIfAbsent(nums[b], k -> new ArrayList<>()).add(b);
//        }
//
//        var keys = map.keySet();
//
//        if (target % 2 == 0) {
//            if (keys.contains(target / 2)) {
//                var t2 = target / 2;
//                if (map.get(t2).size() > 1) {
//                    return new int[]{
//                            map.get(t2).get(0),
//                            map.get(t2).get(1)
//                    };
//                }
//            }
//        }
//
//        for (int num : nums) {
//            var ans = target - num;
//
//            if (keys.contains(ans)) {
//                if (map.get(ans).size() > 1) {
//                    return new int[]{
//                            map.get(ans).get(0),
//                            map.get(ans).get(1)
//                    };
//                } else if (num != ans) {
//                    return new int[]{
//                            map.get(ans).get(0),
//                            map.get(num).get(0)
//                    };
//
//                }
//            }
//        }
//        return null;
//    }

// Runtime - 12ms - Beats50.76%
// Memory - 44.90MB - Beats76.54%

//    import static java.util.Arrays.sort;
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//
//            for (int b = 0; b < nums.length; b++) map.put(b, nums[b]);
//
//            sort(nums);
//
//            for (int i = 0; i < nums.length; i++) {
//                var ans = target - nums[i];
//                var j = Arrays.binarySearch(nums, ans);
//
//                if (j < 0) continue;
//
//                if (i != j) {
//                    int finalI = i;
//                    var resI = map.entrySet()
//                            .stream()
//                            .filter(entry -> Objects.equals(entry.getValue(), nums[finalI]))
//                            .map(Map.Entry::getKey).findAny().get();
//
//                    var resJ = map.entrySet()
//                            .stream()
//                            .filter(entry -> Objects.equals(entry.getValue(), nums[j]))
//                            .map(Map.Entry::getKey).filter(k -> !k.equals(resI)).findAny().get();
//
//                    return new int[]{
//                            resI,
//                            resJ
//                    };
//                }
//            }
//
//            return null;
//        }
//    }
}
