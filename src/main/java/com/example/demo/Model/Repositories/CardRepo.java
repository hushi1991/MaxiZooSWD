package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class CardRepo implements ICardRepo {


    @Autowired
    private JdbcTemplate jdbc;


    @Override
    public void createCard(Card card){

        jdbc.update("INSERT INTO maxi_zoo.card(bcardnumber, scardnumber, gcardnumber, bstartdate, sstartdate, gstartdate, benddate, senddate, genddate) VALUES('" + card.getbCardNumber() +"', + '" + card.getsCardNumber() +"'," +
                " + '" + card.getgCardNumber() +"', '" + card.getbStartDate() +"', '" + card.getsStartDate() +"', '" + card.getgStartDate() +"', '" + card.getbEndDate() +"', '" + card.getsEndDate() +"', '" + card.getgEndDate() +"' ) ");
    }

    @Override
    public void deleteCard(int id) {

        jdbc.update("DELETE FROM maxi_zoo.card WHERE id=" + id + "");
    }

    @Override
    public void updateCard(Card card) {

        jdbc.update("UPDATE maxi_zoo.card SET bcardnumber = '" + card.getbCardNumber() +"', scardnumber = '" + card.getsCardNumber() +"', gcardnumber = '" + card.getgCardNumber() +"', bstartdate = '" + card.getbStartDate() +"', sstartdate = '" + card.getsStartDate() +"', gstartdate = '" + card.getgStartDate() +"'," +
                " benddate = '" + card.getbEndDate() +"', senddate = '" + card.getsEndDate() +"', genddate = '" + card.getgEndDate() + "'");

    }

    @Override
    public Card read(int id) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.card WHERE id =" + id + "");

        if (sqlRowSet.next()){
            return new Card(sqlRowSet.getInt("id"), sqlRowSet.getInt("bcardnumber"), sqlRowSet.getInt("scardnumber"), sqlRowSet.getInt("gcardnumber"), sqlRowSet.getDate("bstartdate").toLocalDate(), sqlRowSet.getDate("benddate").toLocalDate(), sqlRowSet.getDate("sstartdate").toLocalDate(), sqlRowSet.getDate("senddate").toLocalDate(), sqlRowSet.getDate("gstartdate").toLocalDate(), sqlRowSet.getDate("genddate").toLocalDate());
        }
        return new Card();
    }
}
