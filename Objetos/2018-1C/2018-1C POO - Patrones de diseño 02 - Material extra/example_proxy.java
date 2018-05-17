// Some clases modeling travel packages...
public class Student {
	
	[...]
	private DeliveriesDAO deliveriesDAO;
	
	public Student() {
		this.deliveriesDAO = new DeliveriesDAO();
	}
	
	public List<Delivery> findDeliveries() {
		return deliveriesDAO.filter(this);
	}
	
	@Override
	public String toString() {
		return [...];
	}
}

public class StudentProxy extends Student {
	private Logger logger;
	
	public StudentProxy() {
		this.logger = new Logger(this);
	}
	
	public List<Delivery> findDeliveries() {
		this.logger.info(String.format("Finding deliveries for student <%s>", super.toString()));
		return super.findDeliveries();
	}	
	
}

public class DeliveriesView {
	
	private StudentFactory studentFactory;
	
	[...]
	
	public View get(Request request) {
		[...]
		Student student = studentFactory.buildFromRequest(request);
		List<Delivery> deliveries = student.findDeliveries();
		[...]
		return new View(..., deliveries);
	}
	
}
