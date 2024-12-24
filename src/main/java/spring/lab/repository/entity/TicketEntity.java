package spring.lab.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String startTime;

    @Column(nullable = false)
    Integer seat;

    @Column(nullable = false)
    Double price;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "movie_id")
    MovieEntity movie;
}
