package spring.lab.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50, nullable = false, unique = true)
    String title;

    @Column(length = 250, nullable = false)
    String description;
}
