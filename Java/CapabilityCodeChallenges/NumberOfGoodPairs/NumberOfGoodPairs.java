/**
    # Number of Good Pairs

    Given an array of integers nums, return the number of good pairs.

    A pair (i, j) is called good if nums[i] == nums[j] and i < j.

    Example 1:
        Input: nums = [1,2,3,1,1,3]
        Output: 4
        Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

    Example 2:
        Input: nums = [1,1,1,1]
        Output: 6
        Explanation: Each pair in the array are good.

    Example 3:
        Input: nums = [1,2,3]
        Output: 0

    Constraints:

        * 1 <= nums.length <= 100
        * 1 <= nums[i] <= 100

 */
public class NumberOfGoodPairs {

    // nums[i] == nums[j] and i < j.
    public static int numIdenticalPairs(int[] nums) {
        int response = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            for (int j = i+1; j < numsLen; j++) {
                if (nums[i] == nums[j]) {
                    response++;
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {
        System.out.println("Starting FindFirstPalindrome");

        int resp = numIdenticalPairs(new int[]{1,2,3,1,1,3}); // Resp: 4
        System.out.println("Response: " + resp);

        resp = numIdenticalPairs(new int[]{1,1,1,1}); // Resp: 6
        System.out.println("Response: " + resp);

        resp = numIdenticalPairs(new int[]{1,2,3}); // Resp: 0
        System.out.println("Response: " + resp);

    }
}
