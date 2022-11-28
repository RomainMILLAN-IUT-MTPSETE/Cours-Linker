package fr.iutmontpellier.tpoge.stockage;

import java.util.List;

public interface Stockage<T> {

    public void create(T element);

    public void update(T element);

    public void deleteById(int id);

    public T getById(int id);

    public List<T> getAll();
}
