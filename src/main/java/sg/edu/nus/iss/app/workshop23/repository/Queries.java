package sg.edu.nus.iss.app.workshop23.repository;

public class Queries {

    public static String GET_ORDER_DATA_SQL = """
            SELECT orders.id as order_id,  orders.order_date, orders.customer_id, products_order_details.quantity, products_order_details.unit_price, products_order_details.discount, products_order_details.standard_cost FROM (select order_details.order_id order_id, order_details.quantity quantity, order_details.unit_price unit_price, order_details.discount discount, products.standard_cost standard_cost from order_details LEFT JOIN products on products.id = order_details.product_id) as products_order_details LEFT JOIN orders ON products_order_details.order_id = orders.id WHERE order_id = ?
                """;
}
