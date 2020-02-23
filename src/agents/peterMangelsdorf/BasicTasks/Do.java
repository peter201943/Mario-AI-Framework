package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;
import engine.core.MarioForwardModel;

public class Do extends Container{

	Status status;
	
	public Do() {
		super();
		status = new Status();
	}
	
	@Override
	public Status Execute(boolean[] action, MarioForwardModel model) {
		Status temp = new Status();
		for (Task child : this.Children()){
			temp = child.Execute(action, model);
			if (temp.Value() == status.fail()) {
				return new Fail();
			}
			else if (temp.Value() == status.running()) {
				return new Running();
			}
		}
		return new Win();
	}
}
