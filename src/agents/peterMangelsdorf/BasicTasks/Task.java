
package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;

// Actions
// {left, right, ???, run, jump}

public class Task{

    public Task() {
    }
    
    public Status Execute(boolean[] action) {
    	action =  new boolean[]{false, false, false, false, false};
    	return new Win(); 
    }
}