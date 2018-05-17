public static abstract class State {
	public abstract void move();
	public abstract State change();
}
	
public class GarageGate {
	
	private State state;
	
	public GarageGate(State state) {
		this.state = state;
	}

	public void activate() {
		this.state = this.state.change();
		this.state.move();
	}
}

public class Open extends GarageGate.State {
	
	public State change() {
		return new Closing();
	}
	
	public void move() {}
}

public class Closing extends GarageGate.State {
	
	public State change() {
		return new Close();
	}
	
	public void move() {
		[..mover en el sentido que cierra el portón...]
	}
}

public class Close extends GarageGate.State {
	
	public State change() {
		return new Openning();
	}
	
	public void move() {}
}

public class Openning extends GarageGate.State {
	
	public State change() {
		return new Open();
	}
	
	public void move() {
		[..mover en el sentido que abre el portón...]
	}
}
