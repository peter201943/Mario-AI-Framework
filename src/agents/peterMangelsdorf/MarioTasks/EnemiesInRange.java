package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class EnemiesInRange extends Condition {
	
	// Variables
	float[] myPos;
	float[] enemies;
	float enemy_x = 0;
	float enemy_y = 0;
	float targetRange = 50;
	
	public EnemiesInRange() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		
		// Update
		this.myPos = model.getMarioFloatPos();
		this.enemies = model.getEnemiesFloatPos();
		
		// Who Programs this way? Seriously? WTF?
		// [i + 0] = sprite#
		// [i + 1] = x#
		// [i + 2] = y#
		
		// Get the Enemies
		int i = 0;
		// Per each enemy
		for (float row : enemies) {
			if (i == 1) {
				this.enemy_x = row;
			}
			else if (i == 2) {
				this.enemy_y = row;
				
				// Process each enemy
				if (distance() < targetRange) {
					System.out.println("NOW"); // DEBUG !!! DELETEME !!!
					return new Win();
				}
			}
			
			// Which is 3 rows
			i++;
			if (i > 2) {
				i = 0;
			}
		}
		
		// Base Cases: No one is nearby/No one exists
		System.out.println("NOT YET"); // DEBUG !!! DELETEME !!!
		return new Fail();
	}
	
	private float distance() {
		float result = 0;
		result += (enemy_x - myPos[0]) * (enemy_x - myPos[0]);
		result += (enemy_y - myPos[1]) * (enemy_y - myPos[1]);
		result = (float) Math.sqrt(result);
		return result;
	}

}


















































