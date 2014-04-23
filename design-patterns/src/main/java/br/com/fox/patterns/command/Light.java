package br.com.fox.patterns.command;

public class Light {

	private String identification;
	
	public Light(String identification) {
		
		this.identification = identification;
	}
	
	public void on() {
		
		System.out.println(identification + " light is ON.");
	}
	
	public void off() {
		
		System.out.println(identification + " light is OFF.");
	}
	
}
