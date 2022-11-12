package tn.esprit.spring.service;

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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteImplTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(SecteurActiviteImplTest.class);

	
	
	
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository ;
	
	@Autowired
	ISecteurActiviteService iSecteurActiviteService ;
	
	
	
	//Add Mission Test 
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddSecteurActivite() {
			SecteurActivite secteurActivite = new SecteurActivite("secteurActiviteTest","secteurActiviteTest");
			iSecteurActiviteService.addSecteurActivite(secteurActivite);
		assertNotNull(secteurActivite.getIdSecteurActivite());
		l.info("Mission added successfuly ");
		secteurActiviteRepository.deleteById(secteurActivite.getIdSecteurActivite());
		}
		
		
		
		//Count missions a make sure the return is  not null
		@Test
		public void testcountSecteurActivite() {
		long nbrms = secteurActiviteRepository.count();
		assertNotNull(nbrms);
		l.info("Le Nombre des secteurActivite est :");
		l.info(nbrms);
		}
		
		
		
		// Make sure the Database is not Nulls
		@Test
		public void testListMission() {
		List<SecteurActivite> e = (List<SecteurActivite>) secteurActiviteRepository.findAll();
		assertThat(e).size().isPositive();
		l.info( "> 0");
		}
		
		
		
		
		//delete a mission (id=2).
		
				@Test
				public void deleteMission() {
					long id = 2;
					iSecteurActiviteService.deleteSecteurActivite(id);
				}
				

	
}
