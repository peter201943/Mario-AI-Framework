package agents.peterMangelsdorf.BasicTasks;

import agents.peterMangelsdorf.Helpers.*;

public class Do extends Container{

	Status status;
	
	public Do() {
		super();
		status = new Status();
	}
	
	@Override
	public Status Execute(boolean[] action) {
		Status temp = new Status();
		for (Task child : this.Children()){
			temp = child.Execute(action);
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
