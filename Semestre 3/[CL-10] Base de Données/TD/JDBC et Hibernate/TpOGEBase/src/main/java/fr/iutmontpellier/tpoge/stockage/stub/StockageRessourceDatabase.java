package fr.iutmontpellier.tpoge.stockage.stub;

import fr.iutmontpellier.tpoge.metier.entite.Ressource;
import fr.iutmontpellier.tpoge.stockage.Stockage;
import fr.iutmontpellier.tpoge.stockage.sql.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockageRessourceDatabase implements Stockage<Ressource> {

    public void create(Ressource ressource) {
        Connection cn = SQLUtils.getInstance().getConnection();
        try {
            cn.createStatement().executeUpdate("INSERT INTO RessourcesOGE(nom) VALUES('"+ressource.getNom()+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Ressource ressource) {
        try {
            SQLUtils.getInstance().getConnection().createStatement().executeUpdate("UPDATE RessourcesOGE set nom='"+ressource.getNom()+"' WHERE idRessource='"+ressource.getIdRessource()+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            SQLUtils.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM RessourcesOGE WHERE idRessource='"+id+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ressource getById(int id) {
        try {
            ResultSet res = SQLUtils.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM RessourcesOGE WHERE idRessource='"+id+"'");

            while(res.next()){
                Ressource r = new Ressource(res.getString("nom"));
                r.setIdRessource(res.getInt("idRessource"));
                return r;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List getAll() {
        List<Ressource> res = new ArrayList<>();
        try {
            ResultSet resSet = SQLUtils.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM RessourcesOGE ORDER BY idRessource");

            while(resSet.next()){
                Ressource r = new Ressource(resSet.getString("nom"));
                r.setIdRessource(resSet.getInt("idRessource"));
                res.add(r);
            }

            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
