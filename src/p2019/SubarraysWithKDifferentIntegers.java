package p2019;

import java.util.HashSet;
import java.util.Set;

//Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(arr, k));
    }


    static int subarraysWithKDistinct(int[] A, int K) {// my understandable solution. O(n^2) time complexity;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++) {
            int distCount = 0;
            set.clear();
            for(int j = i; j < A.length; j++) {
                if (!set.contains(A[j])) {
                    set.add(A[j]);
                    distCount++;
                }
                if (distCount==K) {
                    res++;
                }
            }
        }
        return res;
    }

    /*
    static int subarraysWithKDistinct(int[] A, int K) { not understandable solution. O(N) time complexity
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    static int atMostK(int[] A, int K) {
        int result = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> windwoMap = new HashMap<>();
        while (right < A.length) {
            windwoMap.put(A[right], windwoMap.getOrDefault(A[right], 0) + 1);
            right++;
            while (windwoMap.size() > K) {
                windwoMap.put(A[left], windwoMap.get(A[left]) - 1);
                windwoMap.remove(A[left], 0);
                left++;
            }
            result += right - left;
        }
        return result;
    }
     */

}
