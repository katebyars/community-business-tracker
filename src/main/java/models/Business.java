package models;


public class Business {

    private String name;
    private String contact;
    private String hours;
    private String businessType;

    public Business(String name, String contact, String hours, String businessType) {
        this.name = name;
        this.contact = contact;
        this.hours = hours;
        this.businessType = businessType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Business business = (Business) o;

        if (!name.equals(business.name)) return false;
        if (!contact.equals(business.contact)) return false;
        if (!hours.equals(business.hours)) return false;
        return businessType.equals(business.businessType);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + contact.hashCode();
        result = 31 * result + hours.hashCode();
        result = 31 * result + businessType.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
