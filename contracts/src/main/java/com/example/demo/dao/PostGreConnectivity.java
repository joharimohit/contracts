package com.example.demo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PostGreConnectivity {


        public static void main(String args[]) {
            Connection connection = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager
                        .getConnection("jdbc:postgresql://43.205.203.68:5432/testdb",
                                "administrator", "");
                System.out.println("Opened database successfully");

                /* to create a table in post gre*/
                Statement createStatement = connection.createStatement();
                String sql = "CREATE TABLE COMPANY " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " +
                        " AGE            INT     NOT NULL, " +
                        " ADDRESS        CHAR(50), " +
                        " SALARY         REAL)";
                createStatement.executeUpdate(sql);
                createStatement.close();

                //insert queries
                Statement insertStatement = connection.createStatement();
                String sqlInsert = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                        + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
                insertStatement.executeUpdate(sqlInsert);

                sqlInsert = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                        + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
                insertStatement.executeUpdate(sqlInsert);

                sqlInsert = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                        + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
                insertStatement.executeUpdate(sqlInsert);

                sqlInsert = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                        + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
                insertStatement.executeUpdate(sqlInsert);

                insertStatement.close();
                connection.commit();
                connection.close();
            } catch (Exception e) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
            System.out.println("Records created successfully");
        }
}
