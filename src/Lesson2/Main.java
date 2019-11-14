package Lesson2;
import java.sql.*;

public class Main {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException {

        try {
            connection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //работа с БД

//        execute()
//        executeQuery() - SELECT
//        executeUpdate() - UPDATE, DELETE, INSERT

//        ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE age = 22; DROP TABLE students;");


   /*     while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("age"));
        }*/

//    ResultSetMetaData rsmd = rs.getMetaData();
//    for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
//        System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i));
//    }

//    stmt.executeUpdate("UPDATE students set age = 27 WHERE age = 22");

//    stmt.executeUpdate("DROP TABLE IF EXIST students");

/*        long t = System.currentTimeMillis();

        conn.setAutoCommit(false);
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 100; i++) {
                stmt.addBatch("INSERT  INTO students (name, age) VALUES ('students №" + i + "', " + i + ")");
            }

        }
        stmt.executeBatch();
        conn.commit();
        conn.setAutoCommit(false);
        System.out.println(System.currentTimeMillis() - t);*/

    pstmt = conn.prepareStatement("INSERT INTO students (name, age) VALUES (?, ?)");

for (int i = 0; i < 10; i++) {
    pstmt.setString(1, "STUDENT" + i);
    pstmt.setInt(2, i);

    pstmt.addBatch();
}

pstmt.executeBatch();

        disconect();
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = conn.createStatement();
    }

    public static void disconect() throws SQLException {
        conn.close();
    }
}
