package com.ohgiraffers.z_activity.team_mission.model;

public class Member {
    private int memberId;
    private String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  "회원ID:" + memberId +
                ", 회원이름:" + name;
    }
}
