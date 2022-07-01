package wiki.win.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
//日期工具类
    public static Date paseToDate(String sbir) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(sbir);
        } catch (ParseException e) {
            System.out.println("日期格式错误");
            e.printStackTrace();
        }
        return date;
    }
}
