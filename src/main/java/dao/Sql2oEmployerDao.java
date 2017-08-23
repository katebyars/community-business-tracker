package dao;


import models.Employer;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEmployerDao implements EmployerDao {

    private final Sql2o sql2o;
    public Sql2oEmployerDao(Sql2o sql2o) { this.sql2o = sql2o;}

    @Override
    public void add(Employer employer){
        String sql = "INSERT INTO employers (name, contact, hours, businessType, population) VALUES (:name, :contact, :hours, :businessType, :population)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(employer)
                    .executeUpdate()
                    .getKey();
            employer.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employer> getAll() {
        String sql = "SELECT * FROM employers";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Employer.class);
        }
    }
}
