package com.vinitsharma.takenote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinitsharma.takenote.entity.Notes;
import com.vinitsharma.takenote.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
	
	List<Notes> findByUser(User user);

}
