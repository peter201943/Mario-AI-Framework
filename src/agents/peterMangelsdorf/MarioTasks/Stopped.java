package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Stopped extends Condition{

	public Stopped() {
		super();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		// Decide Speed
		boolean stopped = false;
		
		// Decide Logice
		if (stopped) {
			return new Win();
		}
		else {
			return new Fail();
		}
	}
}
