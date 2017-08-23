package dao;
import models.Business;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oBusinessDao implements BusinessDao{

    private final Sql2o sql2o;

    public Sql2oBusinessDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Business business) {
        String sql = "INSERT INTO businesses (name, contact, hours, businessType) VALUES (:name, :contact, :hours, :businessType)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(business)
                    .executeUpdate()
                    .getKey();
            business.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public Business findById(int id) {
        String sql = "SELECT * FROM businesses WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Business.class);
        }
    }

    @Override
    public List<Business> getAll() {
        String sql = "SELECT * FROM businesses";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Business.class);
        }
    }

    @Override
    public void update(String name, String contact, String hours, String businessType, int id) {
        String sql = "UPDATE businesses SET (name, contact, hours, businessType) = (:name, :contact, :hours, :businessType) WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("contact", contact)
                    .addParameter("hours", hours)
                    .addParameter("businessType", businessType)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection con = sql2o.open()) {
            con.createQuery("DELETE FROM businesses WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }
}
