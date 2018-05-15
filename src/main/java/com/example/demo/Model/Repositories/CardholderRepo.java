package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.CardHolder;
import com.example.demo.Model.Entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardholderRepo implements ICardHolderRepo {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private CardRepo cR;
    @Autowired
    private EmployeeRepo eR;
    @Autowired
    private MemberRepo mR;

    @Override
    public void createCardHolder(CardHolder cardHolder) {

        /*
        jdbc.update("INSERT INTO maxi_zoo.employee(name, status, phone) VALUES('" + employee.getName() +"', '"+ employee.getStatus() +"', '"+ employee.getPhone() +"')");
        jdbc.update("INSERT INTO maxi_zoo.cardholder(address, postalcode, phone, member_id, card_id, employee_id) ")
        */



    }

    @Override
    public void deleteCardHolder(int id) {

    }

    @Override
    public CardHolder readSpecificCardHolder(int id) {
        return null;
    }

    // Problem er her at vi prøver at hente et objekt og ikke en datatype.
    @Override
    public CardHolder read(int id) {

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.cardholder WHERE id=" + id + "");

        if (sqlRowSet.next()){
            return new CardHolder(sqlRowSet.getInt("id"), mR.read(sqlRowSet.getInt("member_id")), cR.read(sqlRowSet.getInt("card_id")), sqlRowSet.getString("address"), sqlRowSet.getString("postalcode"), sqlRowSet.getString("phone"), eR.read(sqlRowSet.getInt("employee_id")));
        }
        return new CardHolder();
    }

}
