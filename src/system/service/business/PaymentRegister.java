package system.service.business;

public class PaymentRegister implements SaleStaffOperation {
    @Override
    public void operate(Order order) {
        System.out.println("Insert payment data into the Database");
    }
}
