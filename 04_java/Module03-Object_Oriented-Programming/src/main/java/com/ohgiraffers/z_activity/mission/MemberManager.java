package com.ohgiraffers.z_activity.mission;

public class MemberManager {
    private LibraryMember[] libraryMembers;

    public MemberManager(LibraryMember[] libraryMembers) {
        this.libraryMembers = libraryMembers;
    }

    public LibraryMember[] memberInfo() {
        for (LibraryMember libraryMember : libraryMembers) {
            System.out.println("회원 : " + libraryMember.getName() + ", ID : " + libraryMember.getMembershipId()
            + ", 대출 한도 : " + libraryMember.getBorrowLimit());
        }
        return libraryMembers;
    }
}
