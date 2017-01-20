/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.qmedia.appPrueba.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author test
 */
public class Conectar {
    
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/music_db");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
