package com.vinitsharma.takenote.service.impl;

import java.util.List;
import java.util.Optional;

import com.vinitsharma.takenote.entity.Notes;
import com.vinitsharma.takenote.entity.User;
import com.vinitsharma.takenote.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinitsharma.takenote.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
    NotesRepository notesRepository;
	
	@Override
	public Notes saveNotes(Notes notes) {
		
		return this.notesRepository.save(notes);
	}

	@Override
	public Optional<Notes> getNotesById(Integer noteId) {
		
		return this.notesRepository.findById(noteId);
	
	} 

	@Override
	public List<Notes> getNotesByUser(User user) {
		List<Notes> userNotes = this.notesRepository.findByUser(user);
		return userNotes;
	}

	@Override
	public Notes updateNotes(Notes notes) {
		System.out.println("Ha ha ha :"+notes.getId());;
		return this.notesRepository.save(notes);
	}

	@Override
	public boolean deleteNotes(Integer noteId) {
		Optional<Notes> notes = this.notesRepository.findById(noteId);
		if(notes.isPresent()) {
			this.notesRepository.deleteById(noteId);
			return true;
		}
		return false;
//		Notes notes = this.notesRepository.findById(noteId).get();
//		if(notes!=null) {
//			notesRepository.delete(notes);
//			return true;
//		}
//		return false;
	}

	@Override
	public Notes noteById(Integer noteId) {
		
		return this.notesRepository.findById(noteId).get();
	}

}
