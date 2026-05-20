package org.cours.springdatarest.web;

import org.cours.springdatarest.modele.Voiture;
import org.cours.springdatarest.modele.VoitureRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/voitures")
public class VoitureController {

    private final VoitureRepo voitureRepo;

    public VoitureController(VoitureRepo voitureRepo) {
        this.voitureRepo = voitureRepo;
    }

    // GET all voitures
    @GetMapping
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll();
    }

    // POST add voiture
    @PostMapping
    public Voiture addVoiture(@RequestBody Voiture v) {
        return voitureRepo.save(v);
    }

    // GET voiture by id
    @GetMapping("/{id}")
    public Voiture getVoitureById(@PathVariable Long id) {
        return voitureRepo.findById(id).orElse(null);
    }

    // DELETE voiture
    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture v) {
        v.setId(id);
        return voitureRepo.save(v);
    }
}