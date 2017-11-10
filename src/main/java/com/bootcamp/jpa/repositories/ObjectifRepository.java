/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Objectif;

/**
 *
 * @author Iso-Doss
 */
public class ObjectifRepository extends BaseRepository<Objectif> {

    public ObjectifRepository(String unitPersistence) {
        super(unitPersistence, Objectif.class);
    }
}
