package cn.daxiong.Demo;

public class City {
	private String name;  //市名
	private String description;
	
	public City() {
		super();
	}
	
	public City(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", description=" + description + "]";
	}
	
}
