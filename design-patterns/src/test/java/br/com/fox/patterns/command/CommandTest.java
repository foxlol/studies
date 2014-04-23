package br.com.fox.patterns.command;

import org.junit.Test;

import br.com.fox.patterns.command.HomeControl.HomeZone;

public class CommandTest {

	@Test
	public void testCommand() {
		
		Light roomLight = new Light(HomeZone.ROOM.toString());
		
		LightOnCommand roomLightOn = new LightOnCommand(roomLight);
		LightOffCommand roomLightOff = new LightOffCommand(roomLight);
		
		Light garageLight = new Light(HomeZone.GARAGE.toString());
		
		LightOnCommand garageLightOn = new LightOnCommand(garageLight);
		LightOffCommand garageLightOff = new LightOffCommand(garageLight);

		HomeControl homeControl = new HomeControl();
		
		homeControl.addCommandToZone(HomeZone.ROOM, 1, roomLightOn);
		homeControl.addCommandToZone(HomeZone.ROOM, 2, roomLightOff);
		
		homeControl.addCommandToZone(HomeZone.GARAGE, 1, garageLightOn);
		homeControl.addCommandToZone(HomeZone.GARAGE, 2, garageLightOff);
		
		homeControl.executeCommand(HomeZone.ROOM, 1);
		homeControl.executeCommand(HomeZone.ROOM, 2);
		
		homeControl.executeCommand(HomeZone.GARAGE, 1);
		homeControl.executeCommand(HomeZone.GARAGE, 2);
	}
	
}
