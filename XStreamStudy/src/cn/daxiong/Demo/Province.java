package cn.daxiong.Demo;

import java.util.ArrayList;
import java.util.List;

public class Province {
	private String name;    //省名
	private List<City> cities = new ArrayList<City>();    //city对象

	//往省份里添加city
	public void addCity(City city) {
		cities.add(city);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
