package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

//Actions
//{left, right, ???, run, jump}

public class Jump extends Action {
	
	public Jump() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		action.value = new boolean[] {false, false, false, false, true};
		return new Win();
	}
}