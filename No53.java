package JianzhiOffer;

/**
 * 在排序数组中查找数字：
 */
public class No53 {
	/*
	 * 题目一：数字在排序数组中出现的次数。 
	 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，输出4.
	 */
	public static int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length<=0)
            return 0;
         int firstK = getFirstK(array,0,array.length-1,k);
         if(firstK == -1)
             return 0;
         int lastK = getLastK(array,firstK,array.length-1,k);
         return lastK-firstK+1;
     }
       
     private static int getFirstK(int[] arr, int start, int end,int k){
         if(start>end)
             return -1;
         int mid = (start+end)>>1;
         if(arr[mid]==k){
             if( mid == 0 ||arr[mid-1]!=k )
                 return mid;
             else
                 end = mid-1;
         }else if(arr[mid]<k){
             start = mid+1;
         }else{
             end = mid-1;
         }
         return getFirstK(arr,start,end,k);
     }
       
     private static int getLastK(int[] arr, int start, int end,int k){
         if(start>end)
             return -1;
         int mid = (start+end)>>1;
         if(arr[mid]==k){
             if(mid==arr.length-1 || arr[mid+1]!=k )
                 return mid;
             else
                 start = mid+1;
         }else if(arr[mid]<k){
             start = mid+1;
         }else{
             end = mid-1;
         }
         return getLastK(arr,start,end,k);
     }
     /*
 	 * 题目二：0-n-1中缺失的数字
 	 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 	 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 	 */
     public static int getMissingNumber(int[] arr) {
         if(arr==null || arr.length<=0)
             return -1;
         int low=0;
         int high=arr.length-1;
         while(low<=high) {
             int mid=(low+high)>>1;
             if(arr[mid]!=mid) {
                 if(mid==0 || arr[mid-1]==mid-1)
                     return mid;
                 high=mid-1;
             }else {
                 low=mid+1;
             }
         }
         return -1;
     }
     /*
 	 * 题目三：数组中数值和下标相等的元素。
 	 *假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 	 *请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 	 *例如，在数组{-3, -1,1, 3, 5}中，数字3和它的下标相等。
 	 */
     public static int getNumberSameAsIndex(int[] arr) {
         if(arr==null || arr.length<=0)
             return -1;  //代表错误
         int low=0;
         int high=arr.length-1;
         while(low<=high) {
             int mid= (high+low)>>1;
             if(arr[mid]>mid)
                 high=mid-1;
             else if(arr[mid]<mid)
                 low=mid+1;
             else
                 return mid;
         }
         return -1;
     }
     public static void main(String[] args) {
		int[] nums = {1,2,3,3,3,3,4,5};
		System.out.println(GetNumberOfK(nums,3));
		System.out.println(getMissingNumber(nums));
		int[] array = {-3, -1,1, 3, 5};
		System.out.println(getNumberSameAsIndex(array));
	}
}
