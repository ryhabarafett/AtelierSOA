package metiers;

import entities.Logement;
import entities.RendezVous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RendezVousBusiness {
    // In-memory storage for demonstration purposes
    private static Map<Integer, RendezVous> rendezVousList = new HashMap<>();
    private LogementBusiness logementBusiness = new LogementBusiness();

    // Initialize with some sample data
    static {
        Logement logement1 = new Logement(1, "123 Rue Principale", "La Marsa", "Tunis", "Appartement", "Beau appartement avec vue sur mer", 1200.0f);
        Logement logement2 = new Logement(2, "45 Avenue Habib Bourguiba", "Centre Ville", "Tunis", "Bureau", "Espace de bureau moderne", 2500.0f);

        rendezVousList.put(1, new RendezVous(1, "2023-04-15", "10:00", logement1, "22111333"));
        rendezVousList.put(2, new RendezVous(2, "2023-04-16", "14:30", logement1, "98765432"));
        rendezVousList.put(3, new RendezVous(3, "2023-04-17", "11:00", logement2, "55667788"));
    }

    public List<RendezVous> getRendezVousList() {
        return new ArrayList<>(rendezVousList.values());
    }

    public RendezVous getRendezVousById(int id) {
        return rendezVousList.get(id);
    }

    public boolean addRendezVous(RendezVous rendezVous) {
        if (rendezVousList.containsKey(rendezVous.getId())) {
            return false;
        }
        rendezVousList.put(rendezVous.getId(), rendezVous);
        return true;
    }

    public boolean updateRendezVous(RendezVous rendezVous) {
        if (!rendezVousList.containsKey(rendezVous.getId())) {
            return false;
        }
        rendezVousList.put(rendezVous.getId(), rendezVous);
        return true;
    }

    public boolean deleteRendezVous(int id) {
        if (!rendezVousList.containsKey(id)) {
            return false;
        }
        rendezVousList.remove(id);
        return true;
    }

    public List<RendezVous> getRendezVousByLogement(int logementReference) {
        return rendezVousList.values().stream()
                .filter(rv -> rv.getLogement() != null && rv.getLogement().getReference() == logementReference)
                .collect(Collectors.toList());
    }
}