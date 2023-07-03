package com.goit10;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public Map<Long, Note> listAll() {
        return noteRepository.findAll().stream().collect(Collectors.toMap(Note::getId, note -> note));
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById (long id) {
        noteRepository.deleteById(id);
    }

    public void upgrade(Note note) {
        noteRepository.save(note);
    }

    public Note getById (long id) {
        return noteRepository.getReferenceById(id);
    }
}
