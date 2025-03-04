package praktikum;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();

        int[] nums = {3,2,2,3,3,2,2,3,2,2,3,2,2,3,2,2,3,2,2,3,2,2,3,2,2};
        int val = 3;

        System.out.println(obj.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
