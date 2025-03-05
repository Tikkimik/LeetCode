package Problems.easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}

// not in-place
//public int removeDuplicates(int[] nums) {
//    LinkedHashSet<Integer> u = new LinkedHashSet<>();
//    for (var n : nums) u.add(n);
//
//    return u.size();
//}
