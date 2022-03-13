import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Realize_Statement {
    /**
     * 添加
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int add(String tableName,Integer id,String name,int age,String sex,String phone) throws SQLException, ClassNotFoundException {
        String sql = "insert into "+ tableName + " values(" + id + ",\'" + name + "\'," +
                age + ",\'" + sex + "\',\'" + phone + "\')";

        return new StatementDBTool().update(sql);
    }

    /**
     * 根据id删除
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int delete(String tableName,int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from "+ tableName + " where id=" + id;

        return new StatementDBTool().update(sql);
    }

    /**
     * 修改(根据id修改)
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
     public int modify(String tableName,String name,int age,String sex,String phone,int id) throws SQLException, ClassNotFoundException {
         String sql = "update " + tableName + " set name=\'" + name + "\',age=" + age +
                 ",sex=\'" + sex + "\',phone=\'" + phone + "\' where id=" + id;
         System.out.println(sql);

         return new StatementDBTool().update(sql);
     }

     /**
     * 查询
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Object> queryAll(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "select * from " + tableName;

        ResultSet rs = new StatementDBTool().queryAll(sql);
        int columnEnd = rs.getMetaData().getColumnCount();

        List<Object> list = new ArrayList<Object>();
        while (rs.next()) {
            for (int i = 0; i < columnEnd; i++) {
                list.add( rs.getObject(i+1) );
                if (i<columnEnd-1) list.add(", ");
            }
            list.add("\n");
        }

        return list;
    }
}
