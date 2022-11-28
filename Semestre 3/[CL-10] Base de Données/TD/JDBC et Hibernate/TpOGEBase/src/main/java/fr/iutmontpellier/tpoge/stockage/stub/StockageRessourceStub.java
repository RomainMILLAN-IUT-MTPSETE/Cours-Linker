package fr.iutmontpellier.tpoge.stockage.stub;

import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.stockage.Stockage;

import java.util.*;

public class StockageRessourceStub implements Stockage<Ressource> {

    private static int INDEX = 0;

    private final Map<Integer, Ressource> ressourceMap = new HashMap<Integer, Ressource>();

    public StockageRessourceStub() {
        create(new Ressource("Programmation orientee objet"));
        create(new Ressource("Graphe"));
        create(new Ressource("Base de donnees"));
    }

    public void create(Ressource ressource) {
        ressource.setIdRessource(INDEX);
        ressourceMap.put(INDEX, ressource);
        INDEX++;
    }

    public void deleteById(int id) {
        this.ressourceMap.remove(id);
    }

    public void update(Ressource ressource) {
        this.ressourceMap.put(ressource.getIdRessource(), ressource);
    }

    public List<Ressource> getAll() {
        return new ArrayList<>(this.ressourceMap.values());
    }

    public Ressource getById(int id) {
        return this.ressourceMap.get(id);
    }
}
