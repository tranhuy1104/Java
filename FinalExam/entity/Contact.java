package FinalExam.entity;

public class Contact {

    private String contactName;
    private String company;
    private String email;
    private String phone;

    public String getContactName(){
        return contactName;
    }
    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    public String getCompany(){
        return  company;
    }
    public void setCompany(String company){
        this.company = company;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
