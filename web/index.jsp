<%@ page import="java.util.ResourceBundle" %>
<%@ page import="controller.utils.BundleConstants" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Travelling company</title>
    <link rel="stylesheet" href="style.css">

    <%
      ResourceBundle bundle = ResourceBundle.getBundle("lang_en", new Locale("en", "US"));
    %>

  </head>
  <body>

  <form action="index" method="post">
    <h1 class="greeting"><%=bundle.getString(BundleConstants.WELCOME)%></h1>
    <h2>You can choose your language:</h2>

    <label>
      <span>English</span>
      <input type="radio" name="language" value="en" checked="checked">
    </label>

    <label>
      <span>Русский</span>
      <input type="radio" name="language" value="ru">
    </label>

    <button><%=bundle.getString(BundleConstants.SUBMIT)%></button>
  </form>

  </body>
</html>
