package org.cours.springdatarest;

import org.cours.springdatarest.modele.Voiture;

public class RecommendationResult {

    private Voiture voiture;
    private double score;

    public RecommendationResult() {}

    public RecommendationResult(Voiture voiture, double score) {
        this.voiture = voiture;
        this.score = score;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}