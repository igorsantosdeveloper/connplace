package com.clinus.connplace;

import java.util.ArrayList;

public class DynamicQuery {

    public String createUserListQuery(ArrayList<Integer> id_s){

        String query = "SELECT USER_NAME FROM CCP_USER WHERE USER_ID=";//...

        if(id_s.size() > 0) {

            query += id_s.get(0);
            if(id_s.size() > 1) {

                for (int i = 1;i < id_s.size();i++) {

                    query += " OR USER_ID=" + id_s.get(i);
                }
            }
        }else{

            return null;
        }
        return query;
    }
}

