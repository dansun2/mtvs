package com.ohgiraffers.z_activity.mission;

public class Application {
    public static void main(String[] args) {
        LibraryMember[] libraryMembers = new LibraryMember[]{
                new LibraryMember("이서현","ees"),
                new StudentMember("학생인데요", "student"),
                new StudentMember("나도 학생", "student2")
        };

        MemberManager memberManager = new MemberManager(libraryMembers);
        memberManager.memberInfo();
    }
}
