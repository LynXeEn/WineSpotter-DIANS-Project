package dians.hw.winespotter.repository;
import dians.hw.winespotter.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineryRepository extends JpaRepository<Winery,Long> {
    List<Winery> findByNameContainsIgnoreCase(String name);
    List<Winery> findByCitiesContainsIgnoreCase(String city);
}
