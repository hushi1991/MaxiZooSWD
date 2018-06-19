package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Card;
import com.example.demo.Model.Entities.CardHolder;
import com.example.demo.Model.Entities.Employee;
import com.example.demo.Model.Entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void createCardHolder(CardHolder cardHolder, Card card, String mail, String empName) {
        Card cnew = new Card();
        Member mnew = new Member();
        Employee enew = new Employee();

        cR.createCard(card);
        SqlRowSet sqlrow = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.card WHERE bcardnumber = '" + card.getbCardNumber() + "'");
        if (sqlrow.next()) {
            cnew.setCardId(sqlrow.getInt("id"));
        }

        SqlRowSet sqlrow1 = jdbc.queryForRowSet("SELECT id FROM maxi_zoo.member WHERE mail = '" + mail + "'");
        if (sqlrow1.next()) {
            mnew.setId(sqlrow1.getInt("id"));
        }

        SqlRowSet sqlrow2 = jdbc.queryForRowSet("SELECT id FROM maxi_zoo.employee WHERE name = '" + empName + "'");
        if (sqlrow2.next()) {
            enew.setId(sqlrow2.getInt("id"));
        }

        jdbc.update("INSERT INTO maxi_zoo.cardholder(address, postalcode, phone, member_id, card_id, employee_id) VALUES('" + cardHolder.getAddress() +"', '" + cardHolder.getPostalCode() +"', '" + cardHolder.getPhone() +"', '" + mnew.getId() +"'," +
                        " '" + cnew.getCardId() +"', '" + enew.getId() + "')");

    }

    @Override
    public void deleteCardHolder(int id) {

        jdbc.update("DELETE FROM maxi_zoo.cardholder WHERE id=" + id + "");

    }

    @Override
    public void updateCardHolder(CardHolder ch) {
        jdbc.update("UPDATE maxi_zoo.cardholder SET member_id ='" + ch.getMember().getId() + "', " + "card_id ='" + ch.getCard().getCardId()
         + "', " + "employee_id ='" + ch.getEmployee().getId() + "', " + "address = '" + ch.getAddress() + "', " +
                 "postalcode = '" + ch.getPostalCode() + "', " + "phone = '" + ch.getPhone() + "' WHERE  id ='" + ch.getId() + "'");

        cR.updateCard(ch.getCard());
        mR.update(ch.getMember());
    }

    @Override
    public CardHolder readSpecificCardHolder(int id) {
        return null;
    }

    @Override
    public CardHolder read(int id) {

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.cardholder WHERE id=" + id + "");

        if (sqlRowSet.next()){
            return new CardHolder(sqlRowSet.getInt("id"), mR.read(sqlRowSet.getInt("member_id")), cR.read(sqlRowSet.getInt("card_id")), sqlRowSet.getString("address"), sqlRowSet.getString("postalcode"), sqlRowSet.getString("phone"), eR.read(sqlRowSet.getInt("employee_id")));
        }
        return new CardHolder();
    }

    @Override
    public CardHolder search(String phone) {
        CardHolder chnew = new CardHolder();

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT id FROM maxi_zoo.cardholder WHERE phone=" + phone + "");

        if (sqlRowSet.next()) {
            chnew = read(sqlRowSet.getInt("id"));
            return chnew;
        }
        return null;
    }



}
