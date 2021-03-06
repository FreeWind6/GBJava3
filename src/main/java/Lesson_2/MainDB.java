package Lesson_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        try {
            connect();

            crateHW("test");

            insertHW("Bob1", 10);
            insertHW("Bob2", 20);
            insertHW("Bob3", 30);

            updateHW("Bob1", 50);

            deleteHW("test", "Bob3");

            selectHW("test");

//            stmt.executeUpdate("INSERT INTO students (name, score) values('Bob1', 10)");
//            Savepoint sp = connection.setSavepoint();
//            stmt.executeUpdate("INSERT INTO students (name, score) values('Bob2', 20)");
//            connection.rollback(sp);
//            connection.setAutoCommit(true);
//            stmt.executeUpdate("INSERT INTO students (name, score) values('Bob3', 30)");

//                readFile();

//            long t = System.currentTimeMillis();
//            connection.setAutoCommit(false);
//            pstmt = connection.prepareStatement("insert into students (name, score) values(?, ?)");
//            for (int i = 0; i < 1000; i++) {
//                pstmt.setString(1, "Bob" + (i + 1));
//                pstmt.setInt(2, 20 * (i + 1));
//                pstmt.addBatch();
//            }
//
//            pstmt.executeBatch();
//            connection.setAutoCommit(true);
//            System.out.println(System.currentTimeMillis() - t);
//            connection.setAutoCommit(false);
//            long t = System.currentTimeMillis();
//            for (int i = 0; i < 1000; i++) {
//                int a = i * 10;
//                stmt.executeUpdate("insert into students (name, score) values ('unknow', " + a +")");
////                if (i%100 == 0) {
////                    connection.commit();
////                }
//            }
//            //connection.commit();
//            connection.setAutoCommit(true);
//            System.out.println(System.currentTimeMillis() - t);

//            ResultSetMetaData rsmd = rs.getMetaData();
//
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i) + " " + rsmd.getTableName(i));
//            }
//
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void crateHW(String tableName) {
        String sql = String.format("CREATE TABLE %s (testID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER)", tableName);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertHW(String name, int score) {
        String sql = String.format("INSERT INTO test (name, score) values('%s', %s)", name, score);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHW(String name, int score) {
        String sql = String.format("UPDATE test set score = %s where name = '%s'", score, name);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteHW(String nameTable, String name) {
        String sql = String.format("DELETE FROM '%s' WHERE name = '%s'", nameTable, name);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectHW(String nameTable) {
        String sql = String.format("SELECT * FROM '%s'", nameTable);
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\123\\update.txt");
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String[] mass = scanner.nextLine().split(" ");
            updateDB(mass[0], mass[1]);
        }
    }

    public static void updateDB(String id, String newVal) {
        String sql = String.format("UPDATE students set score = %s where id = %s", newVal, id);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
