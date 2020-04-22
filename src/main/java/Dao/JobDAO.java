package Dao;

import Models.Job;

import java.util.List;

public interface JobDAO {
    void add(Job job);

    Job getByID(Long id);
    List<Job> getAll();

    void update(Job job);

    void remove(Job job);
}
