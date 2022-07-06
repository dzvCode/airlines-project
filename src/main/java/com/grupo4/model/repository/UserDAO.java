package com.grupo4.model.repository;

import com.grupo4.model.conn.DBConnection;
import com.grupo4.model.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class UserDAO extends DBConnection {
    public boolean register(User usuario) {
        PreparedStatement ps = null;
        Connection conn = createConnection();
        String sql = "INSERT INTO users (name, email, phone, address, password) VALUES(?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getName());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPhone());
            ps.setString(4, usuario.getAddress());
            ps.setString(5, usuario.getPassword());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modify(User usuario) {
        PreparedStatement ps = null;
        Connection conn = createConnection();
        //String sql = "UPDATE users SET name=?, email=?, phone=?, address=?, password=? WHERE phone=?";
        String sql = "UPDATE users SET name=?, email=?, address=?, password=? WHERE phone=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getName());
            ps.setString(2, usuario.getEmail());
            //ps.setString(3, usuario.getPhone());
            ps.setString(3, usuario.getAddress());
            ps.setString(4, usuario.getPassword());
            //ps.setInt(6, usuario.getId());
            ps.setString(5, usuario.getPhone());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean delete(User usuario) {
        PreparedStatement ps = null;
        Connection conn = createConnection();
//        String sql = "DELETE FROM users WHERE id=?";
        String sql = "DELETE FROM users WHERE phone=?";

        try {
            ps = conn.prepareStatement(sql);
           // ps.setInt(1, usuario.getId());
            ps.setString(1, usuario.getPhone());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean read(User usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = createConnection();
        String sql = "SELECT * FROM users WHERE phone=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getPhone());
            rs = ps.executeQuery();

            if (rs.next()) {
                //usuario.setId(Integer.parseInt(rs.getString("id")));
                usuario.setName(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPhone(rs.getString("phone"));
                usuario.setAddress(rs.getString("address"));
                usuario.setPassword(rs.getString("password"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
