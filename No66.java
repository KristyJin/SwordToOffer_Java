package JianzhiOffer;

import java.util.ArrayList;

/**
 * 构建乘积数组： 给定一个数组A[0, 1, …, n-1]， 请构建一个数组B[0, 1, …, n-1]，其中B中的元素B[i]
 * =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class No66 {
	public static ArrayList<Integer> multiply(int[] A) {
		if (A == null || A.length < 2)
			return null;

		int[] B = new int[A.length];
		B[0] = 1;
		for (int i = 1; i < A.length; i++)
			B[i] = B[i - 1] * A[i - 1];
		int temp = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			temp *= A[i + 1];
			B[i] *= temp;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < B.length; i++) {
			res.add(B[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -3, 2 };
		System.out.println(multiply(nums));
	}
}
