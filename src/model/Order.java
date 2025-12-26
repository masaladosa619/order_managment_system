package model;

import java.time.LocalDate;

public class Order {
    private int orderid;
    private int userid;
    private LocalDate orderdate;
    private double totalamt;
    private String status;

    public Order(int orderid,
     int userid,
     LocalDate orderdate,
     double totalamt,
     String status ){
        this.orderid=orderid;
        this.userid=userid;
        this.totalamt=totalamt;
        this.orderdate=orderdate;
        this.status=status;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderid +
                " | UserID: " + userid +
                " | Date: " + orderdate +
                " | Amount: ₹" + totalamt+
                " | Status: " + status;
    }


}
