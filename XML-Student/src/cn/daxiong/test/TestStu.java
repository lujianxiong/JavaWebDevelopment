package cn.daxiong.test;

import cn.daxiong.service.StuService;
import cn.daxiong.vo.Student;

public class TestStu {

	public static void main(String[] args) throws Exception {
		//testADD();
		//testDel();
		testSelect();
	}
	
	//测试查询
	public static void testSelect() throws Exception{
		Student student = StuService.selectStuByid("001");
		System.out.println(student);
	}

	//测试删除
		public static void testDel() throws Exception{
			StuService.delStu("111");
		}
		
	//测试添加
	public static void testADD() throws Exception{
		Student student = new Student();
		student.setId("111");
		student.setName("gongju");
		student.setAge("30");
		StuService.addStu(student);
	}
	
	
}
