package com.designpattern.test.state;
/**
 * 状态模式（state）
 * 当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类
 * 
 * 
 * 状态模式主要解决的是当控制一个对象状态转移的条件表达式过于复杂时的情况。把状态转移到表示不同状态的一系列类当中，可以将复杂的判断逻辑简化
 * @author Administrator
 *
 */
public class State {
	public static void main(String[] args) {
		Weather weather1 = new WeatherImpl1();
		Weather weather2 = new WeatherImpl2();
		
		Context context = new Context();
		context.setWeather(weather1);
		System.out.println(context.getWeatherMsg());
		
		context.setWeather(weather2);
		System.out.println(context.getWeatherMsg());
	}
}

/**
 * Context
 * @author Administrator
 *
 */
class Context{
	private Weather weather;
	
	public Weather getWeather() {
		return weather;
	}
	
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	
	String getWeatherMsg(){
		return weather.getWeather();
	}
	
}

/**
 * State
 * @author Administrator
 *
 */
interface Weather{
	String getWeather();
}

/**
 * ConcreteState
 * @author Administrator
 *
 */
class WeatherImpl1 implements Weather{
	@Override
	public String getWeather() {
		return "Rain";
	}
}

/**
 * ConcreteState
 * @author Administrator
 *
 */
class WeatherImpl2 implements Weather{
	@Override
	public String getWeather() {
		return "Sunshine";
	}
}


