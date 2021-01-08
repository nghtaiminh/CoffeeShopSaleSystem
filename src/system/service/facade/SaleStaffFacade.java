package system.service.facade;

import system.service.DAO.SaleStaffDAO;
import system.service.business.BillProducer;
import system.service.business.Order;
import system.service.business.SaleStaffOperation;
import system.service.business.OrderRecorder;

public class SaleStaffFacade {

    public void record(Order order) throws Exception {
        SaleStaffOperation orderRecorder = new OrderRecorder(order);
        orderRecorder.operate();
    }

    public void produceBill(Order order) throws Exception {
        SaleStaffOperation billProducer = new BillProducer(order);
        billProducer.operate();
    }
}
