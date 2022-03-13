import java.sql.*;

/**
 * Statement实现
 */
public class StatementDBTool implements DBtoolInterface{
    static String URL = "jdbc:mysql://localhost:3306/db";
    static String DRIVER = "com.mysql.jdbc.Driver";//该驱动已弃用更换至com.mysql.jdbc.driver
    static String USER = "root";
    static String PASSWORD = "root";
    /**
     * 创建数据库连接
     * @return
     * @throws ClassNotFoundException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);

        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    /**
     * 依次关闭数据库资源及连接
     * @param cnn
     * @param st
     * @param rt
     * @throws SQLException
     */
    public void close(Connection cnn, Statement st, ResultSet rt) throws SQLException {
        if(rt != null) rt.close();
        if(st != null) st.close();
        if(cnn != null) cnn.close();

    }

    /**
     * 增删改
     * @param sql
     * @return
     * @throws SQLException
     */
    public int update(String sql) throws SQLException, ClassNotFoundException {
        Connection cnn = getConnection();
        int line = cnn.createStatement().executeUpdate(sql);
        close(cnn,null,null);
        return line;
    }

    /**
     * 查询
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet queryAll(String sql) throws SQLException, ClassNotFoundException {
        Connection cnn = getConnection();
        PreparedStatement pr = cnn.prepareStatement(sql);

        ResultSet rs = pr.executeQuery();//充分利用代码块的生命周期的特点

        return rs;
    }

}
