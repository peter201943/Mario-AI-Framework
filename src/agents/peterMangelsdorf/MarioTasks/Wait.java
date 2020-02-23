package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Wait extends Action {
	
	public Wait() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		action = new ActionState();
		System.out.println("WAIT FOR IT"); // DEBUG !!! DELETEME !!!
		return new Win();
	}
}
