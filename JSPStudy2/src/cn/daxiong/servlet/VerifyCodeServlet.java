package cn.daxiong.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daxiong.image.VerifyCode;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、生成图片
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		//2、保存图片上的文本到session域中
		request.getSession().setAttribute("session_vcode", vc.getText());
		//3、把图片响应给客户端
		VerifyCode.output(image, response.getOutputStream());
	}

}
