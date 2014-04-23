package br.com.fox.patterns.command;

import java.util.HashMap;
import java.util.Map;

public class HomeControl {

	private Map<HomeZone, Map<Integer, Command>> commandsPerZone;
	
	public HomeControl() {
		
		this.commandsPerZone = new HashMap<>();
		
		for (HomeZone zone : HomeZone.values()) {
			
			Map<Integer, Command> commands = new HashMap<>();
			
			commandsPerZone.put(zone, commands);
		}
	}
	
	public void addCommandToZone(HomeZone zone, Integer commandId, Command command) {
		
		this.commandsPerZone.get(zone).put(commandId, command);
	}
	
	public void executeCommand(HomeZone zone, Integer commandId) {
		
		Command command = this.commandsPerZone.get(zone).get(commandId);
		
		if (command == null) {
			
			command = new NoCommand();
		}
		
		command.execute();
	}
	
	public enum HomeZone {
		
		ROOM("Room"),
		GARAGE("Garage");
		
		private String description;
		
		private HomeZone(String description) {
			
			this.description = description;
		}
		
		@Override
		public String toString() {

			return this.description;
		}
	}
	
}
