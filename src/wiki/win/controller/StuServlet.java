package wiki.win.controller;

import wiki.win.pojo.Student;
import wiki.win.service.StudentService;
import wiki.win.util.DataUtil;
import wiki.win.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@MultipartConfig
@WebServlet(value = "/student")
public class StuServlet extends BaseSevlet {

    public void addStu(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String sbir = req.getParameter("sbir");
        String[] hobby = req.getParameterValues("hobby");
        Part part = req.getPart("file");

        String filename = part.getSubmittedFileName();
        String name = null;
        if (!"".equals(filename)) {
            //拼接为不重复的文件名称
            String uuid = UUID.randomUUID().toString();
            name = uuid.concat(filename);
            //指定文件上传的磁盘路径,File.separator是磁盘分隔符
            String path = "E:\\javacode\\JDBC\\SystemStudentManager\\img" + File.separator + name;
            //将文件上传到磁盘
            part.write(path);
        }

        //交给业务逻辑层
        Student student = new Student(sname, gender, DataUtil.paseToDate(sbir), Arrays.toString(hobby), name);

        StudentService studentService = new StudentService();
        boolean b = studentService.addStu(student);
        if (b) {
            resp.sendRedirect("student?method=queryAllStu");
        }else {
            resp.sendRedirect("page/adderror.jsp");
        }
    }

    public void queryAllStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取查询条件， 获取当前页码，// 根据返回Page结果，将数据传递给查询页面；
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String currentPage = req.getParameter("currentPage");
        //封装数据，
        Student student = new Student(sname, gender);
        //交给业务逻辑层，得到Page对象
        StudentService studentService = new StudentService();
        Page<Student> page = studentService.queryAllStu(student,currentPage);
        // 根据返回Page结果，将数据传递给查询页面；
            //反显查询条件
        req.setAttribute("student", student);
            //传递分页数据
        req.setAttribute("page", page);
            //控制跳转
        req.getRequestDispatcher("page/queryStu.jsp").forward(req, resp);

    }

    public void batchDel(HttpServletRequest req,HttpServletResponse resp) throws IOException {

        String ids = req.getParameter("ids");
        StudentService studentService = new StudentService();
        boolean b = studentService.batchDel(ids);

        resp.sendRedirect("student?method=queryAllStu");
    }
}
