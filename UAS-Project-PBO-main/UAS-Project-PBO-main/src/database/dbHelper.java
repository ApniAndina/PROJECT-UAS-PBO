package database;

import java.sql.*;

public class dbHelper {
    Connection con = null;
    
    public Connection getConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Apni\\SqliteDb\\dbkoperasi.sqlite");
            System.out.println("Success!");
            
            return con;
        }catch(Exception e){
            System.out.println("Connection Failed : " + e);
            
            return null;
        }
    }
    
    public void createTable(){
        Connection con = getConnection();
        PreparedStatement state = null;
        
        String query;

        try{
            // Create table nasabah
            query = "CREATE TABLE IF NOT EXISTS nasabah (\n" +
                       "    id     INT (10)      PRIMARY KEY\n" +
                       "                          NOT NULL,\n" +
                       "    name    VARCHAR (50) NOT NULL,\n" +
                       "    address VARCHAR (100) NOT NULL\n" +
                       ");";
            
            state = con.prepareStatement(query);
            state.execute();
            
            // Create table individu
            query = "CREATE TABLE IF NOT EXISTS individu (\n" +
                    "    id      INT (10)               PRIMARY KEY\n" +
                    "                            REFERENCES nasabah (id) ON DELETE RESTRICT\n" +
                    "                                                    ON UPDATE CASCADE,\n" +
                    "    nik  INT (16) NOT NULL,\n" +
                    "    npwp INT (15) NOT NULL\n" +
                    ");";
            
            state = con.prepareStatement(query);
            state.execute();
            
            // Create table perusahaan
            query = "CREATE TABLE IF NOT EXISTS perusahaan (\n" +
                    "    id    INT (10)              PRIMARY KEY\n" +
                    "                          REFERENCES nasabah (id) ON DELETE RESTRICT\n" +
                    "                                                  ON UPDATE CASCADE,\n" +
                    "    nib VARCHAR (13) NOT NULL\n" +
                    ");";
            
            state = con.prepareStatement(query);
            state.execute();
            
            // Create table rekening
            query = "CREATE TABLE IF NOT EXISTS rekening (\n" +
                    "    no_rekening INT (10) PRIMARY KEY\n" +
                    "                        NOT NULL,\n" +
                    "    Saldo       DOUBLE (16,2)  NOT NULL,\n" +
                    "    id  INT (10)    REFERENCES nasabah (id) ON DELETE RESTRICT\n" +
                    "                                                ON UPDATE CASCADE\n" +
                    ");";
            
            state = con.prepareStatement(query);
            state.execute();
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}
