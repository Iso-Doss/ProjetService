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
@Path("/impacts")
public class ImpactRestController {

    private ImpactRepository derby = new ImpactRepository("com.bootcamp_TpJPA");
    private ImpactRepository mysql = new ImpactRepository("tpJpa");

    /**
     *
     * @return @throws SQLException
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Impact> impacts = getDerby().findAll();
        if (impacts == null) {
            return Response.status(404).entity(impacts).build();
        } else {
            return Response.status(200).entity(impacts).build();
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
        Impact impact = getDerby().findById("id", id);

        if (impact == null) {
            return Response.status(404).entity(impact).build();
        } else {
            return Response.status(200).entity(impact).build();
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
        List<Impact> impacts = (List<Impact>) getDerby().findByProperty(champs, valeur);

        if (impacts == null) {
            return Response.status(404).entity(impacts).build();
        } else {
            return Response.status(200).entity(impacts).build();
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
        Impact impact = getDerby().findById("id", id);
        getDerby().delete(impact);
        Impact impactDelete = getDerby().findById("id", id);

        if (impactDelete == null) {
            return Response.status(200).entity(impact).build();
        } else {
            return Response.status(404).entity(impact).build();
        }
    }

    /**
     * 
     * @param impact
     * @throws SQLException 
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Impact impact) throws SQLException {
        getDerby().create(impact);
    }

    /**
     * 
     * @param impact
     * @throws SQLException 
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Impact impact) throws SQLException {
        getDerby().create(impact);
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

}
