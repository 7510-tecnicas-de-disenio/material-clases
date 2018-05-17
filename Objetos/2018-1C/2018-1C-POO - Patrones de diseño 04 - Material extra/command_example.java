public interface Executable {
	void execute();
}

public class Worker  {
	
	private Executable target;
	
	public void setTarget(Executable executable) {
		this.target = executable;
	}
	
	public bool execute() {
		this.target.execute();
	}
}


public class Puller extends Executable {
	[...]	
	public void execute() {
		Data data = this.pullData();
		this.queueData(data);
	}
}

public class Translator extends Executable {
	[...]	
	public void execute() {
		Data input = this.pullData();
		ProcessedData output = this.(data);
		this.queueData(output);
	}
}

public class Pusher extends Executable {
	[...]	
	public void execute() {
		ProcessedData data = this.popData();
		this.pushData(data);
	}
}
