package Dao;

import Models.Employer;

import java.util.List;

public interface EmployerDAO {
    void add(Employer employer);

    Employer getByID(Long id);
    List<Employer> getAll();

    void update(Employer employer);

    void remove(Employer employer);
}
