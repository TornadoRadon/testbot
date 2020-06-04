package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        //        Задаем параметры подключения: URL, имя пользователя и пароль
        String url = "jdbc:mysql://localhost:3306";
        String userName = "root";
        String password = "";

//        Регистриуем драйвер с помощью статического инициализатора
        Class.forName("com.mysql.jdbc.Driver");

//        Создаем подключение, передавая в getConnection() параметры
        try(Connection conn = DriverManager.getConnection(url, userName, password)) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM testDB.MOCK_DATA");
            rs.next();
            int i = rs.getInt("id");
            String s = rs.getString("name");

            System.out.println(" id : " + i + " Name : " + s);

            rs.next();


            int x = 0;
            while (rs.next()){
                i = rs.getInt("xd");
                s = rs.getString("name");
                System.out.println(" id : " + i + " Name : " + s);
                x++;
                if(x == 50){
                    break;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
