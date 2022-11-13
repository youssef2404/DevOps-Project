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
public class ReglementServiceImplTest {
	  @Autowired
	   IReglementService ST;
	  @Autowired
		ReglementRepository ReglementRepo;

	  @Autowired
		ReglementServiceImpl ReglementImpl;
	  private static final Logger l = LogManager.getLogger(ReglementServiceImplTest.class);

	    @Test
	    @Order(1)
	    void TestRetreiveReglement() {
	        List<Reglement> listreglement= ST.retrieveAllReglements();
	        assertEquals(0, listreglement.size());
	    }

	    @Test
	 
	    	public void testaddReglement()throws ParseException {
	    	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			  Date dateReglement = dateFormat.parse("12/11/2022");
	    	Reglement reglement =new Reglement(1_75_235_897L,150.00f,20.00f,true,dateReglement);
			
	    	ST.addReglement(reglement);
			assertNotNull(reglement.getIdReglement());
			l.info("Mission added successfuly ");
			ReglementRepo.deleteById(reglement.getIdReglement());
			}
	    @Test
		public float testcountMontantPaye()throws ParseException {
	    	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			  Date  dateReglement = dateFormat.parse("12/11/2022");
			  Date dateReglement1 = dateFormat.parse("11/11/2022");
		float nbrms = ReglementRepo.getChiffreAffaireEntreDeuxDate( dateReglement ,  dateReglement1 );
		assertNotNull(nbrms);
		
		l.info(nbrms);
		return nbrms;
		}
		
	    }
