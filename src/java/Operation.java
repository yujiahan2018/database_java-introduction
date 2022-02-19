import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对数据表操作
 */
public class Operation {
    public final DB_initial db = new DB_initial();

    //增
    public int add(String no, String name, String dept, String photo){
        String sql = "insert into new_table (no,name,dept,photo) values(?,?,?,?)";//sql语句
        Object[] params = {no,name,dept,photo};//参数


        return db.updata(sql,params);
    }

    //删（根据id删除）
    public int delete(int id) {
        String sql = "delete from new_table where id=?";//sql
        Object[] params = {id};//params

        return db.updata(sql, params);
    }

    //修改（根据id修改）
    public int amend(int id,String no, String name, String dept, String photo) {
        String sql = "update new_table set no=?,name=?,dept=?,photo=? where id=?";//sql

        Object[] params = {no,name,dept,photo,id,};//params,这里需要注意顺序与参数的一一对应

        return db.updata(sql, params);
    }

    //查
    //查询整体数据（能否考虑list实现）
    public Object[][] inquireAll() throws SQLException {
        String sql = "select * from new_table";//sql语句
        Object[] params = {};//参数

        ResultSet rs = db.inquire(sql,params);

        List list = new ArrayList();
        while (rs.next()) {//遍历数据，每个循环是一组
            Object[] ts = new Object[5];
            ts[0] = rs.getObject("id");
            ts[1] = rs.getObject("no");
            ts[2] = rs.getObject("name");
            ts[3] = rs.getObject("dept");
            ts[4] = rs.getObject("photo");

            list.add(ts);

        }

        Object[][] result = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = (Object[]) list.get(i);
        }

        return result;
    }

}
