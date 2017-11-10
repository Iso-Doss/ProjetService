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
@Path("/phases")
public class PhaseRestController {

    private PhaseRepository derby = new PhaseRepository("com.bootcamp_TpJPA");
    private PhaseRepository mysql = new PhaseRepository("tpJpa");

    /**
     *
     * @return @throws SQLException
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Phase> phases = getDerby().findAll();
        if (phases == null) {
            return Response.status(404).entity(phases).build();
        } else {
            return Response.status(200).entity(phases).build();
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
        Phase phase = getDerby().findById("id", id);

        if (phase == null) {
            return Response.status(404).entity(phase).build();
        } else {
            return Response.status(200).entity(phase).build();
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
        List<Phase> phases = (List<Phase>) getDerby().findByProperty(champs, valeur);

        if (phases == null) {
            return Response.status(404).entity(phases).build();
        } else {
            return Response.status(200).entity(phases).build();
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
        Phase phase = getDerby().findById("id", id);
        getDerby().delete(phase);
        Phase phaseDelete = getDerby().findById("id", id);

        if (phaseDelete == null) {
            return Response.status(200).entity(phase).build();
        } else {
            return Response.status(404).entity(phase).build();
        }
    }

    /**
     * 
     * @param phase
     * @throws SQLException 
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Phase phase) throws SQLException {
        getDerby().create(phase);
    }

    /**
     * 
     * @param phase
     * @throws SQLException 
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Phase phase) throws SQLException {
        getDerby().create(phase);
    }

    /**
     * @return the derby
     */
    public PhaseRepository getDerby() {
        return derby;
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

}
