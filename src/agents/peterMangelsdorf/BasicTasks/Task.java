
package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

// Actions
// {left, right, ???, run, jump}

public class Task{

    public Task() {
    }
    
    public Status Execute(boolean[] action, MarioForwardModel model) {
    	action =  new boolean[]{false, false, false, false, false};
    	return new Win(); 
    }
}