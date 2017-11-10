/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.repositories.*;
import com.bootcamp.jpa.entities.*;
import java.sql.SQLException;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author Iso-Doss
 */
@Path("/objectifs")
public class ObjectifRestController {

    private ObjectifRepository derby = new ObjectifRepository("com.bootcamp_TpJPA");
    private ObjectifRepository mysql = new ObjectifRepository("tpJpa");

    /**
     *
     * @return @throws SQLException
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Objectif> objectifs = getDerby().findAll();
        if (objectifs == null) {
            return Response.status(404).entity(objectifs).build();
        } else {
            return Response.status(200).entity(objectifs).build();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListById(@PathParam("id") int id) throws SQLException {
        Objectif objectif = getDerby().findById("id", id);

        if (objectif == null) {
            return Response.status(404).entity(objectif).build();
        } else {
            return Response.status(200).entity(objectif).build();
        }
    }

    /**
     *
     * @param champs
     * @param valeur
     * @return
     * @throws SQLException
     */
    @GET
    @Path("/parametre/{champs}/{valeur}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListByParam(@PathParam("champs") String champs, @PathParam("valeur") String valeur) throws SQLException {
        List<Objectif> objectifs = (List<Objectif>) getDerby().findByProperty(champs, valeur);

        if (objectifs == null) {
            return Response.status(404).entity(objectifs).build();
        } else {
            return Response.status(200).entity(objectifs).build();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeleteListByParam(@PathParam("id") int id) throws SQLException {
        Objectif objectif = getDerby().findById("id", id);
        getDerby().delete(objectif);
        Objectif objectifDelete = getDerby().findById("id", id);

        if (objectifDelete == null) {
            return Response.status(200).entity(objectif).build();
        } else {
            return Response.status(404).entity(objectif).build();
        }
    }

    /**
     *
     * @param objectif
     * @throws SQLException
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Objectif objectif) throws SQLException {
        getDerby().create(objectif);
    }

    /**
     *
     * @param objectif
     * @throws SQLException
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Objectif objectif) throws SQLException {
        getDerby().create(objectif);
    }

    /**
     * @return the derby
     */
    public ObjectifRepository getDerby() {
        return derby;
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

}
