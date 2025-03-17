package Problems.easy;

public class x {

    public static void main(String[] args) {
        x obj = new x();

        int[] nums = {3,2,1,0,4};

        System.out.println(obj.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int maxValue = 0;

        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i] + i);

            if (maxValue < i) {
                return false;
            }

            if (maxValue >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
