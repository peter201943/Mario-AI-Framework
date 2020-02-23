package agents.peterMangelsdorf;

import java.util.ArrayList;
import java.util.Random;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.MarioTasks.*;
import agents.peterMangelsdorf.Helpers.*;


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
    
	
	
	
	
	
	
	
	// Variables
	
    private Random rnd;
    private ArrayList<boolean[]> choices;
    private Container bt;

    
    
    
    
    
    
    
    
    
    
    // Overrides
    
    @Override
    public void initialize(MarioForwardModel model, MarioTimer timer) {
        rnd = new Random();
        choices = makeChoices();
        //bt = makeBT();
        bt = makeTest();
    }

    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
    	ActionState theAction = new ActionState();
    	bt.Execute(theAction, model);
    	//System.out.println("[0] Action: (" + timer.getRemainingTime() + ") " + theAction[0] + " " + theAction[1] + " " + theAction[2] + " " + theAction[3] + " " + theAction[4]);
        return theAction.value;
    	//return choices.get(rnd.nextInt(choices.size()));
    }

    @Override
    public String getAgentName() {
        return "PeterAgent";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Makers
    
    private Container makeTest() {
    	Container newBT = new Do();
    		Action runRight = new RunRight();
    		newBT.Add(runRight);
    	return newBT;
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
			    	Action jump = new Jump();
			    	Action runRight = new RunRight();
		    	Container doThree = new Do();
		          	//Action runRight = new RunRight();

		    		// Insertions -- Reverse Order
		    		doOne.Add(enemiesClose);
		    				secondDo.Add(enemiesInRange);
		    				secondDo.Add(attackJump);
		    			secondChoose.Add(secondDo);
		    			secondChoose.Add(wait);
		    		doOne.Add(secondChoose);
		    	baseChoose.Add(doOne);
		    		doTwo.Add(stopped);
		    		doTwo.Add(jump);
		    		doTwo.Add(runRight);
		    	baseChoose.Add(doTwo);
		    		doThree.Add(runRight);
		    	baseChoose.Add(doThree);
    	newBT.Add(baseChoose);
 
    	// Finished!
    	return newBT;
    }

    private ArrayList<boolean[]> makeChoices() {
        // init
        choices = new ArrayList<>();

        //right run
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});
        choices.add(new boolean[]{false, true, false, true, false});

        //right jump and run
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});
        choices.add(new boolean[]{false, true, false, true, true});

        // right
        choices.add(new boolean[]{false, true, false, false, false});
        choices.add(new boolean[]{false, true, false, false, false});
        choices.add(new boolean[]{false, true, false, false, false});
        choices.add(new boolean[]{false, true, false, false, false});

        // right jump
        choices.add(new boolean[]{false, true, false, false, true});
        choices.add(new boolean[]{false, true, false, false, true});
        choices.add(new boolean[]{false, true, false, false, true});
        choices.add(new boolean[]{false, true, false, false, true});

        //left
        choices.add(new boolean[]{true, false, false, false, false});

        //left run
        choices.add(new boolean[]{true, false, false, true, false});

        //left jump
        choices.add(new boolean[]{true, false, false, false, true});

        //left jump and run
        choices.add(new boolean[]{true, false, false, true, true});

        // Return
        return choices;
    }
}
