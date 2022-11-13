package com.esprit.examen.services;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.SecteurActiviteServiceImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteImplMock {
	
	    @Mock
	    SecteurActiviteRepository secteurRepository;
	    @InjectMocks
	    SecteurActiviteServiceImpl SecteurServiceImpl;
	    
	    
	    SecteurActivite secteuractivite = new SecteurActivite("libelleSecteur","10");
		List<SecteurActivite> listSecteurs = new ArrayList<SecteurActivite>() {
	        {
	            add(new SecteurActivite("libelleSecteur2", "20"));
	            add(new SecteurActivite("libelleSecteur3", "30"));
	        }
	    };
	    
	    @Test
	    void retrieveStock() {
	        Mockito.when(secteurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteuractivite));
	        SecteurActivite secteur1 = SecteurServiceImpl.retrieveSecteurActivite(0L);
	        Assertions.assertNotNull(secteur1);
	    }

	    @Test
	    void retrieveAllStocks() {
	        Mockito.when(secteurRepository.findAll()).thenReturn(listSecteurs);
	        List<SecteurActivite> list = SecteurServiceImpl.retrieveAllSecteurActivite();
	        Assertions.assertNotNull(list);
	    }
}
