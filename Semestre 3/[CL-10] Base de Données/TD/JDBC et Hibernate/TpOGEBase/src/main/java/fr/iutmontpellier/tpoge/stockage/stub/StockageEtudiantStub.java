package fr.iutmontpellier.tpoge.stockage.stub;

import fr.iutmontpellier.tpoge.metier.entite.Etudiant;
import fr.iutmontpellier.tpoge.stockage.Stockage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockageEtudiantStub implements Stockage<Etudiant> {

    private static int INDEX = 0;

    private final Map<Integer, Etudiant> etudiantsMap = new HashMap<Integer, Etudiant>();

    public void create(Etudiant etudiant) {
        etudiant.setIdEtudiant(INDEX);
        etudiantsMap.put(INDEX, etudiant);
        INDEX++;
    }

    public void deleteById(int id) {
        this.etudiantsMap.remove(id);
    }

    public void update(Etudiant etudiant) {
        this.etudiantsMap.put(etudiant.getIdEtudiant(), etudiant);
    }

    public List<Etudiant> getAll() {
        return new ArrayList<>(this.etudiantsMap.values());
    }

    public Etudiant getById(int id) {
        return this.etudiantsMap.get(id);
    }

}
