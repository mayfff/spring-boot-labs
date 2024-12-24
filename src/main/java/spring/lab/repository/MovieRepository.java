package spring.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.lab.repository.entity.MovieEntity;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
}
