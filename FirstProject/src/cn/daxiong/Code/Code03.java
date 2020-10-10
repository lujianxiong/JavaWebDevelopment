package cn.daxiong.Code;
import java.util.Scanner;
//心理测验系统：
//重点：Java中接受输入参数
public class Code03 {
	public static void main(String[] args) {
		int score = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("心理测验系统:【5个题目测试你是不是一个传统的人】");
		System.out.println("--------------第一题-------------");

		// 输入题目及选项:
		System.out.println("【1】你还在为了学习伤脑筋吗?");
		System.out.println("1、是的");
		System.out.println("2、不是");
		System.out.println("3、看情况");

		// 获取用户输入的选择，程序记录下来分数
		int one = scan.nextInt();

		// 统计分数：
		if (one == 1) {
			score += 20; // 第一个选项+20分
		} else if (one == 2) {
			score += 5; // 第二个选项+5分
		} else if (one == 3) {
			score += 10; // 第三个选项+10分
		}

		System.out.println("--------------第二题-------------");
		// 题目及选项:
		System.out.println("【2】你目前身边的朋友多吗?");
		System.out.println("1、很多 ");
		System.out.println("2、没有");
		System.out.println("3、很少");

		// 获取用户输入的选择，程序记录下来分数
		int two = scan.nextInt();

		// 统计分数：
		if (two == 1) {
			score += 20; // 第一个选项+20分
		} else if (two == 2) {
			score += 5; // 第二个选项+5分
		} else if (two == 3) {
			score += 10; // 第三个选项+10分
		}

		System.out.println("--------------第三题-------------");
		// 题目及选项:
		System.out.println("【3】你对自己未来的生活有期待吗?");
		System.out.println("1、有的 ");
		System.out.println("2、并没有");
		System.out.println("3、不好说");

		// 获取用户输入的选择，程序记录下来分数
		int three = scan.nextInt();

		// 统计分数：
		if (three == 1) {
			score += 20; // 第一个选项+20分
		} else if (three == 2) {
			score += 5; // 第二个选项+5分
		} else if (three == 3) {
			score += 10; // 第三个选项+10分
		}

		System.out.println("--------------第四题-------------");
		// 题目及选项:
		System.out.println("【4】你经常要求自己改变自己吗?");
		System.out.println("1、是的 ");
		System.out.println("2、不是");
		System.out.println("3、不好说");

		// 获取用户输入的选择，程序记录下来分数
		int four = scan.nextInt();

		// 统计分数：
		if (four == 1) {
			score += 20; // 第一个选项+20分
		} else if (four == 2) {
			score += 5; // 第二个选项+5分
		} else if (four == 3) {
			score += 10; // 第三个选项+10分
		}

		System.out.println("--------------第五题-------------");
		// 题目及选项:
		System.out.println("【5】你对自己的要求多还是少呢?");
		System.out.println("1、多 ");
		System.out.println("2、少");
		System.out.println("3、不好说");

		// 获取用户输入的选择，程序记录下来分数
		int five = scan.nextInt();

		// 统计分数：
		if (five == 1) {
			score += 20; // 第一个选项+20分
		} else if (five == 2) {
			score += 5; // 第二个选项+5分
		} else if (five == 3) {
			score += 10; // 第三个选项+10分
		}

		if (score >= 85) {
			System.out.println(
					"你的内心传统程度是100%。 你内心的传统占据了你，你是一个很传统的人，你并不能够接受新鲜事物，对你来说，新鲜事物是很可怕的，所以你要得到好的发展是不容易的，你不愿意放下一些传统，你慢慢的会和身边的人有分歧。内心的传统会让你变得胆小，你容易就这样自我封闭起来。");
		} else if (score >= 65) {
			System.out.println(
					"你的内心传统程度是80%。你内心传统的东西还是保留得比较多的，面对生活的时候，你偶尔可以接受一些不同的东西，不过接受这些对你来说并不是那么容易的事情，需要给你一些时间。你并不是会完全排斥新生活的人，所以你要得到进步还是有可能的，就是需要花比较多的时间。");
		} else if (score >= 45) {
			System.out.println(
					"你的内心传统程度是20%。你内心的传统很少，你保留一些传统的东西，大多数时候你是愿意改变自己的，你觉得时代在进步，你也应该要跟着进步起来。面对生活的时候，你是可以很快的适应的，而且你内心的传统也会让你变得更加谨慎一些，你的生活状态往往是不错的。");
		} else if (score >= 25) {
			System.out.println(
					"你的内心传统程度是0，你内心已经没有任何和传统有关的东西了，在你看来传统是不好的，你的思想很激进，你会接受很多新鲜的事物，你总是走在最前面。不过你也要注意，传统并不完全是不好的，而新鲜的事物也不完全是好的，你要仔细的分辨");

			// 4.根据不同分数，输出不同的结果
			System.out.println("最终的分数：" + score);
			scan.close();
		}
	}
}
