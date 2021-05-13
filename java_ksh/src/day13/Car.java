package day13;

public class Car {
	// 전원, 기어, 차종, 제조사
	// 전원 on/off
	private boolean power;
	// 기어 수동: 1, 2, 3, 4, 5, R 자동: P, D, N, R
	private char gear;
	private String type, company;
	
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public char getGear() {
		return gear;
	}
	public void setGear(char gear) {
		this.gear = gear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
