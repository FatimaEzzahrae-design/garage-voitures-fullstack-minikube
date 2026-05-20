package org.cours.springdatarest;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class CarRecommendationController {

    @Autowired
    private CarRecommendationService recommendationService;

    @PostConstruct
    public void init() {
        System.out.println("🔥 CarRecommendationController CHARGÉ");
    }

    @GetMapping("/recommend")
    public List<RecommendationResult> recommend(
            @RequestParam int budget,
            @RequestParam String usage
    ) {
        return recommendationService.recommend(budget, usage);
    }
}