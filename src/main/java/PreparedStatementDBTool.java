import java.sql.*;

public class PreparedStatementDBTool implements DBtoolInterface{
    static String URL = "jdbc:mysql://localhost:3306/db";
    static String DRIVER = "com.mysql.jdbc.Driver";//该驱动已弃用更换至com.mysql.jdbc.driver
    static String USER = "root";
    static String PASSWORD = "root";
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    @Override
    public void close(Connection cnn, Statement st, ResultSet rt) throws SQLException {
        if (rt != null) rt.close();
        if (st != null) st.close();
        if (cnn != null) cnn.close();
    }


    public int update(String sql,Object ... params) throws SQLException, ClassNotFoundException {//
        Connection cnn = getConnection();
        PreparedStatement pr = cnn.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            pr.setObject(i+1, params[i]);
        }

        int line = pr.executeUpdate();

        close(cnn,pr,null);

        return line;
    }

    public ResultSet queryAll(String sql) throws SQLException, ClassNotFoundException {

        Connection cnn = getConnection();
        PreparedStatement pr = cnn.prepareStatement(sql);

        ResultSet rs = pr.executeQuery();//充分利用代码块的生命周期的特点
        return rs;
    }
}
