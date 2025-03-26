package com.ohgiraffers.jdbc.dao;

import com.ohgiraffers.jdbc.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {
    private final Connection connection;

    public RoleDAO(Connection connection) {
        this.connection = connection;
    }

    public Role getRoleById(int roleId){
        // ?는 인덱스를 의미
        String query = "SELECT * FROM roles WHERE role_id = ?"; // "\'"+String+"\'" 문자열을 이렇게 쓰면 복잡해서 PreparedStatement이걸 씀

        Role role = null;

        /*
        * PreparedStatement
        * - JDBC API의 일부로, SQL 쿼리를 실행하는데 사용된다.
        * - Statement와 달리 매개변수화된 쿼리를 사용할 수 있다.
        * */

        // query 변수에 있는걸 전달해서 객체 생성.
        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, roleId); // 인덱스는 물음표의 위치, 값(roleId)은 인덱스에 매핑시킬 값

            // resultSet은 반환받은 객체를 저장함
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    role = new Role(
                            rs.getInt("role_id"),
                            rs.getString("role_name")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("getRoleById() 실행 중 오류 발생");
            e.printStackTrace();
        }

        return role;
    }
}
