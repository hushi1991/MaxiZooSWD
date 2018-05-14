package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MemberRepo implements IMemberRepo {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void createMember(Member member) {

        jdbc.update("INSERT INTO maxi_zoo.name(name, mail, newsletter) VALUES('" + member.getName() +"',  '"+ member.getMail() +"',  '"+ member.isNewsLetter() +"')");
    }

    @Override
    public void deleteMember(int id) {

        jdbc.update("DELETE FROM maxi_zoo.name WHERE id=" + id + "");
    }


}
