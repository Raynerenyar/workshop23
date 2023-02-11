package sg.edu.nus.iss.app.workshop23.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderData {
    public String orderId;
    public Date orderDate;
    public String customerId;
    public Double quantity;
    public Double unitPrice;
    public Double discount;
    public Double standardCost;
    public Double totalPrice;
    public Double costPrice;
}
