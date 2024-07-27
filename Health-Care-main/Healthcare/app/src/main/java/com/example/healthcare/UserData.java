package com.example.healthcare;

public class UserData {
    private String UID;
    private String FirstName;
    private String LastName;
    private String Contact;
    private String Email;
    private String Age;
    private String FCM;

    public UserData(){

    }
    public String getFirstName(){
        return FirstName;
    }
    public String getFCM(){
        return FCM;
    }
    public String getLastName(){
        return LastName;
    }
    public String getContact(){
        return Contact;
    }
    public String getEmail(){
        return Email;
    }
    public String getUID(){
        return UID;
    }
    public String getAge(){
        return Age;
    }
    public void setUID(String UID){
        this.UID = UID;
    }
    public void setFirstName(String Firstname){
        this.FirstName = Firstname;
    }
    public void setLastName(String Lastname){
        this.LastName = Lastname;
    }
    public void setContact(String Contact){
        this.Contact = Contact;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public void setAge(String Age){
        this.Age = Age;
    }
    public void setFCM(String FCM){
        this.FCM = FCM;
    }


}
