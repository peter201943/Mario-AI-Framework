package agents.peterMangelsdorf.Helpers;

public class Status {

	
	// Values -- set them here
	
	private int win = 0;
	private int fail = 1;
	private int running = 2;
	
	public Status() {
	}
	
	
	// All Statuses need a Value -- this is what they are
	
	public int Value() {
		return 0;
	}
	
	
	
	// Stringer -- for pretty printing
	
	public String Verbose(Status aStatus) {
		if (aStatus.Value() == this.win) {
			return "win";
		}
		else if (aStatus.Value() == this.fail) {
			return "fail";
		}
		else if (aStatus.Value() == this.running) {
			return "running";
		}
		else {
			return "unknown";
		}
	}
	
	
	
	// Value Checks -- give names to values -- use in `if` checks
	
	public int win() {
		return this.win;
	}
	
	public int fail() {
		return this.fail;
	}
	
	public int running() {
		return this.running;
	}
}
