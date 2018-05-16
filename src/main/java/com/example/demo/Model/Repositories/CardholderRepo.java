package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Card;
import com.example.demo.Model.Entities.CardHolder;
import com.example.demo.Model.Entities.Employee;
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
    public void createCardHolder(CardHolder cardHolder, Card card, String mail, String empId) {
        Card cnew = new Card();
        Member mnew = new Member();
        Employee enew = new Employee();


        jdbc.update("INSERT INTO maxi_zoo.card (bcardnumber, scardnumber, gcardnumber, bstartdate, sstartdate, gstartdate, benddate, senddate, genddate) values ('" + card.getbCardNumber() +"', '" + card.getsCardNumber() +"', '" + card.getgCardNumber() +"', '" + card.getbStartDate() +"', '" + card.getsStartDate() +"'," +
                "'" + card.getgStartDate() +"', '" + card.getbEndDate() +"', '" + card.getsEndDate() +"', '" + card.getgEndDate() +"',);");

        SqlRowSet sqlrow = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.card WHERE bcardnumber = '" + card.getbCardNumber() + "'");
        if (sqlrow.next()) {
            cnew.setCardId(sqlrow.getInt("id"));
        }

        SqlRowSet sqlrow1 = jdbc.queryForRowSet("SELECT id FROM maxi_zoo.member WHERE mail = '" + mail + "'");
        if (sqlrow1.next()) {
            mnew.setId(sqlrow1.getInt("id"));
        }

        SqlRowSet sqlrow2 = jdbc.queryForRowSet("SELECT id FROM maxi_zoo.employee WHERE id = '" + empId + "'");
        if (sqlrow2.next()) {
            enew.setId(sqlrow2.getInt("id"));
        }

        jdbc.update("INSERT INTO maxi_zoo.cardholder(address, postalcode, phone, member_id, card_id, employee_id) VALUES('" + cardHolder.getAddress() +"', '" + cardHolder.getPostalCode() +"', '" + cardHolder.getPhone() +"', '" + cardHolder.getMember() +"'," +
                        " '" + cardHolder.getCard() +"', '" + cardHolder.getEmployee() +"',) ");

    }

    @Override
    public void deleteCardHolder(int id) {

        jdbc.update("DELETE FROM maxi_zoo.cardholder WHERE id=" + id + "");

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
