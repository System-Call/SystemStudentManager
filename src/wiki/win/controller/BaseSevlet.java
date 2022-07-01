package wiki.win.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseSevlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        //通过反射调用方法
        if(method != null){
            Class<? extends BaseSevlet> aClass = this.getClass();
            try {
                Method meth = aClass.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                meth.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
