package cn.daxiong.domain;
/*
 * JavaBean必须要为成员提供getter、setter方法（两者中只提供一个也是可以的，比如只提供getter，没有setter也是可以的）
 * JavaBean必须要有一个默认构造器（无参的!）
 * 一般对于有getter、setter方法的成员变量，我们称之为属性
 * 
 * 其实就算一个属性没有对应的成员变量，只有getter、setter方法也是可以的
 */
public class Person {
	private String name;
	private int age;
	private String gender;
	
	public Person() {
		super();
	}

	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}
