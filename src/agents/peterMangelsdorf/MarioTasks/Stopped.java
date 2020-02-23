package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Stopped extends Condition{

	public Stopped() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		// Decide Speed
		boolean stopped = (model.getMarioFloatVelocity()[0] <= 0.1);
		
		// Decide Logic
		if (stopped) {
			System.out.println("STOPPED!!!"); // DEBUG !!! DELETEME !!!
			return new Win();
		}
		else {
			return new Fail();
		}
	}
}
