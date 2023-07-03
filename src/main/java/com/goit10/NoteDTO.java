package com.goit10;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteDTO {

    private long id;
    private String title;
    private String content;

    public static NoteDTO fromNote (Note note) {
        return NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }
}
