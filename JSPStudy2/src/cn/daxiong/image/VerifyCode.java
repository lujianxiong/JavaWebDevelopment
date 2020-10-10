package cn.daxiong.image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode {
		private int w = 70;
		private int h = 35;
	 
		private Random r = new Random();
		// 定义有那些字体
		private String[] fontNames = { "宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312" };
		// 定义有那些验证码的随机字符
		private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
		// 生成背景色
		private Color bgColor = new Color(250, 250, 250);
		// 用于gettext 方法 获得生成的验证码文本
		private String text;
	 
		// 生成随机颜色
		private Color randomColor() {
			int red = r.nextInt(150);
			int green = r.nextInt(150);
			int blue = r.nextInt(150);
			return new Color(red, green, blue);
		}
	 
		// 生成随机字体
		private Font randomFont() {
			int index = r.nextInt(fontNames.length);
			String fontName = fontNames[index];    //生成随机字体名称
			int style = r.nextInt(4);     //生成随机的样式  0(无样式) ， 1(粗体) ， 2(斜体) ， 3(粗体+斜体)
			int size = r.nextInt(5) + 24;    //生成随机字号：24-28
			return new Font(fontName, style, size);
		}
	 
		// 画干扰线
		private void drawLine(BufferedImage image) {
			int num = 3;    //一共画3条
			Graphics2D g2 = (Graphics2D) image.getGraphics();
			for (int i = 0; i < num; i++) {  
				//一条线，两个点，四个值
				int x1 = r.nextInt(w);
				int y1 = r.nextInt(h);
				int x2 = r.nextInt(w);
				int y2 = r.nextInt(h);
				g2.setStroke(new BasicStroke(1.5F));// 不知道
				g2.setColor(Color.blue);    //干扰线是蓝色
				g2.drawLine(x1, y1, x2, y2);
			}
		}
	 
		// 得到codes的长度内的随机数 并使用charAt 取得随机数位置上的codes中的字符
		private char randomChar() {
			int index = r.nextInt(codes.length());
			return codes.charAt(index);
		}
		
		//创建BufferedImage
		private BufferedImage createImage() {
			BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = (Graphics2D) image.getGraphics();
			g2.setColor(bgColor);
			g2.fillRect(0, 0, w, h);
			return image;
		}
	 
		// 创建一张验证码的图片
		public BufferedImage getImage() {
			BufferedImage image = createImage();  //调用createImage创建图片缓冲区
			Graphics2D g2 = (Graphics2D) image.getGraphics();    //得到绘制环境
			StringBuilder sb = new StringBuilder();    //用来装载生成验证码的文本
			// 向图中画四个字符
			for (int i = 0; i < 4; i++) {    //循环四次，每次生成一个字符
				String s = randomChar() + "";  //随机生成一个字母
				sb.append(s);    //把字母加到sb中
				float x = i * 1.0F * w / 4;    //设置当前字符的x轴坐标
				g2.setFont(randomFont());    //设置随机字体
				g2.setColor(randomColor());    //设置随机颜色
				g2.drawString(s, x, h - 5);    //画图片
	 
			}
			this.text = sb.toString();    //把生成的字符串赋给this.text
			drawLine(image);    //添加干扰线
			// 返回图片
			return image;
		}
	 
		// 得到验证码的文本 后面是用来和用户输入的验证码 检测用
		public String getText() {
			return text;
		}
	 
		// 保存图片到指定的输出流
		public static void output(BufferedImage bi, OutputStream fos)
				throws FileNotFoundException, IOException {
			ImageIO.write(bi, "JPEG", fos);
		}

}
