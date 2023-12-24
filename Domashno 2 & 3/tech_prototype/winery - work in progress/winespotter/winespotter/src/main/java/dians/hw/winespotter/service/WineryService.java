package dians.hw.winespotter.service;
import dians.hw.winespotter.model.Winery;

import java.util.List;

public interface WineryService {

    List<Winery> findAll();
    Winery findByID(Long id);
    List<Winery> findByNameContains(String name);

    List<Winery> findByCitiesContains(String city);

}
