package com.clinus.connplace;

public class ModelUser {

    private String name;
    private String password;
    private String location;
    private String age;
    private String sex;

    public ModelUser(String name,
                     String password,
                     String location,
                     String age,
                     String sex) {

        this.name = name;
        this.password = password;
        this.location = location;
        this.age = age;
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
}
