package org.cours.springdatarest;

import org.cours.springdatarest.modele.Voiture;
import org.cours.springdatarest.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRecommendationService {

    @Autowired
    private VoitureRepo voitureRepository;

    public List<RecommendationResult> recommend(int budget, String usage) {

        return voitureRepository.findAll()
                .stream()

                // ✅ tolérance budget (+20%)
                .filter(v -> v.getPrix() <= budget * 1.2)

                // 🔥 calcul score
                .map(v -> new RecommendationResult(
                        v,
                        calculateScore(v, usage, budget)
                ))

                // 📊 tri décroissant
                .sorted((a, b) -> Double.compare(b.getScore(), a.getScore()))

                // 🥇 top résultats
                .limit(5)

                .toList();
    }

    private double calculateScore(Voiture v, String usage, int budget) {

        double score = 0;

        // =========================
        // 🎯 SCORE BUDGET (important)
        // =========================
        double diff = Math.abs(budget - v.getPrix());
        double ratio = 1 - (diff / (double) budget);

        score += Math.max(0, ratio) * 50;

        // =========================
        // 🚗 SCORE MARQUE / USAGE
        // =========================
        if ("ville".equalsIgnoreCase(usage)) {

            if ("Toyota".equalsIgnoreCase(v.getMarque())) {
                score += 30;
            } else if ("Ford".equalsIgnoreCase(v.getMarque())) {
                score += 20;
            } else {
                score += 10;
            }
        }

        // =========================
        // 👨‍👩‍👧 USAGE FAMILLE
        // =========================
        if ("famille".equalsIgnoreCase(usage)) {

            String modele = v.getModele().toLowerCase();

            if (modele.contains("crv") ||
                    modele.contains("suv") ||
                    modele.contains("rav4")) {

                score += 40;
            } else {
                score += 10;
            }
        }

        // =========================
        // 🕒 BONUS ANCIENNETÉ
        // =========================
        int currentYear = 2026;
        score += Math.max(0, (currentYear - v.getAnnee()) * 1.5);

        return score;
    }
}