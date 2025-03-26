package com.ohgiraffers.jdbc.dao;

import com.ohgiraffers.jdbc.config.JDBCConnection;
import com.ohgiraffers.jdbc.model.User;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 📌 UserDao JUnit 테스트 코드
 * - 데이터베이스 연동 테스트
 * - AAA 패턴 적용 (Arrange, Act, Assert)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 클래스 단위로 인스턴스 유지
class UserDaoTest {
    private Connection connection;
    private UserDao userDao;
    private static final String TEST_USERNAME = "test_user";
    private static final String TEST_EMAIL = "test@example.com";
    private static final String TEST_PASSWORD = "testpassword";
    private static final int TEST_ROLE_ID = 1;
    private int testUserId;


    /**
     * 📌 테스트 전 DB 연결 및 트랜잭션 설정
     */
    @BeforeEach
    void setUp() {
        try {
            connection = JDBCConnection.getConnection();
            connection.setAutoCommit(false); // 테스트 후 롤백을 위해 AutoCommit 비활성화
            userDao = new UserDao(connection);

            // Arrange: 테스트 데이터 삽입
            User testUser = new User(0, TEST_USERNAME, TEST_EMAIL, TEST_PASSWORD, TEST_ROLE_ID, null);
            userDao.addUser(testUser);

            // 삽입된 데이터 확인 (테스트용 ID 저장)
            List<User> users = userDao.getAllUsers();
            // 마지막 사용자를 조회함.
            testUserId = users.get(users.size() - 1).getUserId();

        } catch (SQLException e) {
            throw new RuntimeException("테스트 데이터 준비 중 오류 발생: " + e.getMessage());
        }
    }

    /**
     * 📌 사용자 목록 조회 테스트 (READ)
     */
    @Test
    @DisplayName("모든 사용자 조회 테스트")
    void testGetAllUsers() {
        // Act: DAO를 통해 데이터 조회
        List<User> users = userDao.getAllUsers();

        // Assert: 결과 검증
        Assertions.assertNotNull(users, "사용자 목록은 null이 아니어야 합니다.");
        Assertions.assertFalse(users.isEmpty(), "사용자 목록은 비어 있지 않아야 합니다.");
    }

    /**
     * 📌 단일 사용자 조회 테스트 (READ)
     */
    @Test
    @DisplayName("특정 사용자 조회 테스트")
    void testGetUserById() {
        // Act: 특정 사용자 조회
        User retrievedUser = userDao.getUserById(testUserId);

        // Assert: 조회된 값 검증
        Assertions.assertNotNull(retrievedUser, "사용자가 존재해야 합니다.");
        Assertions.assertEquals(TEST_USERNAME, retrievedUser.getUserName(), "사용자 이름이 일치해야 합니다.");
        Assertions.assertEquals(TEST_EMAIL, retrievedUser.getEmail(), "이메일이 일치해야 합니다.");
    }

    /**
     * 📌 사용자 추가 테스트 (CREATE)
     */
    @Test
    @DisplayName("사용자 추가 테스트")
    void testAddUser() {
        // Arrange: 새로운 사용자 객체 생성
        User newUser = new User(0, "new_user", "newuser@example.com", "newpassword", TEST_ROLE_ID, null);

        // Act: 사용자 추가
        boolean isAdded = userDao.addUser(newUser);

        // Assert: 추가 확인
        Assertions.assertTrue(isAdded, "사용자가 성공적으로 추가되어야 합니다.");
    }

    /**
     * 📌 사용자 수정 테스트 (UPDATE)
     */
    @Test
    @DisplayName("사용자 정보 수정 테스트")
    void testUpdateUser() {
        // Arrange: 기존 사용자 정보 변경
        User updatedUser = new User(testUserId, "updated_user", "updated@example.com", "updatedpassword", TEST_ROLE_ID, null);

        // Act: 사용자 정보 업데이트
        boolean isUpdated = userDao.updateUser(updatedUser);

        // Assert: 업데이트 결과 확인
        Assertions.assertTrue(isUpdated, "사용자 정보가 성공적으로 수정되어야 합니다.");

        // 업데이트된 데이터 조회 후 검증
        User retrievedUser = userDao.getUserById(testUserId);
        Assertions.assertEquals("updated_user", retrievedUser.getUserName(), "수정된 이름이 일치해야 합니다.");
        Assertions.assertEquals("updated@example.com", retrievedUser.getEmail(), "수정된 이메일이 일치해야 합니다.");
    }

    /**
     * 📌 사용자 삭제 테스트 (DELETE)
     */
    @Test
    @DisplayName("사용자 삭제 테스트")
    void testDeleteUser() {
        // Act: 사용자 삭제
        boolean isDeleted = userDao.deleteUser(testUserId);

        // Assert: 삭제 결과 확인
        Assertions.assertTrue(isDeleted, "사용자가 성공적으로 삭제되어야 합니다.");

        // 삭제 후 다시 조회하면 null이 되어야 함
        User retrievedUser = userDao.getUserById(testUserId);
        Assertions.assertNull(retrievedUser, "삭제된 사용자는 조회되지 않아야 합니다.");
    }

    /**
     * 📌 테스트 완료 후 롤백 (데이터 원상 복구)
     */
    @AfterEach
    void tearDown() {
        try {
            connection.rollback(); // 테스트 데이터 롤백
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("테스트 완료: 데이터 롤백 성공");
        } catch (SQLException e) {
            System.err.println("테스트 종료 중 오류 발생: " + e.getMessage());
        }
    }
}