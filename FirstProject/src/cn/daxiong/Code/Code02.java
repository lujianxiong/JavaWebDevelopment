package cn.daxiong.Code;
import java.util.Scanner;

public class Code02 {

	public static void main(String[] args) {
		//输入 -- 获取键盘输入内容
		Scanner scan = new Scanner(System.in);
		int x = 0;
		x = scan.nextInt();
		System.out.println("收到预计采购鸭子的数量:"+x);
		
		int tou = x*1*5;
		int tui = x*2*10;
		int chi = x*2*10;
		int suogu = x*1*5;
		int zhang = x*2*5;
		int rou =x*1*20;
		
		int sum =tou+tui+chi+suogu+zhang+rou;
		
		//输出
		System.out.println("输出预计销售额"+sum);
		scan.close();
	}
}
