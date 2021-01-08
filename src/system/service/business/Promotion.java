package system.service.business;

import java.sql.Date;

public class Promotion {
    private Integer ID;
    private Date startDate;
    private Date endDate;
    private double discountPercentage;

    public Promotion(Date startDate, Date endDate, double discountPercentage) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
    }
}
