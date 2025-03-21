package Problems.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();

        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3}; //Expected [1,1,2,2,3]

        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int iterator = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] && count < 2) {
                nums[iterator++] = nums[i];
                count++;
            }

            if (nums[i] != nums[i - 1]) {
                nums[iterator++] = nums[i];
                count = 1;
            }
        }

        return iterator;
    }

}
