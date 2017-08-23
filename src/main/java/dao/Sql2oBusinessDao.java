package dao;


import models.Business;
import models.Category;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oBusinessDao implements BusinessDao{

    private final Sql2o sql2o;

    public Sql2oBusinessDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Business business) {

    }

    @Override
    public void addBusinessToCategory(Business business, Category category) {

    }

    @Override
    public Business findById(int id) {
        return null;
    }

    @Override
    public List<Business> getAll() {
        return null;
    }

    @Override
    public List<Category> getAllCategoriesForABusiness(int businessId) {
        return null;
    }

    @Override
    public void update(String name, String contact, String hours, String businessType, int id) {

    }

    @Override
    public void deleteById(int id) {

    }
}
