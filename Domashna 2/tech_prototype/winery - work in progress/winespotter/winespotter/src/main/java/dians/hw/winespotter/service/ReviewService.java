package dians.hw.winespotter.service;

import dians.hw.winespotter.model.Review;
import dians.hw.winespotter.model.Winery;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Optional<Review> save(String name, Integer grade,String comment,Long wineryID);
}
