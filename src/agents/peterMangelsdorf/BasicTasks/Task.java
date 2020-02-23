
package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

// Actions
// {left, right, ???, run, jump}

public class Task{

    public Task() {
    }
    
    public Status Execute(ActionState action, MarioForwardModel model) {
    	action =  new ActionState();
    	return new Win(); 
    }
}