package cn.daxiong.domain;

public class Employee {
	private String name;
	private double salary;
	private Address add;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	public String getHehe() {
		return "我去....";
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", add=" + add + "]";
	}
	
	
}
