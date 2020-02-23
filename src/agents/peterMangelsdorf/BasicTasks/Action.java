package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Action extends Task{
	
	public Action() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		return new Win();
	}

}
