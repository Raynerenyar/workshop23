package sg.edu.nus.iss.app.workshop23.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.workshop23.model.OrderData;
import sg.edu.nus.iss.app.workshop23.repository.OrderDataRepo;

@Service
public class RepoService {

    @Autowired
    OrderDataRepo orderDataRepo;

    public List<OrderData> getOrderData(int orderId) {
        List<OrderData> listOfOrderData = orderDataRepo.getOrderData(orderId);
        return listOfOrderData.stream()
                .map(orderData -> {
                    orderData.setTotalPrice(orderData.quantity * orderData.unitPrice); // removed orderData.discount
                    orderData.setCostPrice(orderData.quantity * orderData.standardCost);
                    return orderData;
                }).toList();
    }
}
