package com.esprit.examen.services;
import org.apache.logging.log4j.LogManager;  
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.ISecteurActiviteService;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteImplTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(SecteurActiviteImplTest.class);

	
	
	
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository ;
	
	@Autowired
	ISecteurActiviteService iSecteurActiviteService ;
	
	
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddSecteurActivite() {
			SecteurActivite secteurActivite = new SecteurActivite("secteurActiviteTest","secteurActiviteTest");
			iSecteurActiviteService.addSecteurActivite(secteurActivite);
		    assertNotNull(secteurActivite.getIdSecteurActivite());
		    l.info("Secteur d'activite added successfuly ");
		    secteurActiviteRepository.deleteById(secteurActivite.getIdSecteurActivite());
		}
		
		 @Test
		 public void testupdateSecteur() {
			    SecteurActivite secteurActivite = new SecteurActivite("secteurActiviteTest","secteurActiviteTest");
				iSecteurActiviteService.addSecteurActivite(secteurActivite);
				SecteurActivite secteurretrived = iSecteurActiviteService.retrieveSecteurActivite(secteurActivite.getIdSecteurActivite());		  
				secteurretrived.setCodeSecteurActivite("updated code");
				secteurretrived.setLibelleSecteurActivite("updated libelle");
				SecteurActivite updatedSecteur = iSecteurActiviteService.updateSecteurActivite(secteurretrived);
				assertEquals(updatedSecteur.getIdSecteurActivite(),secteurretrived.getIdSecteurActivite());
		    }
		
		@Test
		public void testRetrieveAllSecteurActivite() {
			List<SecteurActivite> listSecteurActivite = iSecteurActiviteService.retrieveAllSecteurActivite();
			assertEquals(0, listSecteurActivite.size());
		}
		
		
		@Test
		public void testretrieveSecteurActivite() {
			SecteurActivite secteur = new SecteurActivite("code", "libelle");
			SecteurActivite savedSecteurActivite= iSecteurActiviteService.addSecteurActivite(secteur);
			SecteurActivite secteurretrived = iSecteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
			assertNotNull(secteurretrived);
		}
		
		
		@Test
		public void testDeleteSecteurActivite() {
			SecteurActivite secteur = new SecteurActivite("code", "libelle");
			SecteurActivite savedSecteurActivite= iSecteurActiviteService.addSecteurActivite(secteur);
			iSecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
			assertNull(iSecteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite()));
		}
				

	
}