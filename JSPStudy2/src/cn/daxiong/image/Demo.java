package cn.daxiong.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

//动态生成图片
public class Demo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//1、创建图片缓冲区，设置宽高
		BufferedImage bi = new BufferedImage(70, 35, BufferedImage.TYPE_INT_RGB);
		//2、得到这个图片的绘制环境（得到画笔）
		Graphics2D g = (Graphics2D)bi.getGraphics();
		//把环境设置为白色
		g.setColor(Color.WHITE);
		//填充矩形，从(0,0)开始，宽70，高35，即设置整个图片的背景色
		g.fillRect(0, 0, 70, 35);
		//把环境设置为红色
		g.setColor(Color.RED);
		g.drawString("Hello", 2, 35-2);  //向图片上写入字符串，其中2,2表示x,y轴坐标
		//3、保存起来
		ImageIO.write(bi, "JPEG", new FileOutputStream("E:/xxx.jpg"));
	}

}
