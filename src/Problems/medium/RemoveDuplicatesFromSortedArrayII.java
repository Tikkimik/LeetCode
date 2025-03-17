package Problems.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();

        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
//            if (i >= 2 && nums[i - 1] == nums[i] && nums[i - 2] != nums[i]) {
//                nums[k++] = nums[i];
//            } else {

            if (nums[i - 1] != nums[i]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
