package dao;


import models.Business;
import models.Category;

import java.util.List;

public interface BusinessDao {

    //create
     void add(Business business);
     void addBusinessToCategory(Business business, Category category);

    //read
    List<Business> getAll();
    Business findById(int id);
    List<Category> getAllCategoriesForABusiness(int businessId);

    //update
    void update(String name, String contact, String hours, String businessType, int id);

    //destroy
    void deleteById(int id);
}
