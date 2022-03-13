import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DBtoolInterface {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    public void close(Connection cnn, Statement st, ResultSet rt) throws SQLException;

}
