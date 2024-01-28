import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {
    private static final Logger LOG = LoggerFactory.getLogger(Bank.class);
    
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }
    public double totalInterestPaid() {
        double total = 0;
        
        LOG.debug("value of total local variable before entering the loop was " + total);
        
        for(Customer c: customers)
            total += c.totalInterestEarned();
        
        LOG.debug("value of total local variable was " + total);
        
        return total;
    }
    public String getFirstCustomer() {
        try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
