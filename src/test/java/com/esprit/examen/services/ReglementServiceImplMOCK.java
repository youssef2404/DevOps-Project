package com.esprit.examen.services;
import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
@RunWith(SpringRunner.class)

public class ReglementServiceImplMOCK {
	@Mock
	ReglementRepository ReglementRepo;

	@InjectMocks
	ReglementServiceImpl ReglementImpl;

	
	
	 
	
	 @Test
	 public void TestretrieveAllReglements() throws ParseException {
		  
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateReglement = dateFormat.parse("11/11/2022");
			Date dateReglement1 = dateFormat.parse("12/11/2022");
			Date dateReglement2 = dateFormat.parse("13/11/2022");
			Reglement reglement =new Reglement(1_75_235_897L,150.00f,20.00f,true,dateReglement);
			
			 List <Reglement> reglements = new ArrayList<Reglement>() {
			        {
			            add(new Reglement(2_75_235_897L,150.00f,20.00f,true,dateReglement1));
			            add(new Reglement(3_75_235_897L,125.00f,10.00f,true,dateReglement2));
			        }
			    };
			Mockito.when(ReglementRepo.findAll()).thenReturn(reglements);
			List <Reglement> list = ReglementImpl.retrieveAllReglements();
			Assertions.assertNotNull(list);
			
	 }

	 @Test
	 public void TestRetreiveReglement()throws ParseException{
		 
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  Date dateReglement = dateFormat.parse("12/11/2022");
			Date dateReglement1 = dateFormat.parse("12/11/2022");
			Date dateReglement2 = dateFormat.parse("13/11/2022");
			Reglement reglement =new Reglement(1_75_235_897L,150.00f,20.00f,true,dateReglement);
			
			 List <Reglement> reglements = new ArrayList<Reglement>() {
			        {
			            add(new Reglement(2_75_235_897L,150.00f,20.00f,true,dateReglement1));
			            add(new Reglement(3_75_235_897L,125.00f,10.00f,true,dateReglement2));
			        }
			    };

			 Mockito.when(ReglementRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
		       Reglement r1 = ReglementImpl.retrieveReglement(0L);
		        Assertions.assertNotNull(r1);
		 
		 
	 }
	 @Test
	 public void TestretrieveReglementByFacture()throws ParseException{
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  Date dateReglement = dateFormat.parse("12/11/2022");
			Date dateReglement1 = dateFormat.parse("12/11/2022");
			Date dateReglement2 = dateFormat.parse("13/11/2022");
			Reglement reglement =new Reglement(1_75_235_897L,150.00f,20.00f,true,dateReglement);
			
			 List <Reglement> reglements = new ArrayList<Reglement>() {
			        {
			            add(new Reglement(2_75_235_897L,150.00f,20.00f,true,dateReglement1));
			            add(new Reglement(3_75_235_897L,125.00f,10.00f,true,dateReglement2));
			        }
			    };
		long idFacture =20_20L;

		 Mockito.when(ReglementRepo.findAll()).thenReturn(reglements ) ;
		 ReglementImpl.retrieveReglementByFacture(idFacture); 
		 
	 }
	 
	  
	
}
