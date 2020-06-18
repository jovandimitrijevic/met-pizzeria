package rs.ac.metropolitan.cs330.pz.metpizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.cs330.pz.metpizzeria.entities.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
