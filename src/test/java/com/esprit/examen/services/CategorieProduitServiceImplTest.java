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

import com.esprit.examen.entities.CategorieProduit;

import com.esprit.examen.repositories.CategorieProduitRepository;


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

@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitServiceImplTest {

	
	 @Autowired
	    private MockMvc mockMvc;
	@Mock
	CategorieProduitRepository repo;
	@InjectMocks
	CategorieProduitServiceImpl serv;

	

	@Test
	public void addCategorieProduitTest(){
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new CategorieProduit("aaaaa","bbbbbb"), new CategorieProduit("cccccc","dddd")).collect(Collectors.toList()));
	    assertEquals(2, serv.retrieveAllCategorieProduits().size());
	}
	
	@Test
	public void RetrieveAllTest() {
		List<CategorieProduit> ops = new ArrayList<>();
		ops.add(new CategorieProduit());

		when(repo.findAll()).thenReturn(ops);

		List<CategorieProduit> expected = serv.retrieveAllCategorieProduits();
		
		//log.info("get ==> " + String.valueOf(ops));
		
		assertEquals(expected, ops);
		verify(repo).findAll();
	}
	
	
    @Test
    public void DeleteTest() throws Exception{
    	CategorieProduit cp = new CategorieProduit();
    	cp.setCodeCategorie("aaaaa");
    	cp.setIdCategorieProduit(1L);
    	cp.setLibelleCategorie("bbbb");
    	when(repo.findById(cp.getIdCategorieProduit())).thenReturn(Optional.of(cp));
    	serv.deleteCategorieProduit(cp.getIdCategorieProduit());
    	verify(repo).deleteById(cp.getIdCategorieProduit());
       
    }
	
    @Test()
    public void should_throw_exception_when_categorie_produit_doesnt_exist()  {
    	CategorieProduit cp = new CategorieProduit();
    	cp.setCodeCategorie("aaaaa");
    	cp.setIdCategorieProduit(100L);
    	cp.setLibelleCategorie("bbbb");
    given(repo.findById(anyLong())).willReturn(Optional.ofNullable(null));
    serv.deleteCategorieProduit(cp.getIdCategorieProduit());
    
   
    }
	


	
}
