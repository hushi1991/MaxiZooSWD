package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Member;

public interface IMemberRepo {

    public void createMember(Member member);

    public void deleteMember(int id);

    public Member read(int id);

    public void update(Member member);
}
