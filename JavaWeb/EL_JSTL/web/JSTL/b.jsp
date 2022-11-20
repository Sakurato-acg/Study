<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/10/28
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        div{
            width: 20%;
            height: 30px;
            margin: 20px  auto;
            background-color: coral;
        }
        table{
            margin: 40px auto;
            border: 1px red solid;
            border-collapse: collapse;
        }
        td{
            border: 1px green solid;
            font-size: 30px;
            width: 50px;
        }
    </style>
</head>
<body>
<%--< c:forEach >遍历循环--%>
<%--var表示循环变量--%>
<table >
    <tr>
        <c:forEach begin="1" end="10" var="index">
            <td>${index}</td>
        </c:forEach>
    </tr>
</table>
<hr>
<%
    request.setAttribute("arr",
            new String[]{"11","22","33"});
%>
<table>
    <tr>
       <c:forEach items="${requestScope.arr}" var="index">
           <td>${index}</td>
       </c:forEach>
    </tr>
</table>
<hr>
<%--遍历Map--%>
<%
        Map<String,String> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
//        for (Map.Entry<String,String> entry:map.entrySet()){
//
//        }
        request.setAttribute("map",map);
%>
<c:forEach items="${map}" var="entry">
    <div>${entry.key}</div>
</c:forEach>
<hr>
<%--遍历List--%>
<%!
    @SuppressWarnings("all")
   public class Student{
        private int id;
        private String username;
        private String password;
        private int age;

        public Student(int id, String username, String password, int age) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", age=" + age +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
%>
<%
    List<Student> list=new ArrayList<>();
    list.add(new Student(1,"u1","p1",11));
    list.add(new Student(2,"u2","p2",12));
    list.add(new Student(3,"u3","p3",13));
    list.add(new Student(4,"u4","p4",14));
    request.setAttribute("list",list);
%>
<table>
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>年龄</th>
    </tr>
<%--
    items 表示遍历的集合
    var   表示遍历的数据
    begin 表示遍历的开始索引值
    end   表示遍历的结束索引值
    step  表示遍历的步长
    varStatus 表示遍历到的数据的状态
    for(int var=begin;var<end;var+=step){

    }

--%>
<c:forEach begin="2" end="2" step="1" varStatus="status" items="${list}" var="index">
    <tr>
        <td>${index.id}</td>
        <td>${index.username}</td>
        <td>${index.password}</td>
        <td>${index.age}</td>
        <td>${status.current}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
