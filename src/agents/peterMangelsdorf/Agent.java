

package agents.peterMangelsdorf;


// Game References
import engine.core.MarioAgent;					// Get Self Info
import engine.core.MarioForwardModel;			// Get World Info
import engine.core.MarioTimer;					// ???


// Agent Utils
import agents.peterMangelsdorf.BasicTasks.*;	// Primitive Tasks
import agents.peterMangelsdorf.MarioTasks.*;	// Game Specific Tasks
import agents.peterMangelsdorf.Helpers.*;		// State Management


/**
 * 
 * @author 	Peter Mangelsdorf
 * @email  	pjm349@drexel.edu
 * @phone	717-385-7068
 * @date	2020 FEB 22
 *
 * NOTES
 * =====
 * This file is largely based off the random agent (hence the random section).
 * It should ignore that part.
 *
 */


public class Agent implements MarioAgent {
    
	
    private Container bt;

    
    @Override
    public void initialize(MarioForwardModel model, MarioTimer timer) {
        bt = makeBT();
        //bt = makeTest();
    }

    
    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
    	ActionState theAction = new ActionState();
    	bt.Execute(theAction, model);
    	//System.out.println("[0] Action: (" + timer.getRemainingTime() + ") " + theAction[0] + " " + theAction[1] + " " + theAction[2] + " " + theAction[3] + " " + theAction[4]);
        return theAction.value;
    }

    
    @Override
    public String getAgentName() {
        return "PeterAgent";
    }
    
    
    private Container makeBT() {
    	
    	// Declarations -- Correct Order
    	Container newBT = new Do();
	    	Choose baseChoose = new Choose();
		    	Container doOne = new Do();
		    		Condition enemiesClose = new EnemiesClose();
		    		Container secondChoose = new Choose();
		    			Container secondDo = new Do();
		    				Condition enemiesInRange = new EnemiesInRange();
		    				Action attackJump = new AttackJump();
		    			Action wait = new Wait();
		    	Container doTwo = new Do();
			    	Condition stopped = new Stopped();
			    	/*Action jump = new Jump();
			    	Action jump2 = new Jump();
			    	Action jump3 = new Jump();
			    	Action jump4 = new Jump();
			    	Action jump5 = new Jump();
			    	Action runRight = new RunRight();*/
			    	Action rightRunJump = new RightRunJump();
		    	Container doThree = new Do();
		          	Action runRight2 = new RunRight();

		    		// Insertions -- Reverse Order
		    		doOne.Add(enemiesClose);
		    				secondDo.Add(enemiesInRange);
		    				secondDo.Add(attackJump);
		    			secondChoose.Add(secondDo);
		    			secondChoose.Add(wait);
		    		doOne.Add(secondChoose);
		    	baseChoose.Add(doOne);
		    		doTwo.Add(stopped);
		    		/*doTwo.Add(jump);
		    		doTwo.Add(jump2);
		    		doTwo.Add(jump3);
		    		doTwo.Add(jump4);
		    		doTwo.Add(jump5);
		    		doTwo.Add(runRight);*/
		    		doTwo.Add(rightRunJump);
		    	baseChoose.Add(doTwo);
		    		doThree.Add(runRight2);
		    	baseChoose.Add(doThree);
    	newBT.Add(baseChoose);
 
    	// Finished!
    	return newBT;
    }
}

