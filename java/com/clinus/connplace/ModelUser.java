package com.clinus.connplace;

public class ModelUser {

    private int id;
    private String name;
    private String password;
    private int age;
    private String strAge;
    private String dateOfBirth;
    private String sex;

    public ModelUser(String name,
                     String password,
                     String strAge,
                     String dateOfBirth,
                     String sex) {

        this.name = name;
        this.password = password;
        this.strAge = strAge;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    };

    public ModelUser(String name, String password, int age, String dateOfBirth, String sex) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public ModelUser(int id) {

        this.id = id;
        this.name = "";
        this.password = "";
        this.age = 0;
        this.strAge = "";
        this.dateOfBirth = "";
        this.sex = "";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getStrAge() {return strAge;}
    public void setStrAge(String strAge) {this.strAge = strAge;}
    public String getSex(){return sex;}
    public void setSex(String sex){this.sex = sex;}
    public String getDateOfBirth(){return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth){this.dateOfBirth = dateOfBirth;}

    @Override
    public String toString() {
        return "ModelUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", strAge='" + strAge + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
