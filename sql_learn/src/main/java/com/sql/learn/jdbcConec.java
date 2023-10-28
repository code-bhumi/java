package com.sql.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConec {
        public static void main(String[] args)
    {
        String url = "jdbc:postgresql://127.0.0.1:5432/dimple_db";
        String user = "dimple";
        String password = "adwita";
        String SQL_QUERY = "SELECT * FROM cred where scenario = 'zerobalancecard'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(SQL_QUERY)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    WebDriver driver = new ChromeDriver();
                    driver.get("https://login.salesforce.com");
                
                    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
                    driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));                  
                    
                }
                conn.close();
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
