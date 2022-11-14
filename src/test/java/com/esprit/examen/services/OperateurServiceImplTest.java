package com.esprit.examen.services;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.TestMethodOrder;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
public class OperateurServiceImplTest {
	 @Autowired
	    IOperateurService OP;

	    @Test
	    @Order(1)
	    public void TestretrieveOperateur() {
	        List<Operateur> listOperateurs =OP.retrieveAllOperateurs();
	        assertEquals(0, listOperateurs.size());
	    }

	    @Test
	    public void  addOperateur(){
	    	Operateur OP1 = new Operateur();
	    	OP1.setIdOperateur(1L);
	    	OP1 .setNom("ons");;
	    	OP1.setPrenom("trabelsi");
	    	OP1.setPassword("orr15");
	    	Operateur savedOperateur1= OP.addOperateur(OP1);
	        assertEquals(OP1.getNom(), savedOperateur1.getNom());
	    }

	    @Test
	    public void deleteOperateur() {
	    	OP.deleteOperateur(0L);;
	    }

	    @Test
	    public void updateOperateur() {
	    	Operateur OP1 = OP.retrieveOperateur(0L);
	    	OP1.setPassword("156fg");;
	    	Operateur updatedOperateur1= OP.updateOperateur(OP1);
	        assertEquals(OP1.getPassword(), updatedOperateur1.getPassword());
	    }

	    @Test
	    public void retrieveOperateur() {
	        OP.retrieveOperateur(0L);
	    }

	    @Test
	    public void retrieveAllOperateur() {
	        OP.retrieveAllOperateurs();
	    }

	    }
