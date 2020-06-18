package rs.ac.metropolitan.cs330.pz.metpizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.cs330.pz.metpizzeria.entities.Impression;

@Repository
public interface ImpressionRepository extends JpaRepository<Impression, Long> {
}
