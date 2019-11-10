package p2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        int [] nums = new int [] {2,7,11,15,3};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    static int[] twoSum(int[] nums, int target) { //HashMap optimal solution. O(n) time complexity
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference) && map.get(difference)!=i) {
                result[0] = map.get(difference);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("Wrong input data");
    }

    /*
    static int[] twoSum(int[] nums, int target) { //HashMap solution, not optimal. O(n) time complexity
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference) && map.get(difference) != i) {
                result[0] = i;
                result[1] = map.get(difference);
                return result;
            }
        }
        throw new IllegalArgumentException("Wrong input data");
    }
    */

    /*
    static int[] twoSum(int[] nums, int target) { //Brute force. O(n^2) time complexity
        int [] result = new int [2];
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j]==target) {
                    result[0] = i; //originally we just need index, but task output format requires + 1;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("Wrong input data");
    }
    */

}
