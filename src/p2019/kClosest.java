package p2019;

import java.util.Arrays;
import java.util.Comparator;

//Problem: https://leetcode.com/problems/k-closest-points-to-origin/
public class kClosest {

    public static void main(String[] args) {
        int [][] points = new int [][] {{1,1},{-1,-1}, {-2,4}};
        int K = 2;
        int [] [] result = kClosest(points, K);
        System.out.println(Arrays.deepToString(result));
    }

    static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(kClosest::findDistance));
        int [] [] result = new int[K][2];
        System.arraycopy(points, 0, result, 0, K);
        return result;
    }

    static int findDistance(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
