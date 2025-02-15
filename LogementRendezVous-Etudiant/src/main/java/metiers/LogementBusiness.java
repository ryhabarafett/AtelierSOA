package metiers;

import entities.Logement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogementBusiness {
    // In-memory storage for demonstration purposes
    private static Map<Integer, Logement> logements = new HashMap<>();

    // Initialize with some sample data
    static {
        logements.put(1, new Logement(1, "123 Rue Principale", "La Marsa", "Tunis", "Appartement", "Beau appartement avec vue sur mer", 1200.0f));
        logements.put(2, new Logement(2, "45 Avenue Habib Bourguiba", "Centre Ville", "Tunis", "Bureau", "Espace de bureau moderne", 2500.0f));
        logements.put(3, new Logement(3, "67 Rue des Jasmins", "Sousse Ville", "Sousse", "Villa", "Grande villa avec jardin", 3500.0f));
    }

    public List<Logement> getLogements() {
        return new ArrayList<>(logements.values());
    }

    public Logement getLogementByReference(int reference) {
        return logements.get(reference);
    }

    public boolean addLogement(Logement logement) {
        if (logements.containsKey(logement.getReference())) {
            return false;
        }
        logements.put(logement.getReference(), logement);
        return true;
    }

    public boolean updateLogement(Logement logement) {
        if (!logements.containsKey(logement.getReference())) {
            return false;
        }
        logements.put(logement.getReference(), logement);
        return true;
    }

    public boolean deleteLogement(int reference) {
        if (!logements.containsKey(reference)) {
            return false;
        }
        logements.remove(reference);
        return true;
    }
}