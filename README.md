# Registration-and-Login
Simple java registration and login web app with data storage in MySQL database

If you would like to use it, you have to configure database connection in 'context.xml' and 'DbUtil' files.

Default validation is "5 to 16 lowercase letters, numbers, _ and -" for name and "5 to 20 chars" for password.
If you would like to change it, you have to edit 'RegexUtil' class for server side validation, and 'Home.jsp' file for client side validation
