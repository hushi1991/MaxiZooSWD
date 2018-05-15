package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MemberRepo implements IMemberRepo {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void createMember(Member member) {

        //jdbc.update("INSERT INTO maxi_zoo.member(name, mail, newsletter) VALUES('" + member.getName() +"',  '"+ member.getMail() +"',  '"+ member.isNewsletter() +"')");
        jdbc.update("INSERT INTO maxi_zoo.member(name, mail) VALUES('" + member.getName() +"',  '"+ member.getMail() +"')");
    }

    @Override
    public void deleteMember(int id) {

        jdbc.update("DELETE FROM maxi_zoo.member WHERE id=" + id + "");
    }

    @Override
    public Member read(int id) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.member WHERE id =" + id + "");

        if (sqlRowSet.next()){
            return new Member(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("mail"), sqlRowSet.getBoolean("newsletter"));
        }
        return new Member();
    }

}
