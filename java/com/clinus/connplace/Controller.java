package com.clinus.connplace;

/**
 * Created by igorsantos on 14/07/17.
 */

public class Controller {

    public void controllerUser(CCplaceTest dao,
                               String name,
                               String password,
                               String location,
                               String age,
                               String dateOfBirth,
                               String sex){

        ModelUser user = new ModelUser(name,password,location,age,dateOfBirth,sex);
        dao.newUser(user);
    }
}
