package sg.edu.nus.iss.app.workshop23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sg.edu.nus.iss.app.workshop23.model.OrderData;
import sg.edu.nus.iss.app.workshop23.service.RepoService;

@Controller
public class OrderController {

    @Autowired
    RepoService repoService;

    @PostMapping("/order/total")
    public String redirect(@RequestBody MultiValueMap<String, String> map) {
        String orderNum = map.getFirst("orderNumber");
        return "redirect:/order/total/" + orderNum;
    }

    @GetMapping(path = "/order/total/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getOrders(@PathVariable int orderId, Model model) {
        List<OrderData> listOf = repoService.getOrderData(orderId);
        if (listOf.isEmpty()) {
            model.addAttribute("orderId", orderId);
            return "error";
        }
        model.addAttribute("listOfOrderData", listOf);
        return "orderDetails";
    }
}
