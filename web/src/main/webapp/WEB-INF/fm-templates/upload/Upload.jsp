<%@ page language="java" contentType="text/html; ISO-8859-1; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload</title>
</head>

<body>
<div>FileUpload</div>
<form method="post" action="uploadFile" enctype="multipart/form-data">
    Choose a file: <input type="file" name="uploadFile"/><input type="submit" value="Upload"/>
</form>

</br>

<div>Multipart</div>
<form method="post" action="multiPartServlet" enctype="multipart/form-data">
    Choose a file: <input type="file" name="multiPartServlet"/><input type="submit" value="Upload"/>
</form>
</body>
</html>