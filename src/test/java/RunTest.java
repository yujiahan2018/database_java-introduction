import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

public class RunTest {
    @Test
    public void test1(){
        try {
            Realize_Statement rs = new Realize_Statement();
            String tableName = "table1";

            rs.add(tableName,null,"KADSK",11,"男","12345678901");
            rs.delete(tableName,4);
            rs.modify(tableName,"aaaaa",12,"女","11111111111",3);
            List<Object> l = rs.queryAll(tableName);
            for (int i = 0; i < l.size();i++) {
                System.out.print(l.get(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws SQLException, ClassNotFoundException {
        Realize_PreparedStatement rps = new Realize_PreparedStatement();


        rps.add(null,"KADSK",11,"男","12345678901");
        rps.delete(4);
        rps.modify("aaaaa",12,"女","11111111111",3);
        List<Object> l = rps.queryAll();
        for (int i = 0; i < l.size();i++) {
            System.out.print(l.get(i));
        }
    }

    @Test
    public void paramRandom() throws SQLException, ClassNotFoundException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10;i++){//控制行,每10行一组
            int age = new Random().nextInt(100);
            String phone = Main.phoneRandom();
            String name = RandomStringUtils.randomAlphabetic(20);

            int generate = new Random().nextInt(2);//依据奇偶性生成男女
            String sex = null;

            if (generate % 2 == 0) sex = "男生";
            else sex = "女生";


            new Realize_PreparedStatement().add(null,name,age,sex,phone);

        }

        List<Object> l = new Realize_PreparedStatement().queryAll();
        for (int i = 0; i <l.size(); i++) {
            System.out.print(l.get(i));

        }
    }



}
