package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;

public class Condition extends Task{
	
	public Condition() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action) {
		return new Win();
	}

}
