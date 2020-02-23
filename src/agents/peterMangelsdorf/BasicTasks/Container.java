package agents.peterMangelsdorf.BasicTasks;

import java.util.ArrayList;

public class Container extends Task{

	private ArrayList<Task> children;
	
	public Container() {
		super();
		children = new ArrayList<>();
	}
	
	public void Add(Task newTask) {
		this.children.add(newTask);
	}
	
	public ArrayList<Task> Children(){
		return this.children;
	}
}
