package JianzhiOffer;

import java.util.*;

/**
 * 数据流中的中位数： 如何得到一个数据流中的中位数？ 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序后中间两个数的平均值。
 */

public class No41 {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();// 小顶堆，默认容量为11
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
		// 大顶堆，默认容量为11
		public int compare(Integer i1, Integer i2) {
			return i2 - i1;
		};
	});

	public void Insert(Integer num) {
		// 偶数时，下个数字加入小顶堆
		if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
			if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
		} else {// 奇数时，下个数字加入大顶堆
			if (!minHeap.isEmpty() && minHeap.peek() < num) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
		}
	}

	public Double GetMedian() {
		if ((minHeap.size() + maxHeap.size()) == 0)
			throw new RuntimeException();
		double median;
		if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
			median = (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			median = minHeap.peek();
		}
		return median;
	}
}
