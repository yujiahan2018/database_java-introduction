
/*
 * -----------------------------------------------------------------------------------------------------------------------
 * 版权信息
 * Copyright (c) 2022.
 * Worker:JiahanYu./于家汉
 * Date:2022/2/19 下午3:50
 * 侵权必究
 * -----------------------------------------------------------------------------------------------------------------------
 *
 */

/**
 * 数据库主体逻辑
 */
import java.sql.*;
public class DB_initial {
    /**
     * 基本参数初始化
     */
    //数据库位置
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/" +
            "new_schema?useUnicode=true&characterEncoding=utf-8";
    //数据库账号、密码
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    /**
     * 获取数据库连接
     */
    //Connection对象:连接
    public Connection getconnect() throws ClassNotFoundException, SQLException {

        //创建连接对象
        //DriverManager:用于管理一组 JDBC 驱动程序的基本服务。
        Connection ct = DriverManager.getConnection(URL,USER,PASSWORD);

        return ct;
    }

    /**
     * 关闭数据库连接
     */
    //JDBC是由一系列连接（Connection）、SQL语句（Statement）和结果集（ResultSet）构成的
    public void close(Connection ct, PreparedStatement stmt, ResultSet rs){
        try {
            if (rs!=null && stmt!=null && ct!=null) {//防止抛npe
                rs.close();
                stmt.close();
                ct.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询方法
     */
    public ResultSet inquire(String sql,Object... params){
        Connection ct = null;
        PreparedStatement pst = null;

        try {
            //获取连接对象
            ct = getconnect();

            //执行对象
            pst = ct.prepareStatement(sql);
            if(params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);//参数绑定
                }
            }

            //执行sql语句
            ResultSet rs = pst.executeQuery();
            return rs;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(ct,pst,null);
        }


        return null;
    }

    /**
     * 增删改方法
     */
    public int updata(String sql,Object... params){//考虑为什么是int类型？
        Connection ct = null;
        PreparedStatement ps = null;

        try {
            //连接对象
            ct = getconnect();

            //执行对象
            ps = ct.prepareStatement(sql);

            if (params!=null){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);//参数绑定
                }
            }

            int rs = ps.executeUpdate();

            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(ct,ps,null);
        }

        return 0;
    }

}
