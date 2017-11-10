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
import java.time.Instant;
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class PhaseTest {

    private PhaseRepository derby = new PhaseRepository("com.bootcamp_TpJPA");
    private PhaseRepository mysql = new PhaseRepository("tpJpa");
    private PhaseRepository derbyService = new PhaseRepository("tpservice-derby");
    private PhaseRepository mysqlService = new PhaseRepository("tpservice-mysql");

    /**
     * Méthode pour creer un phase en mysql
     *
     * @throws SQLException
     */
    @Test
    public void createPhaseMySql() throws SQLException {
        List<Phase> phases = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Phase phase = new Phase();
            phase.setNom(nom[i]);
            phase.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            phase.setDateDebutReelle(Date.from(Instant.now()));
            phase.setDateFinPrevisionnelle(Date.from(Instant.now()));
            phase.setDateFinReelle(Date.from(Instant.now()));
            phases.add(phase);
        }

        for (Object element : phases) {
            getMysql().create((Phase) element);
        }

    }

    /**
     * Méthode pour creer un phase en derby
     *
     * @throws SQLException
     */
    @Test
    public void createPhaseDerby() throws SQLException {
        List<Phase> phases = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Phase phase = new Phase();
            phase.setNom(nom[i]);
            phase.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            phase.setDateDebutReelle(Date.from(Instant.now()));
            phase.setDateFinPrevisionnelle(Date.from(Instant.now()));
            phase.setDateFinReelle(Date.from(Instant.now()));
            phases.add(phase);
        }

        for (Object element : phases) {
            derby.create((Phase) element);
        }
    }

    /**
     * Méthode pour lire tous les phase en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readAllPhaseMySql() throws SQLException {
        getMysql().findAll();

    }

    /**
     * Méthode pour lire tous les phase en derby
     *
     * @throws SQLException
     */
    @Test
    public void readAllPhaseDerby() throws SQLException {
        derby.findAll();
    }

    /**
     * Méthode pour lire un phase en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readPhaseMySql() throws SQLException {
        getMysql().findByProperty("nom", "social");

    }

    /**
     * Méthode pour lire tous les phase en derby
     *
     * @throws SQLException
     */
    @Test
    public void readPhaseDerby() throws SQLException {
        derby.findByProperty("nom", "social");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updatePhaseMySql() throws SQLException {
        Phase phase = getMysql().findByProperty("nom", "social");
        phase.setNom("soc");
        getMysql().update(phase);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateePhaseDerby() throws SQLException {
        Phase phase = derby.findByProperty("nom", "social");
        phase.setNom("soc");
        derby.update(phase);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deletePhaseMySql() throws SQLException {
        Phase phase = getMysql().findByProperty("nom", "Doss");
        getMysql().delete(phase);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deletePhaseDerby() throws SQLException {
        Phase phase = derby.findByProperty("nom", "Doss");

        derby.delete(phase);
    }

    /**
     * Méthode pour creer un phase en mysql
     *
     * @throws SQLException
     */
    @Test
    public void createPhaseMySqlService() throws SQLException {
        List<Phase> phases = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Phase phase = new Phase();
            phase.setNom(nom[i]);
            phase.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            phase.setDateDebutReelle(Date.from(Instant.now()));
            phase.setDateFinPrevisionnelle(Date.from(Instant.now()));
            phase.setDateFinReelle(Date.from(Instant.now()));
            phases.add(phase);
        }

        for (Object element : phases) {
            getMysqlService().create((Phase) element);
        }

    }

    /**
     * Méthode pour creer un phase en derby
     *
     * @throws SQLException
     */
    @Test
    public void createPhaseDerbyService() throws SQLException {
        List<Phase> phases = new LinkedList();

        String nom[] = {"social", "économique", "climatique", "environnemental", "institutionnel"};
        for (int i = 0; i < nom.length; i++) {
            Phase phase = new Phase();
            phase.setNom(nom[i]);
            phase.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            phase.setDateDebutReelle(Date.from(Instant.now()));
            phase.setDateFinPrevisionnelle(Date.from(Instant.now()));
            phase.setDateFinReelle(Date.from(Instant.now()));
            phases.add(phase);
        }

        for (Object element : phases) {
            derbyService.create((Phase) element);
        }
    }

    /**
     * Méthode pour lire tous les phase en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readAllPhaseMySqlService() throws SQLException {
        getMysqlService().findAll();

    }

    /**
     * Méthode pour lire tous les phase en derby
     *
     * @throws SQLException
     */
    @Test
    public void readAllPhaseDerbyService() throws SQLException {
        derbyService.findAll();
    }

    /**
     * Méthode pour lire un phase en mysql
     *
     * @throws SQLException
     */
    @Test
    public void readPhaseMySqlService() throws SQLException {
        getMysqlService().findByProperty("nom", "social");

    }

    /**
     * Méthode pour lire tous les phase en derby
     *
     * @throws SQLException
     */
    @Test
    public void readPhaseDerbyService() throws SQLException {
        derbyService.findByProperty("nom", "social");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updatePhaseMySqlService() throws SQLException {
        Phase phase = getMysql().findByProperty("nom", "social");
        phase.setNom("soc");
        getMysqlService().update(phase);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateePhaseDerbyService() throws SQLException {
        Phase phase = derby.findByProperty("nom", "social");
        phase.setNom("soc");
        derbyService.update(phase);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deletePhaseMySqlService() throws SQLException {
        Phase phase = getMysql().findByProperty("nom", "Doss");
        getMysqlService().delete(phase);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deletePhaseDerbyService() throws SQLException {
        Phase phase = derby.findByProperty("nom", "Doss");

        derbyService.delete(phase);
    }

    /**
     * @return the mysql
     */
    public PhaseRepository getMySqlService() {
        return this.getMysql();
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMySql(PhaseRepository mysql) {
        this.setMysql(mysql);
    }

    /**
     * @return the derby
     */
    public PhaseRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(PhaseRepository derby) {
        this.derby = derby;
    }

    /**
     * @return the mysql
     */
    public PhaseRepository getMysql() {
        return mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(PhaseRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derbyService
     */
    public PhaseRepository getDerbyService() {
        return derbyService;
    }

    /**
     * @param derbyService the derbyService to set
     */
    public void setDerbyService(PhaseRepository derbyService) {
        this.derbyService = derbyService;
    }

    /**
     * @return the mysqlService
     */
    public PhaseRepository getMysqlService() {
        return mysqlService;
    }

    /**
     * @param mysqlService the mysqlService to set
     */
    public void setMysqlService(PhaseRepository mysqlService) {
        this.mysqlService = mysqlService;
    }
}
