package wiki.win.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DruidUtil {
    /**
     *
     * @return DataSource
     */
    public static DataSource getDataSourceByDruid()  {


        InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        DataSource dataSource = null;
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;

    }

    /**
     *
     * @return Connection
     */
    public static Connection createConnectionByDruid()  {

        DataSource dataSource = getDataSourceByDruid();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
