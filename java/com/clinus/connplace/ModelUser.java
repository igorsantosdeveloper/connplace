package com.clinus.connplace;

public class ModelUser {

    private String name;
    private String password;
    private String location;
    private String age;
    private String dateOfBirth;
    private String sex;

    public ModelUser(String name,
                     String password,
                     String location,
                     String age,
                     String dateOfBirth,
                     String sex) {

        this.name = name;
        this.password = password;
        this.location = location;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    };

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}
    public String getAge() {return age;}
    public void setAge(String age) {this.age = age;}
    public String getSex(){return sex;}
    public void setSex(String sex){this.sex = sex;}
    public String getDateOfBirth(){return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth){this.dateOfBirth = dateOfBirth;}
}
