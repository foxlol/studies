package br.com.fox.patterns.command;

public class NoCommand implements Command {

	@Override
	public void execute() {
		
		System.out.println("Command not available.");
	}

}
