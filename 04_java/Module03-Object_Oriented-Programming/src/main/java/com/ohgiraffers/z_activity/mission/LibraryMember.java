package com.ohgiraffers.z_activity.mission;

public class LibraryMember {
    private String name;
    private String membershipId;

    public int getBorrowLimit() {
        return 3;
    }

    public LibraryMember(String name, String membershipId) {
        this.name = name;
        this.membershipId = membershipId;
    }

    public String getName() {
        return name;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "name='" + name + '\'' +
                ", membershipId='" + membershipId + '\'' +
                '}';
    }
}
