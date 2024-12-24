package spring.lab.mapper;

import org.springframework.jdbc.core.RowMapper;
import spring.lab.domain.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketRowMapper implements RowMapper<Ticket> {
    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Ticket.builder()
                .id(rs.getLong("id"))
                .date(rs.getString("date"))
                .startTime(rs.getString("time"))
                .seat(rs.getInt("seat_number"))
                .movieTitle(rs.getString("movie_title"))
                .price(rs.getInt("price"))
                .build();
    }
}
