package wiki.win.service;

import wiki.win.dao.Studao;
import wiki.win.pojo.Student;
import wiki.win.util.DruidUtil;
import wiki.win.util.Page;

import java.util.List;

/**
 * 业务逻辑层
 *
 */
public class StudentService {

    private Studao studao = new Studao(DruidUtil.getDataSourceByDruid());

    /**
     * 添加学生数据
     * @param stu
     * @return
     */
    public boolean addStu(Student stu){
        int row = studao.addStu(stu);
        return row > 0;
    }

    /**
     * 获取分页数据
     * @param student
     * @param currentPage
     * @return page
     */
    public Page<Student> queryAllStu(Student student, String currentPage) {

        //1. 根据条件查询符合条件数据总条数
            long countRow = studao.getCountRow(student);
        //2. 处理当前页页码
            int current = 1;
            if(currentPage != null && !"".equals(currentPage)){
                current = Integer.parseInt(currentPage);
            }
        //3. 设置每页显示的条数
            int rowEachPage = 3;
        //4. 获取页面数据
            int startPage = rowEachPage * (current - 1);
            List<Student> studentList = studao.getStudent(student,startPage,rowEachPage);
        //5. 将获取的数据封装为Page 对象
            Page<Student> page = new Page<Student>(rowEachPage, (int) countRow,current,studentList);
        //6. 传递给控制层
            return page;
    }

    public boolean batchDel(String ids) {
        int row = studao.deletById(ids);
        return row > 0 ;
    }
}
