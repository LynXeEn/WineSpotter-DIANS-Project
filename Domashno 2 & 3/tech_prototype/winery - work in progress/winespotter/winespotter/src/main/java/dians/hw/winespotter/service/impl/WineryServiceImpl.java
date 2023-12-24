package dians.hw.winespotter.service.impl;
import dians.hw.winespotter.model.Winery;
import dians.hw.winespotter.repository.WineryRepository;
import dians.hw.winespotter.service.WineryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineryServiceImpl implements WineryService {

    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public List<Winery> findAll() {
        return wineryRepository.findAll();
    }

    @Override
    public Winery findByID(Long id) {
        return wineryRepository.findById(id).get();
    }

    @Override
    public List<Winery> findByNameContains(String name) {
        return wineryRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Winery> findByCitiesContains(String city) {
        return wineryRepository.findByCitiesContainsIgnoreCase(city);
    }

}
