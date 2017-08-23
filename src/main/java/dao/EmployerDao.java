package dao;
import models.Employer;

import java.util.List;

public interface EmployerDao {

    //create
    void add (Employer employer);

    //read
    List<Employer> getAll();
}
