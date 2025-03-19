package com.ohgiraffers.z_activity.mission.model;

public class LibraryMember {
    private String name;
    private String membershipId;

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

}
