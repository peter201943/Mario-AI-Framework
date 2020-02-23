package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Pit extends Condition{

	private int offSet = 5;
	
	public Pit() {
		super();
		offSet += 1;	// offSet cannot be < 1 !!!!
	}
	
	
	// We need to look for OBS_BACKGROUND at the tile coordinates just ahead of mario to decide if he is going
	// to plummet to his death.
	// See `MarioForwardModel.java` for more details.
	// model.getScreenSceneObservation() 	-- A [][] of every tile -- basic 1=exists, 0 = none
	// model.obsGridWidth					-- How Tide
	// model.obsGridHeight					-- How Tall
	
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		
		// Decide Depth		
		if (model.getScreenSceneObservation()[model.obsGridWidth - offSet][model.obsGridHeight - 1] == 0) {
			System.out.println("ITS THE END OF THE WORLD"); // DEBUG !!! DELETEME !!!
			return new Win();
		}
		else {
			System.out.println("FLAT EARTH"); // DEBUG !!! DELETEME !!!
			return new Fail();
		}
	}
}