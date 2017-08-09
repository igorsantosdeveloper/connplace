package com.clinus.connplace;

import java.util.ArrayList;

public class DynamicCreateQuery {

    public String createUserListQuery(ArrayList<Integer> id_s){

        String query = "SELECT user_name AS nameUser FROM ccp_user WHERE user_id=";//...

        if(id_s.size() > 0) {

            query += id_s.get(0);
            if(id_s.size() > 1) {

                for (int i = 1;i < id_s.size();i++) {

                    query += " OR user_id="  + id_s.get(i);
                }
            }
        }else{

            return null;
        }
        return query;
    }
}

