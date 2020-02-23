package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Choose extends Container{
	
	private Status status;
	
	public Choose() {
		super();
		status = new Status();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		Status temp = new Status();
		for (Task child : this.Children()){
			temp = child.Execute(action, model);
			if (temp.Value() == status.win()) {
				return new Win();
			}
			else if (temp.Value() == status.running()) {
				return new Running();
			}
		}
		return new Win();
	}

}
