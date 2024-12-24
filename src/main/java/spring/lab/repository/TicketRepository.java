package spring.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.lab.repository.entity.TicketEntity;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    @Query("SELECT t FROM TicketEntity t WHERE t.user.email = :email")
    List<TicketEntity> findTicketsByUserEmail(String email);

    @Query("SELECT t FROM TicketEntity t WHERE t.user.username = :username")
    List<TicketEntity> findTicketsByUsername(String username);

    @Query("SELECT t FROM TicketEntity t WHERE t.user.id = :userId")
    List<TicketEntity> findTicketsByUserId(Long userId);

    List<TicketEntity> findByMovieTitleContainingIgnoreCase(String title);
}
