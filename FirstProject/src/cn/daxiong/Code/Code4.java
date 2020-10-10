package cn.daxiong.Code;
import java.io.File;

public class Code4 {
	public static void main(String[] args) {
		//1.查询文件夹里的文件或文件夹的总数量
		//打开一个文件目录：
		File file = new File("E:\\网易云课堂");
		//这里特别需要注意的是：“双斜杠”，在电脑资源管理器中，文件目录是这样的：“E:\网易云课堂”
		File[] files = file.listFiles();
		int num = files.length;
		System.out.println("当前文件夹下面有文件数量为："+num);
		
		//2.for循环改文件名：
		for(int mark=0;mark<num;mark++) {
			File f = files[mark];
			System.out.println(f.getName());
			f.renameTo(new File("E:\\网易云课堂\\"+"阴阳师_"+f.getName()));
		}
		
	}
}
