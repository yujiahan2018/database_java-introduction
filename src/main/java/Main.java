import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static String phoneRandom() {
        int[] number = {1,2,3,4,5,6,7,8,9,0};
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        int r = random.nextInt(3);

        while (sb.length() == 0){
            if ((r >= 130 && r <= 199)) {
                sb.append(r);
            } else {
                r = random.nextInt() % 1000;
            }
        }

        while (sb.length()!=11) {
            r = Math.abs(random.nextInt() % 9);
            sb.append(number[r]);
        }

        return sb.toString();
    }

//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        PreparedStatementDBTool dbTool = new PreparedStatementDBTool();
//        Connection cnn = dbTool.getConnection();
//
//        System.out.println(cnn.isClosed());
//        String sqlUpdate = "insert into table1 values(?,?,?,?)";
//
//        dbTool.update(sqlUpdate);
//
//        System.out.println(cnn.isClosed());
//
//        String sqlQuery = "select * from table1";
//        ResultSet rs = dbTool.query(sqlQuery);
//
//        int end = rs.getMetaData().getColumnCount();
//        while (rs.next()) {
//            for (int i = 1; i <= end; i++) {
//                String string = rs.getString(i);
//                System.out.print(string);
//                if (i < end) System.out.print(", ");
//                if (i == end) System.out.println();
//
//            }
//        }
//
//        dbTool.close(cnn);
//    }

//
}
