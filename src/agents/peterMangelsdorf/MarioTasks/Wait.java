package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Wait extends Action {
	
	public Wait() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		action = new boolean[] {false, false, false, false, false};
		return new Win();
	}
}
