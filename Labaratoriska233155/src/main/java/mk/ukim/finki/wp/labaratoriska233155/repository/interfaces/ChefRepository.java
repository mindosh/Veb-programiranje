package mk.ukim.finki.wp.labaratoriska233155.repository.interfaces;

import mk.ukim.finki.wp.labaratoriska233155.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {

}
