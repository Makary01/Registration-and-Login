# Registration-and-Login
Simple java registration and login web app with data storage in MySQL database

How to use:

1. Configure database connection in 'src/main/webapp/META-INF/context.xml' and 'src/main/java/utils/DbUtil' files.

2. Use 'database.sql' file from src/main/resources/sql to configure database

3. Default validation is "5 to 16 lowercase letters, numbers, _ and -" for name, and "5 to 20 chars" for password.
If you would like to change it, edit 'src/main/java/utils/RegexUtil' class for server side validation, and 'src/main/webapp/home.jsp' file for client side validation.
