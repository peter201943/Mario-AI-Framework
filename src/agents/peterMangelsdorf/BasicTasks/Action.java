package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;

public class Action extends Task{
	
	public Action() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action) {
		return new Win();
	}

}
