package sg.edu.nus.iss.app.workshop23.repository;

import java.util.List;

import sg.edu.nus.iss.app.workshop23.model.OrderData;

public interface OrderDataRepo {
    List<OrderData> getOrderData(int orderId);
}
