package dao;
import models.Business;
import java.util.List;

public interface BusinessDao {

    //create
     void add(Business business);

    //read
    List<Business> getAll();
    Business findById(int id);

    //update
    void update(String name, String contact, String hours, String businessType, int id);

    //destroy
    void deleteById(int id);
}
