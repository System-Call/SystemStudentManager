package wiki.win.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import wiki.win.pojo.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Studao {

    private static QueryRunner qr = null;

    public Studao() {
        qr = new QueryRunner();
    }
    public Studao(DataSource dataSource){
        qr = new QueryRunner(dataSource);
    }

    //add
    public int addStu(Student st, Connection cnn){
        String sql = "insert into stu values(0,?,?,?,?,?)";
        int row = 0;
        try {
            row = qr.update(cnn, sql, st.getSname(), st.getGender(), st.getSbir(), st.getHobby(), st.getPhoto());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }
    public int addStu(Student st){
        String sql = "insert into stu values(0,?,?,?,?,?)";
        int row = 0;
        try {
            row = qr.update(sql, st.getSname(), st.getGender(), st.getSbir(), st.getHobby(), st.getPhoto());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public long getCountRow(Student student) {
        StringBuffer sb = new StringBuffer("select count(sid) from stu where 1=1 ");
        condition(student, sb);

        Long row = null;
        try {
            row = qr.query(sb.toString(), new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;

    }

    private void condition(Student student, StringBuffer sb) {
        String sname = student.getSname();
        if(sname != null && !"".equals(sname.trim())){
            sb.append(" and sname like '%"+sname +"%' ");
        }
        String gender = student.getGender();
        if (gender != null && !"-1".equals(gender) && !"".equals(gender) ) {
            sb.append(" and gender = '"+gender+"' ");
        }
    }

    public List<Student> getStudent(Student student, int startPage, int rowEachPage) {
        StringBuffer sb = new StringBuffer("select * from stu where 1=1 ");
        condition(student, sb);
        sb.append(" limit ?,?");
        List<Student> stulist = null;
        try {
            stulist = qr.query(sb.toString(), new BeanListHandler<>(Student.class), startPage, rowEachPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stulist;
    }

    public int deletById(String ids) {
        String sql = "delete from stu where sid in(" + ids + ")";
        int row = 0;
        try {
            row = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    //select

}