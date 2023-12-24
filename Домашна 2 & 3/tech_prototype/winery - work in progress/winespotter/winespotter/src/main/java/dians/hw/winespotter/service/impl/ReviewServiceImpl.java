package dians.hw.winespotter.service.impl;

import dians.hw.winespotter.model.Review;
import dians.hw.winespotter.model.Winery;
import dians.hw.winespotter.repository.ReviewRepository;
import dians.hw.winespotter.repository.WineryRepository;
import dians.hw.winespotter.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final WineryRepository wineryRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, WineryRepository wineryRepository) {
        this.reviewRepository = reviewRepository;
        this.wineryRepository = wineryRepository;
    }


    @Override
    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Optional<Review> save(String name, Integer grade, String comment, Long wineryID) {
        return Optional.of(this.reviewRepository.save(new Review(name, grade,comment, wineryRepository.findById(wineryID).get())));
    }
}
