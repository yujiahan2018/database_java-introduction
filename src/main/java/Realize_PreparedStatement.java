import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Realize_PreparedStatement {

    /**
     * 添加
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int add(Integer id,String name,int age,String sex,String phone) throws SQLException, ClassNotFoundException {
        String sql = "insert into table1 values(?,?,?,?,?)";
        Object[] param ={id,name,age,sex,phone} ;

        return new PreparedStatementDBTool().update(sql,param);
    }

    /**
     * 根据id删除
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from table1 where id=?";
        Object[] param = {id};

        return new PreparedStatementDBTool().update(sql,param);
    }

    /**
     * 修改(根据id修改)
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
     public int modify(String name,int age,String sex,String phone,int id) throws SQLException, ClassNotFoundException {
         String sql = "update table1 set name=?,age=?,sex=?,phone=? where id=?";
         Object[] params = {name,age,sex,phone,id,};

         return new PreparedStatementDBTool().update(sql,params);
     }

     /**
     * 查询
     * @param
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Object> queryAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from table1";

        ResultSet rs = new PreparedStatementDBTool().queryAll(sql);
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
