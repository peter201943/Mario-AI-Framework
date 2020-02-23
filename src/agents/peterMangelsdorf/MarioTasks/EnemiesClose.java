package agents.peterMangelsdorf.MarioTasks;

import agents.peterMangelsdorf.BasicTasks.*;
import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class EnemiesClose extends Condition {
	
	// Variables
	float[] myPos;
	float[] enemies;
	float enemy_x = 0;
	float enemy_y = 0;
	float targetRange = 80;
	
	public EnemiesClose() {
		super();
	}
	
	@Override
	public Status Execute(ActionState action, MarioForwardModel model) {
		
		// Update
		if ((this.myPos = model.getMarioFloatPos()) == null) {
			System.out.println("~~Cursed Null Pointer~~"); // DEBUG !!! DELETEME !!!
			return new Fail();
		}
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
					System.out.println("I CAN SEE THEM"); // DEBUG !!! DELETEME !!!
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
		System.out.println("NOBODY'S HOME"); // DEBUG !!! DELETEME !!!
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


















































