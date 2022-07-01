<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生添加页面</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<%--
上传file的form表单要注意
1 method = post才能传输图片
2 entype不能为默认值，设定为multipart/form-data，传输时不会对提交的数据进行编解码
3 上传文件的input控件的type为file
--%>
<body>
	<form action="<%=request.getContextPath()%>/student" method="post" enctype="multipart/form-data">
		<input type="hidden" name="method" value="addStu">
		姓名:<input type="text" name="sname"/><br/><br/>
		性别:男<input type="radio" value="男" name="gender"/>
		          女<input type="radio" value="女" name="gender"/><br/><br/>
		生日:<input class="Wdate" name="sbir" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"><br/><br/>
		爱好:
			抽烟<input type="checkbox" value="抽烟" name="hobby"/>
			喝酒<input type="checkbox" value="喝酒" name="hobby"/>
			rap<input type="checkbox" value="rap" name="hobby"/>
			烫头<input type="checkbox" value="烫头" name="hobby"/><br/><br/>
	             头像:<input type="file" name="file"><br/><br/>
	     <input type="submit" value="添加学生">
	</form>
</body>
</html>