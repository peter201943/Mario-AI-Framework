package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;

//Actions
//{left, right, ???, run, jump}

public class Jump extends Action {
	
	public Jump() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action) {
		action = new boolean[] {false, false, false, false, true};
		return new Win();
	}
}