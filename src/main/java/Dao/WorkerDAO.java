package Dao;


import Entity.Worker;

import java.util.List;

public interface WorkerDAO {
    void add(Worker worker);

    Worker getByID(Long id);
    List<Worker> getAll();

    void update(Worker worker);

    void remove(Worker worker);
}
