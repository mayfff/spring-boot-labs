package spring.lab.dao.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import spring.lab.domain.Ticket;
import spring.lab.dto.TicketRequestDto;
import spring.lab.mapper.TicketRowMapper;
import spring.lab.dao.TicketDao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
@AllArgsConstructor
public class TicketDaoImpl implements TicketDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Ticket save(TicketRequestDto ticketRequestDto) {
        String sql = "INSERT INTO tickets (date, time, seat_number, movie_title, price) VALUES (?, ?, ?, ?, ?) RETURNING id";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ticketRequestDto.getDate());
            ps.setString(2, ticketRequestDto.getTime());
            ps.setInt(3, ticketRequestDto.getSeat());
            ps.setString(4, ticketRequestDto.getMovieTitle());
            ps.setDouble(5, ticketRequestDto.getPrice());
            return ps;
        }, keyHolder);

        Long generatedId = keyHolder.getKey().longValue();
        return findById(generatedId);
    }

    @Override
    public Ticket update(Long id, TicketRequestDto ticketRequestDto) {
        String sql = "UPDATE tickets SET date = ?, time = ?, seat_number = ?, movie_title = ?, price = ? WHERE id = ?";
        int updatedRows = jdbcTemplate.update(sql,
                ticketRequestDto.getDate(),
                ticketRequestDto.getTime(),
                ticketRequestDto.getSeat(),
                ticketRequestDto.getMovieTitle(),
                ticketRequestDto.getPrice(),
                id
        );

        if (updatedRows == 0) {
            throw new RuntimeException("Ticket with ID " + id + " not found.");
        }

        return findById(id);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM tickets WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Ticket findById(Long id) {
        String sql = "SELECT * FROM tickets WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new TicketRowMapper(), id);
    }

    @Override
    public List<Ticket> findAll(long page, long size) {
        String sql = "SELECT * FROM tickets LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new TicketRowMapper(), size, page * size);
    }

    @Override
    public List<Ticket> findTicketsByMovieTitle(String movieTitle) {
        String sql = "SELECT * FROM tickets WHERE LOWER(movie_title) LIKE ?";
        return jdbcTemplate.query(sql, new TicketRowMapper(), "%" + movieTitle.toLowerCase() + "%");
    }
}
