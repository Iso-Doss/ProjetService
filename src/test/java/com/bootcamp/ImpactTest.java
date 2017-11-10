/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.enums.*;
import com.bootcamp.jpa.repositories.*;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class ImpactTest {

    private ImpactRepository derby = new ImpactRepository("com.bootcamp_TpJPA");
    private ImpactRepository mysql = new ImpactRepository("tpJpa");
    private ImpactRepository derbyService = new ImpactRepository("tpservice-derby");
    private ImpactRepository mysqlService = new ImpactRepository("tpservice-mysql");

    /**
     * Méthode pour creer un impact en mysql
     *
     * @throws SQLException
     */
    @Test
    public void createImpactMySql() throws SQLException {
        List<Impact> impacts = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Impact impact = new Impact();
            impact.setNom(nom[i]);
            impact.setTypeImapct(TypeImapct.social);
            impacts.add(impact);
        }

        for (Object element : impacts) {
            getMysql().create((Impact) element);
        }

    }

    /**
     * Méthode pour creer un impact en derby
     *
     * @throws SQLException
     */
    @Test
    public void createImpactDerby() throws SQLException {
        List<Impact> impacts = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Impact impact = new Impact();
            impact.setNom(nom[i]);
            impact.setTypeImapct(TypeImapct.social);
            impacts.add(impact);
        }

        for (Object element : impacts) {
            getDerby().create((Impact) element);
        }
    }

    /**
     * Méthode pour lire tous les impact en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readAllImpactMySql() throws SQLException {
        getMysql().findAll();

    }

    /**
     * Méthode pour lire tous les impact en derby
     *
     * @throws SQLException
     */
    @Test
    public void readAllImpactDerby() throws SQLException {
        getDerby().findAll();
    }

    /**
     * Méthode pour lire un impact en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readImpactMySql() throws SQLException {
        getMysql().findByProperty("nom", "social");

    }

    /**
     * Méthode pour lire tous les impact en derby
     *
     * @throws SQLException
     */
    @Test
    public void readImpactDerby() throws SQLException {
        getDerby().findByProperty("nom", "social");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateImpactMySql() throws SQLException {
        Impact impact = getMysql().findByProperty("nom", "social");
        impact.setNom("soc");
        getMysql().update(impact);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateeImpactDerby() throws SQLException {
        Impact impact = getDerby().findByProperty("nom", "social");
        impact.setNom("soc");
        getDerby().update(impact);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteImpactMySql() throws SQLException {
        Impact impact = getMysql().findByProperty("nom", "Doss");
        getMysql().delete(impact);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteImpactDerby() throws SQLException {
        Impact impact = getDerby().findByProperty("nom", "Doss");

        getDerby().delete(impact);
    }

    /**
     * Méthode pour creer un impact en mysql
     *
     * @throws SQLException
     */
    @Test
    public void createImpactMySqlService() throws SQLException {
        List<Impact> impacts = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Impact impact = new Impact();
            impact.setNom(nom[i]);
            impact.setTypeImapct(TypeImapct.social);
            impacts.add(impact);
        }

        for (Object element : impacts) {
            getMysqlService().create((Impact) element);
        }

    }

    /**
     * Méthode pour creer un impact en derby
     *
     * @throws SQLException
     */
    @Test
    public void createImpactDerbyService() throws SQLException {
        List<Impact> impacts = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Impact impact = new Impact();
            impact.setNom(nom[i]);
            impact.setTypeImapct(TypeImapct.social);
            impacts.add(impact);
        }

        for (Object element : impacts) {
            getDerbyService().create((Impact) element);
        }
    }

    /**
     * Méthode pour lire tous les impact en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readAllImpactMySqlService() throws SQLException {
        getMysqlService().findAll();

    }

    /**
     * Méthode pour lire tous les impact en derby
     *
     * @throws SQLException
     */
    @Test
    public void readAllImpactDerbyService() throws SQLException {
        getDerbyService().findAll();
    }

    /**
     * Méthode pour lire un impact en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readImpactMySqlService() throws SQLException {
        getMysqlService().findByProperty("nom", "social");

    }

    /**
     * Méthode pour lire tous les impact en derby
     *
     * @throws SQLException
     */
    @Test
    public void readImpactDerbyService() throws SQLException {
        getDerbyService().findByProperty("nom", "social");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateImpactMySqlService() throws SQLException {
        Impact impact = getMysql().findByProperty("nom", "social");
        impact.setNom("soc");
        getMysqlService().update(impact);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateeImpactDerbyService() throws SQLException {
        Impact impact = getDerby().findByProperty("nom", "social");
        impact.setNom("soc");
        getDerbyService().update(impact);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteImpactMySqlService() throws SQLException {
        Impact impact = getMysql().findByProperty("nom", "Doss");
        getMysqlService().delete(impact);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteImpactDerbyService() throws SQLException {
        Impact impact = getDerby().findByProperty("nom", "Doss");

        getDerbyService().delete(impact);
    }

    /**
     * @return the derby
     */
    public ImpactRepository getDerby() {
        return derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(ImpactRepository derby) {
        this.derby = derby;
    }

    /**
     * @return the mysql
     */
    public ImpactRepository getMysql() {
        return mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(ImpactRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derbyService
     */
    public ImpactRepository getDerbyService() {
        return derbyService;
    }

    /**
     * @param derbyService the derbyService to set
     */
    public void setDerbyService(ImpactRepository derbyService) {
        this.derbyService = derbyService;
    }

    /**
     * @return the mysqlService
     */
    public ImpactRepository getMysqlService() {
        return mysqlService;
    }

    /**
     * @param mysqlService the mysqlService to set
     */
    public void setMysqlService(ImpactRepository mysqlService) {
        this.mysqlService = mysqlService;
    }

}
