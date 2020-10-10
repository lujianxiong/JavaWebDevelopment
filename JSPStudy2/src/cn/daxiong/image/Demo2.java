package cn.daxiong.image;
//测试VerifyCode类
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		VerifyCode.output(bi, new FileOutputStream("E:/123.jpg"));
		System.out.println(vc.getText());
	}
}
