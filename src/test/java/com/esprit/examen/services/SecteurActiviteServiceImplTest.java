package com.esprit.examen.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.ResultActions;

import com.esprit.examen.entities.SecteurActivite;

import com.esprit.examen.repositories.SecteurActiviteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;*/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
//import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class SecteurActiviteServiceImplTest {


	 @Autowired
	    private MockMvc mockMvc;
	@Mock
	SecteurActiviteRepository repo;
	@InjectMocks
	SecteurActiviteServiceImpl serv;

	

	@Test
	public void addSecteurActiviteTest(){
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new SecteurActivite( ), new SecteurActivite() ).collect(Collectors.toList()));
	    assertEquals(2, serv.retrieveAllSecteurActivite().size());
	}
	
	@Test
	public void RetrieveAllTest() {
		List<SecteurActivite> fact = new ArrayList<>();
		fact.add(new SecteurActivite());

		when(repo.findAll()).thenReturn(fact);

		List<SecteurActivite> expected = serv.retrieveAllSecteurActivite();
		
		//log.info("get ==> " + String.valueOf(fact));
		
		assertEquals(expected, fact);
		verify(repo).findAll();
	}
	
	// JUnit test for delete employee REST API
    @Test
    public void DeleteTest() throws Exception{
    	SecteurActivite sa = new SecteurActivite();
    	
    	sa.setCodeSecteurActivite("soso");
    	sa.setIdSecteurActivite(1L);
    	sa.setLibelleSecteurActivite("lolo");
    	
    	
    	when(repo.findById(sa.getIdSecteurActivite())).thenReturn(Optional.of(sa));
    	serv.deleteSecteurActivite(sa.getIdSecteurActivite());
    	verify(repo).deleteById(sa.getIdSecteurActivite());
       
    }
	
    @Test()
    public void should_throw_exception_when_user_doesnt_exist()  {
    	SecteurActivite sac = new SecteurActivite();
    	sac .setCodeSecteurActivite("soso");
    	sac .setIdSecteurActivite(1L);
    	sac .setLibelleSecteurActivite("lolo");
    given(repo.findById(anyLong())).willReturn(Optional.ofNullable(null));
    serv.deleteSecteurActivite(sac .getIdSecteurActivite());
    
   
    }
	


	
}
