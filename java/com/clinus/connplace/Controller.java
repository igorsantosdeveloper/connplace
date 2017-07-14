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
                               String sex){

        ModelUser user = new ModelUser(name,password,location,age,sex);
        dao.newUser(user);
    }
}
