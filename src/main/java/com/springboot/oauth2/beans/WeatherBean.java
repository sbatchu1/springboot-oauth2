package com.springboot.oauth2.beans;

public class WeatherBean {
	private boolean rainy;
	private boolean sunny;
	private boolean windy;

	public boolean isRainy() {
		return rainy;
	}

	public void setRainy(boolean rainy) {
		this.rainy = rainy;
	}

	public boolean isSunny() {
		return sunny;
	}

	public void setSunny(boolean sunny) {
		this.sunny = sunny;
	}

	public boolean isWindy() {
		return windy;
	}

	public void setWindy(boolean windy) {
		this.windy = windy;
	}
}
