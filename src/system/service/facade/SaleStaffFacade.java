package system.service.facade;

import system.service.business.BillProducer;
import system.service.business.Order;
import system.service.business.SaleStaffOperation;
import system.service.business.OrderRecorder;

public class SaleStaffFacade {

    public void record(Order order) throws Exception {
        SaleStaffOperation orderRecorder = new OrderRecorder();
        orderRecorder.operate(order);
    }

    public void produceBill(Order order) throws Exception {
        SaleStaffOperation billProducer = new BillProducer();
        billProducer.operate(order);
        //createBill(order);
        //printBill();
    }
}
