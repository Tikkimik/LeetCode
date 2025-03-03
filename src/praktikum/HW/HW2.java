package praktikum.HW;

import java.util.Arrays;
import java.util.*;

/**
 * Объединение массивов с удалением дубликатов
 */
public class HW2 {

    public static void main(String[] args) {
        HW2 obj = new HW2();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        var result = obj.mergeUnique(nums1, m, nums2, n);

        System.out.println(result);
    }

    public int mergeUnique(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length != m + n) return 0;
        if (nums2.length != n) return 0;

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

        LinkedHashSet<Integer> s = new LinkedHashSet<>();
        for (int j : nums1) s.add(j);

        return s.size();
    }
}
