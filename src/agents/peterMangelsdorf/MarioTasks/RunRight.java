package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

//Actions
//{left, right, ???, run, jump}

public class RunRight extends Action {
	
	public RunRight() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		action = new boolean[] {false, true, false, true, false};
		return new Win();
	}
}
