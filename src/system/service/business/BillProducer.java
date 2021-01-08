package system.service.business;

public class BillProducer implements SaleStaffOperation {

    private Order order;

    public BillProducer(Order order){
        this.order = order;
    }
    @Override
    public void operate() {
        var bill = new Bill(order);
        bill.printBill();
    }
}
