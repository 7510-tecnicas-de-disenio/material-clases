public class Site { [...] }
public class Sale { [...] }

public interface SaleObserver {
	void notify(Sale sale);
}

public class CRM {
	
	private List<Sale> sales;
	private List<SaleObserver> saleObservers;
	
	public CRM () {
		this.sales = new ArrayList<Sale>();
		this.saleObservers = new ArrayList<SaleObserver>();
	}
	
	public void sell(Sale sale) {
		this.sales.add(sale);
		this.notifyObservers(sale);
	}
	[...]
	
	public void registerObserver(SaleObserver saleObserver) {
		this.saleObservers.add(saleObserver);
	}
	
	public void removeObserver(SaleObserver saleObserver) {
		this.saleObservers.remove(saleObserver);
	}
	
	private void notifyObservers(Sale sale) {
		for(SaleObserver observer : saleObservers) {
			observer.notify(sale);
		}
	}
	
}




public class Accounting implements SaleObserver {
	
	public void notify(Sale sale) {
		this.invoice(sale.getProduct(), sale.getAmount(), sale.getCustomer());
	}

	public void invoice(Product product, BigDecimal amount, Customer customer) {
		[...]
	}
}


