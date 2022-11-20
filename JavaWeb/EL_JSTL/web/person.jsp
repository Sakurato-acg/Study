<%@ page import="Bean.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lpl
  Date: 2022/10/28
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person=new Person();
    person.setName("name");
    person.setPhones(new String[]{
            "1","2"
    });
    List<String> cites=new ArrayList<>();
    cites.add("北京");
    cites.add("杭州");

    person.setCites(cites);
    Map<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);

    request.setAttribute("person",person);
%>
输出person：<br>${person}<br>
<hr>
输出name属性:${person.name}<br>
输出phones属性:${person.phones[1]}<br>
输出cites属性:${person.cites[0]}<br>
输出map属性:${person.map[0]}<br>
输出age属性:${person.age}<br>

${ pageContext }
</body>
</html>
