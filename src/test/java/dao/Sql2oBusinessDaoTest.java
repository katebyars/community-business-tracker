package dao;

import models.Business;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

    @Test
    public void BusinessInstantiatesCorrectly() throws Exception {
        Business newBusiness = helperBusiness();
        businessDao.add(newBusiness);
        assertTrue(newBusiness instanceof Business);
        assertEquals(1, businessDao.getAll().size());
    }

    @Test
    public void addingSetsKey() throws Exception {
        Business newBusiness = helperBusiness();
        int oldKey = newBusiness.getId();
        businessDao.add(newBusiness);
        assertNotEquals(oldKey, newBusiness.getId());
    }

    @Test
    public void findById(){
        Business newBusiness = helperBusiness();
        businessDao.add(newBusiness);
        Business testBusiness = businessDao.findById(1);
        assertEquals(newBusiness.getName(), testBusiness.getName());
    }

    @Test
    public void getAllReturnsAllBusinesses_True() throws Exception {
        Business newBusiness = helperBusiness();
        Business newBusiness2 = helperBusiness2();
        businessDao.add(newBusiness);
        businessDao.add(newBusiness2);
        assertEquals(2, businessDao.getAll().size());
    }

    @Test
    public void updateChangesNameOfABusiness_True() throws Exception {
        Business newBusiness = helperBusiness();
        Business newBusiness2 = helperBusiness2();
        businessDao.add(newBusiness);
        businessDao.add(newBusiness2);
        businessDao.update("Molly's Museum of Mooses", "Molly" ,"M-F 9-5", "Museum", 1);
        assertEquals("Molly's Museum of Mooses", businessDao.findById(1).getName());
    }

    @Test
    public void deleteByIdDeletesCorrectly_True() throws Exception{
        Business newBusiness = helperBusiness();
        Business newBusiness2 = helperBusiness2();
        businessDao.add(newBusiness);
        businessDao.add(newBusiness2);
        businessDao.deleteById(2);
        assertEquals(1, businessDao.getAll().size());
        assertEquals("Gertrude's House of Flamingos", businessDao.findById(1).getName());

    }

    //helper
    public Business helperBusiness() {
        return new Business("Gertrude's House of Flamingos", "555-555-1234", "M-F 12-8", "Boutique");
    }

    //helper2
    public Business helperBusiness2() {
        return new Business("Pete's Dragons of Mystical Thrill", "555-555-1234", "M-F 12-8", "Boutique");
    }
}