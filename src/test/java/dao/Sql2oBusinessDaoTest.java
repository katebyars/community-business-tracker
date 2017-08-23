package dao;

import models.Business;
import org.junit.After;
import org.junit.Before;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

import static org.junit.Assert.*;


public class Sql2oBusinessDaoTest {

    private Connection conn;
    private  Sql2oBusinessDao businessDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        businessDao = new Sql2oBusinessDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }



    //helper
    public Business helperBusiness() {
        return new Business("Gertrude's House of Flamingos", "555-555-1234", "M-F 12-8", "Boutique");
    }
}