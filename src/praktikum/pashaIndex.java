package praktikum;

import java.util.Arrays;

public class pashaIndex {

    public static void main(String[] args) {
        pashaIndex obj = new pashaIndex();

        int[] nums = {1, 2, 3, 4};

        System.out.println(obj.indexing(nums));
    }

//    public int[] indexing(int[] nums) {
//
//        int[] resault = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (j == i) continue;
//
//                resault[i] += nums[j];
//            }
//        }
//
//        return resault;
//    }

    public int[] indexing(int[] nums) {
        int a = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) nums[i] = a - nums[i];

        return nums;
    }
}
