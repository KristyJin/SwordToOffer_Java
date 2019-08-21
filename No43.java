package JianzhiOffer;

/**
 * 1-n整数中1出现的次数： 输入一个整数n，求1-n这n个整数的十进制表示中1出现的个数。
 * 例如，输入12，1-12这些整数中包含1的数字有1、10、11和12，1一共出现5次
 */

public class No43 {
	// 不考虑时间效率的解法
	private static int method1(int n) {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			num += Number1(i);
		}
		return num;
	}

	private static int Number1(int n) {
		int num = 0;
		while (n != 0) {
			if (n % 10 == 1)
				num++;
			n = n / 10;
		}
		return num;
	}

	// 提高时间效率的解法
	private static int method2(int n) {
		int count = 0;
		for (int i = 1; i <= n; i*=10) {//i代表位数
			int high = n/(i*10);//更高位数字
			int low = n%i;//更低位数字
			int cur = (n/i)%10;//当前位数字
			if(cur == 0) {
				count += high*i;
			}else if(cur == 1) {
				count += high*i+low+1;
			}else {
				count += (high+1)*i;
			}
		}
		return count;
	}

	

	public static void main(String[] args) {
		//功能测试：5、10、55、99
		//边界值测试：0、1
		//性能测试：10000、21235
		System.out.println(method1(99));
		System.out.println(method2(21235));
	}
}
