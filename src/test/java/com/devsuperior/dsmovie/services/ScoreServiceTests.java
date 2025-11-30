package com.devsuperior.dsmovie.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.MovieEntity;
import com.devsuperior.dsmovie.entities.ScoreEntity;
import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.MovieFactory;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import com.devsuperior.dsmovie.tests.UserFactory;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTests {
	
	@InjectMocks
	private ScoreService service;
	
	@Mock
	private UserService userService;
	
	@Mock
	private MovieRepository movieRepository;
	
	@Mock
	private ScoreRepository scoreRepository;
	
	private UserEntity user;
	private MovieEntity movie;
	private ScoreEntity score;
	private ScoreDTO dto;
	
	@BeforeEach
	void setUp() {
		user = UserFactory.createUserEntity();
		movie = MovieFactory.createMovieEntity();
		score = ScoreFactory.createScoreEntity();
		dto = new ScoreDTO(movie.getId(), score.getValue());
		
		Mockito.when(userService.authenticated()).thenReturn(user);
		Mockito.when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
		Mockito.when(scoreRepository.saveAndFlush(any())).thenReturn(score);
		Mockito.when(movieRepository.save(any())).thenReturn(movie);
	}
	
	@Test
	public void saveScoreShouldReturnMovieDTO() {
		MovieDTO result = service.saveScore(dto);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(movie.getId(), result.getId());
	}
	
	@Test
	public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {
		Long invalidId = 999L;
		
		Mockito.when(movieRepository.findById(invalidId)).thenReturn(Optional.empty());
		
		ScoreDTO invalidDTO = new ScoreDTO(invalidId, 5.0);
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.saveScore(invalidDTO);
		});
	}
}
