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
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ReglementRepository;



import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
@RunWith(SpringRunner.class)

public class OperateurServiceImplMOCK {
	@Mock
OperateurRepository OperateurRepo;

	@InjectMocks
	OperateurServiceImpl OperateurImpl;

	
	
	 
	
	
	    Operateur operateur = new Operateur(1L, "ons", "trabelsi","ons123");
	    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
	        {
	            add(new Operateur(2L, "ons1", "tra","o23"));
	            add(new Operateur(3L, "ahmed1", "ahmed","o23"));
	        }
	    };


	    @Test
	   public void TestretrieveOperateur() {
	        Mockito.when( OperateurRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
	        Operateur operateur1 = OperateurImpl.retrieveOperateur(0L);
	        Assertions.assertNotNull(operateur1);
	    }

	    @Test
	    public void TestretrieveAllOperateurs() {
	        Mockito.when(OperateurRepo.findAll()).thenReturn(listOperateurs);
	        List<Operateur> list = OperateurImpl.retrieveAllOperateurs();
	        Assertions.assertNotNull(list);
	    }
	  
	
}
