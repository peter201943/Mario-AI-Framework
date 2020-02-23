package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;

public class Wait extends Action {
	
	public Wait() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action) {
		action = new boolean[] {false, false, false, false, false};
		return new Win();
	}
}
