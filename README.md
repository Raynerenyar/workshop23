# Workshop23

## Objective
State workshop objectives is to insert a record into a table with foreign key constraints. The workshop will also use joins to retrieve various management reports.

## Setup
1. Ensure that you have Northwind database installed in your MySQL server. Create a separate database user for accessing Northwind. Do not use MySQL root user.
2. Generate a SpringBoot application and include the following dependencies:
    * SpringBoot Dev Tools
    * Spring Web
    * Thymeleaf
    * JDBC API
    * MySQL


3. Add .env with the following contents
    - ### For localhost development
        ```
        MYSQLUSER=<user>
        MYSQLPASSWORD=<password>
        MYSQLDATABASE=
        MYSQLHOST=
        MYSQLPORT=
        MYSQL_URL=jdbc:mysql://localhost/<schema name>
        ```
    - ### For deploying to Railway MySQL and using root user
        `MYSQLUSER=root` if using root user.

        Spring runs `MySqlConfig.java` and pulls railway's environment variables to connect to railway's MySQL.

    - ### For deploying to Railway MySQL and using new user
        #### share these variables to railway
        ```
        MYSQLUSER=<user>
        MYSQLPASSWORD=<password>
        ```

4. Create database and tables with:

    [Northwind Database (src/main/java/sg/edu/nus/iss/app/workshop23/mywind_database)](src/main/java/sg/edu/nus/iss/app/workshop23/mywind_database)

    [DDL - create tables](src/main/java/sg/edu/nus/iss/app/workshop23/mywind_database/northwind.sql)

    [DDL - insert data](src/main/java/sg/edu/nus/iss/app/workshop23/mywind_database/northwind-data.sql)