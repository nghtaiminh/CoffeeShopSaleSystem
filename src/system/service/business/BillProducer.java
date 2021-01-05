package system.service.business;

public class BillProducer implements SaleStaffOperation {

    @Override
    public void operate(Order order) {
        var bill = new Bill(order);
        bill.printBill();
    }

}
