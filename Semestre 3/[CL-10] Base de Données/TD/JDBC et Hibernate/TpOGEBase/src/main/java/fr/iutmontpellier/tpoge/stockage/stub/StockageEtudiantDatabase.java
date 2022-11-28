package fr.iutmontpellier.tpoge.stockage.stub;

import fr.iutmontpellier.tpoge.metier.entite.Etudiant;
import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.metier.manager.RessourceManager;
import fr.iutmontpellier.tpoge.stockage.Stockage;
import fr.iutmontpellier.tpoge.stockage.sql.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockageEtudiantDatabase implements Stockage<Etudiant> {
    @Override
    public void create(Etudiant element) {
        try {
            SQLUtils.getInstance().getConnection().createStatement().execute("INSERT INTO EtudiantsOGE(nom, prenom, idRessourceFavorite) VALUES('"+element.getNom()+"', '"+element.getPrenom()+"', '"+element.getRessourceFavorite().getIdRessource()+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Etudiant element) {
        try {
            SQLUtils.getInstance().getConnection().createStatement().execute("UPDATE EtudiantsOGE set nom='"+element.getNom()+"', prenom='"+element.getPrenom()+"', idRessourceFavorite='"+element.getRessourceFavorite().getIdRessource()+"' WHERE idEtudiant='"+element.getIdEtudiant()+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            SQLUtils.getInstance().getConnection().createStatement().execute("DELETE FROM EtudiantsOGE WHERE idEtudiant='"+id+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Etudiant getById(int id) {
        try {
            ResultSet res = SQLUtils.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM EtudiantsOGE WHERE idEtudiant='"+id+"'");

            while(res.next()){
                Etudiant e = new Etudiant(res.getString("nom"), res.getString("prenom"), RessourceManager.getInstance().getRessource(res.getInt("idRessourceFavorite")));
                e.setIdEtudiant(res.getInt("idEtudiant"));
                return e;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Etudiant> getAll() {
        try {
            List<Etudiant> res = new ArrayList<>();
            ResultSet resSet = SQLUtils.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM EtudiantsOGE");

            while(resSet.next()){
                Etudiant e = new Etudiant(resSet.getString("nom"), resSet.getString("prenom"), RessourceManager.getInstance().getRessource(resSet.getInt("idRessourceFavorite")));
                e.setIdEtudiant(resSet.getInt("idEtudiant"));
                res.add(e);
            }

            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
