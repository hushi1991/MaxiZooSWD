package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.CardHolder;
import com.example.demo.Model.Entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;

public class CardholderRepo implements ICardHolderRepo {

    @Autowired
    private JdbcTemplate jdbc;


    @Override
    public void createCardHolder(CardHolder cardHolder) {

    }

    @Override
    public void deleteCardHolder(int id) {

    }

    @Override
    public CardHolder readSpecificCardHolder(int id) {
        return null;
    }

    // Problem er her at vi prøver at hente et objekt og ikke en datatype.
    /*
    @Override
    public CardHolder readSpecificCardHolder(int id) {

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.cardholder WHERE id=" + id + "");

        if (sqlRowSet.next()){
            return new CardHolder(sqlRowSet.getInt("id"), sqlRowSet.getObject("member"), sqlRowSet.getObject("card"), sqlRowSet.getString("address"), sqlRowSet.getString("postalCode"), sqlRowSet.getString("phone"));
        }
        return new CardHolder();
    }
    */


}
