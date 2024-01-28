package dians.hw.winespotter.web.controller;

import dians.hw.winespotter.service.ReviewService;
import dians.hw.winespotter.service.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final WineryService wineryService;


    public ReviewController(ReviewService reviewService, WineryService wineryService) {
        this.reviewService = reviewService;
        this.wineryService = wineryService;
    }

    @GetMapping
    String getReviews(Model model){
        model.addAttribute("reviews",reviewService.findAll());
        return "reviewList";
    }

    @GetMapping("add-form/{id}")
    String addFormForReview(Model model, @PathVariable Long id, @RequestParam(required = false) String error){
        model.addAttribute("winery",wineryService.findByID(id));
        if(error != null){
            model.addAttribute("errorMessage","The grade must be between 1 and 5");
            model.addAttribute("hasError",true);
        }
        return "addFormReview";
    }

    @PostMapping("add")
    String addReview(@RequestParam Long wineryID,
                     @RequestParam String name,
                     @RequestParam Integer grade,
                     @RequestParam String comment,
                     @RequestParam Long wineryName){
        if(grade < 1 || grade > 5){
            return "redirect:/reviews/add-form/"+wineryID+"?error=hasError";
        }
        this.reviewService.save(name,grade,comment,wineryName);
        return "redirect:/home";
    }
}
