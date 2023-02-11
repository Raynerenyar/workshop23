package sg.edu.nus.iss.app.workshop23.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.workshop23.model.OrderData;
import static sg.edu.nus.iss.app.workshop23.repository.Queries.*;

@Repository
public class OrderDataRepoImpl implements OrderDataRepo {

    @Autowired
    JdbcTemplate jdbc;

    public List<OrderData> getOrderData(int orderId) {

        Object[] args = new Object[] { orderId };
        int[] argTypes = new int[] { Types.INTEGER };
        return jdbc.query(GET_ORDER_DATA_SQL, args, argTypes, new ResultSetExtractor<List<OrderData>>() {

            @Override
            public List<OrderData> extractData(ResultSet rs) throws SQLException, DataAccessException {
                BeanPropertyRowMapper<OrderData> bprm = new BeanPropertyRowMapper<OrderData>(OrderData.class);
                List<OrderData> listOf = new LinkedList<OrderData>();
                while (rs.next()) {
                    listOf.add(bprm.mapRow(rs, 0));
                }
                return listOf;
            }
        });
    };

}
