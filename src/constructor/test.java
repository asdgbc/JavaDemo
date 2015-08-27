package constructor;

import java.util.List;

/**
 * 
 * 创建时间：2015年8月21日 下午1:47:46
 * 
 * 项目名称：JavaDemo
 * 
 * @author chenxx@hundsun.com
 * 
 * @version 1.0
 * 
 *          文件名称：test.java
 * 
 *          类说明：
 */

public class test {
	public static void main(String[] args) {
	}
	
	public static int findRepeat(int[] a){
		int data = 0;
		int firstLocation = 0;
		for (int i = 0; i < a.length; i++) {
			if (data==0&&a[i]!=0) {//第一次赋值
				data = a[i];
				firstLocation = i;
			}
		}
		return 0;
	}
	
}
