package com.sql.learn;

import java.sql.*;

public class School {
    String url = "jdbc:postgresql://127.0.0.1:5432/dimple_db";
    String user = "dimple";
    String password = "adwita";

    public void List() {
        String SQL_QUERY = "SELECT * FROM school";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    long roll_no = resultSet.getLong("roll_no");
                    String name = resultSet.getString("NAME");
                    long eng = resultSet.getLong("eng");
                    long hin = resultSet.getLong("hin");
                    long mat = resultSet.getLong("mat");
                    long sci = resultSet.getLong("sci");
                    long sst = resultSet.getLong("sst");

                    System.out.println(roll_no + " | " + name + " | " + eng + " | " + hin + " | " + mat + " | " + sci + " | " + sst);
                }
                conn.close();
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void Insert(long roll_no, String name, long eng, long hin, long mat, long sci, long sst) {  
        String SQL_QUERY =  "INSERT INTO school (roll_no, name, eng, hin, mat, sci, sst) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY)) {
                preparedStatement.setLong(1, roll_no);
                preparedStatement.setString(2, name);
                preparedStatement.setLong(3, eng);
                preparedStatement.setLong(4, hin);
                preparedStatement.setLong(5, mat);
                preparedStatement.setLong(6, sci);
                preparedStatement.setLong(7, sst);
                int row = preparedStatement.executeUpdate();
                System.out.println("Rows inserted into database == " + row);
                conn.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }              
    }

    public void Modify(Integer roll_no, String new_name) {
        String SQL_QUERY = "UPDATE school SET name = '" + new_name + "' WHERE roll_no = " + roll_no+";";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    long roll = resultSet.getLong("roll_no");
                    String name = resultSet.getString("NAME");
                    long eng = resultSet.getLong("eng");
                    long hin = resultSet.getLong("hin");
                    long mat = resultSet.getLong("mat");
                    long sci = resultSet.getLong("sci");
                    long sst = resultSet.getLong("sst");

                    System.out.println(roll + " | " + name + " | " + eng + " | " + hin + " | " + mat + " | " + sci + " | " + sst);
                }
                conn.close();
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
    }
}