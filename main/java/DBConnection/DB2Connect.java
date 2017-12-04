package DBConnection;

/**
 * Created by THINK on 11/30/2017.
 */


        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.DriverManager;
        import java.sql.Connection;
        import java.sql.SQLException;

public class DB2Connect {
    public static Connection getDB2Connection() throws ClassNotFoundException, SQLException {
        String hostName = "172.16.11.25";
        String sid = "proteldb";
        String userName = "db2inst1";
        String password = "password";

        return getDB2Connection(hostName, sid, userName, password);
    }

    public static Connection getDB2Connection(String hostName, String dbName,
                                              String userName, String password) throws SQLException,
            ClassNotFoundException {

        // Declare the class Driver for MySQL DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.
        Class.forName("com.ibm.db2.jcc.DB2Driver");

        // Cấu trúc URL Connection dành cho Oracle
        // Ví dụ: jdbc:mysql://localhost:3306/simplehr
        String connectionURL = "jdbc:db2://" + hostName + ":50000/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}



// Pure Connection
//public class ProtelDBConnect{
//    public static void main(String[] argv) {
//        try {
//            Class.forName("com.ibm.db2.jcc.DB2Driver");
//
//        }
//        catch (ClassNotFoundException e) {
//            System.out.println("Please include Classpath  Where your DB2 Driver is located");
//            e.printStackTrace();
//            return;
//        }
//        System.out.println("DB2 driver is loaded successfully");
//
//
////        PreparedStatement pstmt = null;
////        ResultSet rset=null;
////        boolean found=false;
//
//
//        String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
//        String url="jdbc:db2://172.16.11.25:50000/proteldb";
//        String user="db2inst1";
//        String password="password";
//
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url,user,password);
//            if (conn != null)
//            {
//                System.out.println("DB2 Database Connected");
//            }
//            else
//            {
//                System.out.println("Db2 connection Failed ");
//            }
////            pstmt=conn.prepareStatement("Select * from bo");
////            rset=pstmt.executeQuery();
////            if(rset!=null)
////            {
////
////                while(rset.next())
////                {
////                    found=true;
////                    System.out.println("Class Code: "+rset.getString("clcode"));
////                    System.out.println("Name: "+rset.getString("name"));
////                }
////            }
////            if (found ==false)
////            {
////                System.out.println("No Information Found");
////            }
//        } catch (SQLException e) {
//            System.out.println("DB2 Database connection Failed");
//            e.printStackTrace();
//            return;
//        }
//    }
//
//}