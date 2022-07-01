<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		td{
			text-align: center;
			width: 125px;
		}
		.c2{
			margin-left: 40px;
			margin-bottom: 40px;
		}
	</style>
	<script src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function () {
			/*全选和全不选*/
			$("#checkAll").click(function () {
				var che = $("#checkAll").prop("checked");
				$(".check").prop("checked",che);
			})
			/*确认删除*/
			$("#batchDel").click(function () {

				var bo = confirm("确定删除");
				if(bo){
					var checks = $(".check:checked");//属性选择器 匹配所有选中的被选中元素(复选框、单选框等，不包括select中的option)
					if(undefined || checks.length == 0){
						alert("请选择要删除的学生")
						return;
					}
					var ids = "";
					checks.each(function (index,ele) {
						ids += "," + $(ele).val();
					})
					console.log(ids);
					var id = ids.substring(1);
					location.href = "student?method=batchDel&ids=" + id;
				}
			});

		})
	   
	</script>
</head>
<body>
<input type="hidden" name="method" value="queryAllStu">
	<br/>
	<center>
		<form action="<%=request.getContextPath()%>/student" method="get">
			<input type="hidden" name="method" value="queryAllStu">
			姓名<input name="sname" value="${student.sname}"/>&nbsp;&nbsp;&nbsp;
			性别
			<select name="gender">
				<option value="-1">请选择</option>
				<option value="男" <c:if test="${student.gender == '男'}">selected</c:if>>男</option>
				<option value="女" <c:if test="${student.gender == '女'}">selected</c:if>>女</option>
			</select>&nbsp;&nbsp;&nbsp;
			<input type="submit" value="查询"/>
		</form>
	<br/>
	</center><br/>
	<input type="button" id="batchDel" value="批量删除" style="margin-left: 150px"/>
	<br/>
	<table border="1px" width="80%" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<th><input type="checkbox" id="checkAll" />全选/全不选</th>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>爱好</th>
			<th>头像</th>
			<th>操作</th>
		</tr>
		<!-- 遍历学生的信息 -->
		<c:forEach items="${page.pageList}" var="stu">
			<tr>
				<td><input type="checkbox" class="check" value = "${stu.sid}" /></td>
				<td>${stu.sid}</td>
				<td>${stu.sname}</td>
				<td>${stu.gender}</td>
				<td><fmt:formatDate value="${stu.sbir}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>${stu.hobby}</td>
				<td>
					<img src="/img/${stu.photo}" alt="" width="60px" height="40px">
				</td>
				<td>
					<a href="student?method=updateJsp&sid=${stu.sid}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	<center>
		<a href="student?method=queryAllStu&currentPage=1&sname=${student.sname}&gender=${student.gender}" class="c2">首页</a>
		<a href="student?method=queryAllStu&currentPage=${page.prePage}&sname=${student.sname}&gender=${student.gender}" class="c2">上一页</a>
		<a href="student?method=queryAllStu&currentPage=${page.nextPage}&sname=${student.sname}&gender=${student.gender}" class="c2">下一页</a>
		<a href="student?method=queryAllStu&currentPage=${page.countPage}&sname=${student.sname}&gender=${student.gender}" class="c2">尾页</a>
		<span class="c2">当前页码<input size="4" value="${page.currentPage}"></span>
		<span class="c2">总记录数<input size="4" value="${page.countRow}"></span>
	</center>
</body>
</html>