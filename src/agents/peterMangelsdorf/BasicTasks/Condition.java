package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Condition extends Task{
	
	public Condition() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		return new Win();
	}

}
