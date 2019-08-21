package JianzhiOffer;

/**
 * 求1+2+…+n：
 * 求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class No64 {
	public static int getSum(int n) {
        int sum=n;
        boolean flag = (n>1) && ((sum+=getSum(n-1))>0);  
        //上面这句话相当于：
        //if(n>1)
        //   sum+=getSum(n-1);
         
        //也可以使用||来实现
        //boolean flag = (n==1) || ((sum+=getSum(n-1))>0);  
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(getSum(10));
	}
}
