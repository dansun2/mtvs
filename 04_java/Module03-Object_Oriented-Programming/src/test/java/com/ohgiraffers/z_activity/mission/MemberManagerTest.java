package com.ohgiraffers.z_activity.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberManagerTest {
    private MemberManager memberManager;
    private LibraryMember[] libraryMembers;

    @BeforeEach
    void setUp() {
        libraryMembers = new LibraryMember[]{
                new LibraryMember("이서현","ees"),
                new StudentMember("학생인데요", "student"),
                new StudentMember("나도 학생", "student2")
        };
        memberManager = new MemberManager(libraryMembers);
    }

    @Test
    void testMemberManager() {
        LibraryMember[] result = memberManager.memberInfo();

        Assertions.assertArrayEquals(libraryMembers, result);

        Assertions.assertTrue(Arrays.asList(result).contains(new LibraryMember("이서현", "ees")));
    }

}