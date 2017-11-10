/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.enums.EtatProjet;
import com.bootcamp.jpa.repositories.*;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.time.Instant;
import java.util.*;

/**
 *
 * @author Iso-Doss
 */
public class ProjetTest {

    private ProjetRepository derby = new ProjetRepository("com.bootcamp_TpJPA");
    private ProjetRepository mysql = new ProjetRepository("tpJpa");
    private ProjetRepository derbyService = new ProjetRepository("tpservice-derby");
    private ProjetRepository mysqlService = new ProjetRepository("tpservice-mysql");

    /**
     *
     * @throws SQLException
     */
    @Test
    public void createProjetMysql() throws SQLException {
        List<Projet> projets = new LinkedList();

        String nom[] = {"ProjetA", "ProjetZ", "ProjetE", "ProjetR", "ProjetT"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setCoutReel(122);
            projet.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            projet.setDateDebutReelle(Date.from(Instant.now()));
            projet.setDateFinPrevisionnelle(Date.from(Instant.now()));
            projet.setDateFinReelle(Date.from(Instant.now()));
            projet.setDescription("description");
            projet.setEtatProjet(EtatProjet.abandonné);
            projets.add(projet);
        }

        for (Object element : projets) {
            mysql.create((Projet) element);
        }

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void createProjetDerby() throws SQLException {
        List<Projet> projets = new LinkedList();

        String nom[] = {"ProjetA", "ProjetZ", "ProjetE", "ProjetR", "ProjetT"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setCoutReel(122);
            projet.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            projet.setDateDebutReelle(Date.from(Instant.now()));
            projet.setDateFinPrevisionnelle(Date.from(Instant.now()));
            projet.setDateFinReelle(Date.from(Instant.now()));
            projet.setDescription("description");
            projet.setEtatProjet(EtatProjet.abandonné);
            projets.add(projet);
        }

        for (Object element : projets) {
            derby.create((Projet) element);
        }
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readAllProjetMysql() throws SQLException {
        mysql.findAll();

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readAllProjetDerby() throws SQLException {
        derby.findAll();
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readProjetMysql() throws SQLException {
        mysql.findByProperty("nom", "Iso");

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readProjetDerby() throws SQLException {
        derby.findByProperty("nom", "Iso");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateProjetMysql() throws SQLException {
        Projet projet = mysql.findByProperty("nom", "Iso");
        projet.setNom("zozo");
        mysql.update(projet);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateeProjetDerby() throws SQLException {
        Projet projet = derby.findByProperty("nom", "Iso");
        projet.setNom("zozo");
        derby.update(projet);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteProjetMysql() throws SQLException {
        Projet projet = mysql.findByProperty("nom", "Doss");
        mysql.delete(projet);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteProjetDerby() throws SQLException {
        Projet projet = derby.findByProperty("nom", "Doss");

        derby.delete(projet);
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void createProjetMysqlService() throws SQLException {
        List<Projet> projets = new LinkedList();

        String nom[] = {"ProjetA", "ProjetZ", "ProjetE", "ProjetR", "ProjetT"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setCoutReel(122);
            projet.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            projet.setDateDebutReelle(Date.from(Instant.now()));
            projet.setDateFinPrevisionnelle(Date.from(Instant.now()));
            projet.setDateFinReelle(Date.from(Instant.now()));
            projet.setDescription("description");
            projet.setEtatProjet(EtatProjet.abandonné);
            projets.add(projet);
        }

        for (Object element : projets) {
            mysqlService.create((Projet) element);
        }

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void createProjetDerbyService() throws SQLException {
        List<Projet> projets = new LinkedList();

        String nom[] = {"ProjetA", "ProjetZ", "ProjetE", "ProjetR", "ProjetT"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setCoutReel(122);
            projet.setDateDebutPrevisionnelle(Date.from(Instant.now()));
            projet.setDateDebutReelle(Date.from(Instant.now()));
            projet.setDateFinPrevisionnelle(Date.from(Instant.now()));
            projet.setDateFinReelle(Date.from(Instant.now()));
            projet.setDescription("description");
            projet.setEtatProjet(EtatProjet.abandonné);
            projets.add(projet);
        }

        for (Object element : projets) {
            derbyService.create((Projet) element);
        }
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readAllProjetMysqlService() throws SQLException {
        mysqlService.findAll();

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readAllProjetDerbyService() throws SQLException {
        derbyService.findAll();
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readProjetMysqlService() throws SQLException {
        mysqlService.findByProperty("nom", "Iso");

    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readProjetDerbyService() throws SQLException {
        derbyService.findByProperty("nom", "Iso");
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateProjetMysqlService() throws SQLException {
        Projet projet = mysql.findByProperty("nom", "Iso");
        projet.setNom("zozo");
        mysqlService.update(projet);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void updateeProjetDerbyService() throws SQLException {
        Projet projet = derby.findByProperty("nom", "Iso");
        projet.setNom("zozo");
        derbyService.update(projet);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteProjetMysqlService() throws SQLException {
        Projet projet = mysql.findByProperty("nom", "Doss");
        mysqlService.delete(projet);
    }

    /**
     *
     * @throws SQLException
     */
    //@Test
    public void deleteProjetDerbyService() throws SQLException {
        Projet projet = derby.findByProperty("nom", "Doss");

        derbyService.delete(projet);
    }

    /**
     * @return the mysql
     */
    public ProjetRepository getMysql() {
        return this.mysql;
    }

    /**
     * @param mysql the mysql to set
     */
    public void setMysql(ProjetRepository mysql) {
        this.mysql = mysql;
    }

    /**
     * @return the derby
     */
    public ProjetRepository getDerby() {
        return this.derby;
    }

    /**
     * @param derby the derby to set
     */
    public void setDerby(ProjetRepository derby) {
        this.derby = derby;
    }

    /**
     * @return the derbyService
     */
    public ProjetRepository getDerbyService() {
        return derbyService;
    }

    /**
     * @param derbyService the derbyService to set
     */
    public void setDerbyService(ProjetRepository derbyService) {
        this.derbyService = derbyService;
    }

    /**
     * @return the mysqlService
     */
    public ProjetRepository getMysqlService() {
        return mysqlService;
    }

    /**
     * @param mysqlService the mysqlService to set
     */
    public void setMysqlService(ProjetRepository mysqlService) {
        this.mysqlService = mysqlService;
    }
}
