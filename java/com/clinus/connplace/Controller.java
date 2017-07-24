package com.clinus.connplace;

import android.content.Context;

public class Controller {

    public void newUser(Context context,
                        String name,
                        String password,
                        String age,
                        String dateOfBirth,
                        String sex){

        ModelUser user = new ModelUser(name,password,age,dateOfBirth,sex);
        CCplaceTest dao = new CCplaceTest(context);
        dao.newUser(user);
    }

    public int authenticateUser(Context context, String name, String password){

        CCplaceTest dao = new CCplaceTest(context);
        return dao.authenticateUser(name.toUpperCase(),password);
    }

    public int checkNameUser(Context context, String name){

        CCplaceTest dao = new CCplaceTest(context);
        return dao.checkNameUser(name.toUpperCase());
    }
}
