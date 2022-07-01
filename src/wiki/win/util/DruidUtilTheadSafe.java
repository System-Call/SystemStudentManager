package wiki.win.util;

import org.junit.Test;

import java.sql.Connection;

public class DruidUtilTheadSafe {

    /**
     * 本地线程
     */
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /**
     *
     * @return a Thead safe Connection
     */
    public static Connection createConnectionByDruid() {
        Connection con = tl.get();
        if (con == null){
            Connection connection = DruidUtil.createConnectionByDruid();
            tl.set(connection);
            con = tl.get();
        }
        return con;
    }

}
