<%-- 
    Document   : index
    Created on : 03.07.2014, 17:27:37
    Author     : Vanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="IMGController"
        enctype="multipart/form-data">
        Select file to upload: <input type="file" name="file" size="60" /><br />
        <br /> <input type="submit" value="Upload" />
        </form>
        <form method="post" action="IMGGetController"
        >
            <br /> <input type="submit" name="com" value="givemeimg" />
        </form>
              
    </body>
</html>
