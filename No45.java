package JianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数 输入一个正整数数组，把数组里所有数字拼接起来组成一个数， 打印能拼接出的所有数字中最小的一个。
 * 例如，输入数组{3，32，321}，则打印出这3个数字能排成的最小数字321323.
 *
 */
public class No45 {
	public static void main(String[] args) {
		// 最直接的解法：求出数组的全排列，然后去求组成的数字最小的那个
		// 其他解法:
		int[] nums = { 3, 32, 321 };
		printMinNum(nums);
	}

	public static void printMinNum(int[] nums) {
		if(nums==null || nums.length <=0)
			System.out.println("No");
		ArrayList<String> list = new ArrayList<String>();
		for(int i:nums) {
			list.add(String.valueOf(i));
		}
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String a = o1 + o2;
				String b = o2 + o1;
				return a.compareTo(b);
			}			
		});
		StringBuilder sb = new StringBuilder();
		for(String str : list)
			sb.append(str);
		System.out.println(sb.toString());
	}
}
