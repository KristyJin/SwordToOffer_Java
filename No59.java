package JianzhiOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 队列的最大值：
 */
public class No59 {
	/*
	 * 题目一：滑动窗口的最大值。
	 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
	 * 例如，如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，
	 * 那么一共存在6个滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}
	 */
	public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> max = new ArrayList<Integer>();
        if(num==null || num.length<=0 || size<=0 || size>num.length)
            return max;
        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();
         
        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])
                indexDeque.removeLast();
            indexDeque.addLast(i);
        }
         
        for(int i=size-1;i<num.length;i++){
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])
                indexDeque.removeLast();
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=size)
                indexDeque.removeFirst();
            indexDeque.addLast(i);
            max.add(num[indexDeque.getFirst()]);
        }
         
        return max;
    }
	/*
	 * 题目二：队列的最大值。
	 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的时间复杂度都是O(1)。
	 */
	private ArrayDeque<InternalData>  data = new ArrayDeque<InternalData>();
    private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();
    private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index) {
            this.number=number;
            this.index=index;
        }
    }
    private int curIndex;
     
    public void push_back(int number) {
        InternalData curData = new InternalData(number,curIndex);
        data.addLast(curData);
         
        while(!maximum.isEmpty() && maximum.getLast().number<number)
            maximum.removeLast();
        maximum.addLast(curData);
         
        curIndex++;  //别漏了这句
    }
     
    public void pop_front() {
        if(data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if(curData.index==maximum.getFirst().index)
            maximum.removeFirst();
    }
     
    public int max() {
        if(maximum==null){
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;
    }
    
    public static void main(String[] args) {
        No59 testQueue = new No59();
        int[] nums = {2,3,4,2,6,2,5,1};
        System.out.println(testQueue.maxInWindows(nums, 3));
        System.out.println("-----------------------------------");
        // {2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==2);
        // {2, 3}
        testQueue.push_back(3);
        System.out.println(testQueue.max()==3);
        // {2, 3, 4}
        testQueue.push_back(4);
        System.out.println(testQueue.max()==4);
        // {2, 3, 4, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==4);
        // {3, 4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==2);
        // {2, 6}
        testQueue.push_back(6);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2, 5}
        testQueue.push_back(5);
        System.out.println(testQueue.max()==6);
        // {6, 2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==6);
        // {2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5, 1}
        testQueue.push_back(1);
        System.out.println(testQueue.max()==5);    
    }
}
