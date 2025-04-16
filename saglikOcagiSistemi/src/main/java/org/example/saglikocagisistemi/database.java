package org.example.saglikocagisistemi;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class database {
    String url = "jdbc:postgresql://localhost:5432/SaglikOcagiSistemi";
    Connection connection ;
    Statement statement ;
    static int userID;
    public  void connect()  {

        try {

            connection = DriverManager.getConnection(url, "postgres", "382102");
            statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createAccount(
            String fullName ,
            String tc,
            String dob,
            String phoneNumber,
            String gender,
            String password,
            String email
    ){
        String sql = "INSERT INTO hesapOlustur (ad_soyad,tc,dogum_tarih, telefon_no, cinsiyet, sifre, sifre_onay, email)"+
                "VALUES ('%s' , '%s' ,'%s', '%s' ,'%s' ,'%s' ,'%s' ,'%s')"
                        .formatted(
                                fullName,
                                tc,
                                dob,
                                phoneNumber,
                                gender,
                                password,
                                password,
                                email
                        );

        executeQueryDatabase(sql);

    }

    public boolean login(String tc , String password){
        String sql = "SELECT * FROM hesapOlustur WHERE tc = '%s' AND sifre = '%s'"
                .formatted(tc , password);

        try {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                userID = resultSet.getInt("id");
                System.out.println(userID);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map getUserİnfo(){
        String sql = "SELECT * FROM hesapOlustur WHERE id = %d".formatted(userID);
        try {
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            return Map.of(
                    "id", resultSet.getInt("id"),
                    "fullName", resultSet.getString("ad_soyad"),
                    "tc", resultSet.getString("tc"),
                    "dateOfBırth", resultSet.getString("dogum_tarih"),
                    "phone", resultSet.getString("telefon_no"),
                    "email", resultSet.getString("email")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createRandevu(String hastaAdi, String tarih, String saat, String bolum, String doktor){
        String sql = "INSERT INTO randevu1 (hasta_adi, tarih, saat, bolum, doktor ) VALUES ('%s', '%s', '%s' ,'%s' ,'%s')"
                .formatted(hastaAdi, tarih , saat , bolum ,doktor);

        executeQueryDatabase(sql);
    }

    public ArrayList<Map> getDoktor(String bolum){
        String sql = "SELECT * FROM calisangirisi WHERE meslek = '%s'".formatted(bolum);
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList array = new ArrayList<Map>();
            while (resultSet.next()) {
                array.add(
                        Map.of(
                                "name", resultSet.getString("calisan_adi"),
                                "bolum", resultSet.getString("meslek")
                        )
                );

            }
            return array;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Map<String, String>> getRandevular(){
        String sql = "SELECT * FROM randevu1 where hasta_adi = '%s'".formatted(getUserName());

        System.out.println(sql);
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList array = new ArrayList<Map>();
            while (resultSet.next()) {
                Map<String, String> map = new HashMap();

                map.put("hastaAdi", resultSet.getString("hasta_adi"));
                map.put("tarih", resultSet.getString("tarih"));
                map.put("saat", resultSet.getString("saat"));
                map.put("bolum", resultSet.getString("bolum"));
                map.put("doktor", resultSet.getString("doktor"));


                array.add(map);

            }
            for (Object map : array){
                System.out.println(map);
            }
            return array;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserName() {
        String sql = "SELECT * FROM hesapOlustur WHERE id = %d".formatted(userID);

        try {
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            return resultSet.getString("ad_soyad");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void userUpdatePassword(String yeniPassword){
        String sql = "UPDATE hesapOlustur SET sifre_onay = '%s' , sifre = '%s' WHERE id = %d".
                formatted(yeniPassword, yeniPassword, userID);

        executeQueryDatabase(sql);
    }

    //calısan

    public boolean workerLogin(String tc, String password){
        String sql = "SELECT * FROM calisangirisi WHERE tc = '%s' AND sifre = '%s'"
              .formatted(tc, password);

        System.out.println(sql);
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                userID = resultSet.getInt("kullaniciid");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void executeQueryDatabase(String sql){
        try {

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
