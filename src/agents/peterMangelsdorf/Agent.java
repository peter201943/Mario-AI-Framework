package agents.peterMangelsdorf;

import java.util.ArrayList;
import java.util.Random;

import engine.core.MarioAgent;
import engine.core.MarioForwardModel;
import engine.core.MarioTimer;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.MarioTasks.*;
import agents.peterMangelsdorf.Helpers.*;

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
        bt = makeBT();
    }

    @Override
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer) {
        //return bt.Execute(new boolean[]{false, false, false, false, false}, model);
    	return choices.get(rnd.nextInt(choices.size()));
    }

    @Override
    public String getAgentName() {
        return "PeterAgent";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Makers
    
    private Container makeBT() {
    	Container newBT = new Do();
    	Choose baseChoose = new Choose();
    	
    	// First Clause: Enemies
    	//baseChoose.Add(doOne);
    	
    	// Second Clause: Obstacles
    	
    	//baseChoose.Add(doTwo);
    	
    	// Third Clause: Time
    	//baseChoose.Add(doThree);
    	
    	newBT.Add(baseChoose);
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
