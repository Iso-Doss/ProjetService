/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.repositories.*;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class ObjectifTest {

    private ObjectifRepository derby = new ObjectifRepository("com.bootcamp_TpJPA");
    private ObjectifRepository mysql = new ObjectifRepository("tpJpa");
    private ObjectifRepository derbyService = new ObjectifRepository("tpservice-derby");
    private ObjectifRepository mysqlService = new ObjectifRepository("tpservice-mysql");

    /**
     * Méthode pour creer un objectif en mysql
     *
     * @throws SQLException
     */
    @Test
    public void createObjectifMySql() throws SQLException {
        List<Objectif> objectifs = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Objectif objectif = new Objectif();
            objectif.setNom(nom[i]);
            objectif.setDescription("description");
            objectifs.add(objectif);
        }

        for (Object element : objectifs) {
            getMysql().create((Objectif) element);
        }

    }

    /**
     * Méthode pour creer un objectif en derby
     *
     * @throws SQLException
     */
    @Test
    public void createObjectifDerby() throws SQLException {
        List<Objectif> objectifs = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Objectif objectif = new Objectif();
            objectif.setNom(nom[i]);
            objectif.setDescription("description");
            objectifs.add(objectif);
        }

        for (Object element : objectifs) {
            derby.create((Objectif) element);
        }
    }

    /**
     * Méthode pour lire tous les objectif en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readAllObjectifMySql() throws SQLException {
        getMysql().findAll();

    }

    /**
     * Méthode pour lire tous les objectif en derby
     *
     * @throws SQLException
     */
    @Test
    public void readAllObjectifDerby() throws SQLException {
        derby.findAll();
    }

    /**
     * Méthode pour lire un objectif en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readObjectifMySql() throws SQLException {
        getMysql().findByProperty("nom", "social");

    }

    /**
     * Méthode pour lire tous les objectif en derby
     *
     * @throws SQLException
     */
    @Test
    public void readObjectifDerby() throws SQLException {
        derby.findByProperty("nom", "social");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateObjectifMySql() throws SQLException {
        Objectif objectif = getMysql().findByProperty("nom", "social");
        objectif.setNom("soc");
        getMysql().update(objectif);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateeObjectifDerby() throws SQLException {
        Objectif objectif = derby.findByProperty("nom", "social");
        objectif.setNom("soc");
        derby.update(objectif);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteObjectifMySql() throws SQLException {
        Objectif objectif = getMysql().findByProperty("nom", "Doss");
        getMysql().delete(objectif);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteObjectifDerby() throws SQLException {
        Objectif objectif = derby.findByProperty("nom", "Doss");

        derby.delete(objectif);
    }

    /**
     * Méthode pour creer un objectif en mysql
     *
     * @throws SQLException
     */
    @Test
    public void createObjectifMySqlService() throws SQLException {
        List<Objectif> objectifs = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Objectif objectif = new Objectif();
            objectif.setNom(nom[i]);
            objectif.setDescription("description");
            objectifs.add(objectif);
        }

        for (Object element : objectifs) {
            getMysqlService().create((Objectif) element);
        }

    }

    /**
     * Méthode pour creer un objectif en derby
     *
     * @throws SQLException
     */
    @Test
    public void createObjectifDerbyService() throws SQLException {
        List<Objectif> objectifs = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Objectif objectif = new Objectif();
            objectif.setNom(nom[i]);
            objectif.setDescription("description");
            objectifs.add(objectif);
        }

        for (Object element : objectifs) {
            derbyService.create((Objectif) element);
        }
    }

    /**
     * Méthode pour lire tous les objectif en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readAllObjectifMySqlService() throws SQLException {
        getMysqlService().findAll();

    }

    /**
     * Méthode pour lire tous les objectif en derby
     *
     * @throws SQLException
     */
    @Test
    public void readAllObjectifDerbyService() throws SQLException {
        derbyService.findAll();
    }

    /**
     * Méthode pour lire un objectif en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readObjectifMySqlService() throws SQLException {
        getMysqlService().findByProperty("nom", "social");

    }

    /**
     * Méthode pour lire tous les objectif en derby
     *
     * @throws SQLException
     */
    @Test
    public void readObjectifDerbyService() throws SQLException {
        derbyService.findByProperty("nom", "social");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateObjectifMySqlService() throws SQLException {
        Objectif objectif = getMysql().findByProperty("nom", "social");
        objectif.setNom("soc");
        getMysqlService().update(objectif);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateeObjectifDerbyService() throws SQLException {
        Objectif objectif = derby.findByProperty("nom", "social");
        objectif.setNom("soc");
        derbyService.update(objectif);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteObjectifMySqlService() throws SQLException {
        Objectif objectif = getMysql().findByProperty("nom", "Doss");
        getMysqlService().delete(objectif);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteObjectifDerbyService() throws SQLException {
        Objectif objectif = derby.findByProperty("nom", "Doss");

        derbyService.delete(objectif);
    }

    /**
     * @return the mysql
     */
    public ObjectifRepository getMySql() {
        return this.getMysql();
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMySql(ObjectifRepository mysql) {
        this.setMysql(mysql);
    }

    /**
     * @return the derby
     */
    public ObjectifRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(ObjectifRepository derby) {
        this.derby = derby;
    }

    /**
     * @return the mysql
     */
    public ObjectifRepository getMysql() {
        return mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(ObjectifRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derbyService
     */
    public ObjectifRepository getDerbyService() {
        return derbyService;
    }

    /**
     * @param derbyService the derbyService to set
     */
    public void setDerbyService(ObjectifRepository derbyService) {
        this.derbyService = derbyService;
    }

    /**
     * @return the mysqlService
     */
    public ObjectifRepository getMysqlService() {
        return mysqlService;
    }

    /**
     * @param mysqlService the mysqlService to set
     */
    public void setMysqlService(ObjectifRepository mysqlService) {
        this.mysqlService = mysqlService;
    }
}
