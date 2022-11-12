package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.services.ISecteurActiviteService;

@SpringBootTest
 public class SecteurActiviteImplTest {
	
	@Autowired
	ISecteurActiviteService secteur;

	@Test
	 public void testretrieveAllSecteurActivite() {
		List<SecteurActivite> listSecteurs = secteur.retrieveAllSecteurActivite();
		Assertions.assertEquals(0, listSecteurs.size());
	}
    @Test
    void testaddSecteurActivite() {
    	SecteurActivite secteur1 = new SecteurActivite();
    	secteur1.setLibelleSecteurActivite("secteur test");
    	secteur1.setCodeSecteurActivite("10");
    	SecteurActivite savedSecteur= secteur.addSecteurActivite(secteur1);
        assertEquals(secteur1.getLibelleSecteurActivite(), savedSecteur.getLibelleSecteurActivite());
    }
    @Test
    void testdeleteSecteurActivite() {
    	secteur.deleteSecteurActivite(0L);
    }
    @Test
    void testupdateSecteurActivite() {
    	SecteurActivite s1= secteur.retrieveSecteurActivite(0L);
        s1.setCodeSecteurActivite("100");
        SecteurActivite updatedSecteur= secteur.updateSecteurActivite(s1);
        assertEquals(s1.getCodeSecteurActivite(), updatedSecteur.getCodeSecteurActivite());
    }
    @Test
    void testretrieveSecteurActivite() {
    	secteur.retrieveSecteurActivite(0L);
    }
   
}
