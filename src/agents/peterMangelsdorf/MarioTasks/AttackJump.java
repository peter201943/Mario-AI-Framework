package agents.peterMangelsdorf.MarioTasks;

import java.util.ArrayList;

import agents.peterMangelsdorf.BasicTasks.Action;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

//Actions
//{left, right, ???, run, jump}

public class AttackJump extends Action {
	
	private int counter; 
	private ArrayList<boolean[]> sequence;
	
	public AttackJump() {
		super();
		counter = 0;
		sequence = makeSequence();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		action = sequence.get(counter);
		counter += 1;
		if (counter > sequence.size())
		{
			counter = 0;
		}
		return new Win();
	}
	
	private ArrayList<boolean[]> makeSequence() {
		sequence = new ArrayList<>();
		sequence.add(new boolean[] {false, true, false, false, false});
		sequence.add(new boolean[] {false, true, false, false, false});
		sequence.add(new boolean[] {false, true, false, false, false});
		sequence.add(new boolean[] {false, true, false, false, true});
		sequence.add(new boolean[] {false, true, false, false, true});
		sequence.add(new boolean[] {false, true, false, false, true});
		sequence.add(new boolean[] {false, true, false, false, true});
		sequence.add(new boolean[] {false, true, false, false, true});
		return sequence;
	}
}
