package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

//Actions
//{left, right, ???, run, jump}

public class RightRunJump extends Action {
	
	public RightRunJump() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		action.value = new boolean[] {false, true, false, true, true};
		return new Win();
	}
}
