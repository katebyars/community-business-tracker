package models;
import models.Business;

public class Employer extends Business {

    private String population;


    public Employer(String name, String contact, String hours, String businessType, String population) {
        super (name, contact, hours, businessType);
        this.population = population;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

}
