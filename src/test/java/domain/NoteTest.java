package domain;

import commands.NewNote;
import commands.RemoveNote;
import exceptions.NoteException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class NoteTest {

    @Test
    void getIdTest() {
        assertEquals(ID.generateId(), ID.generateId() - 1);
    }

    @Test
    void textValidationNotCorrectTest() {
        String text = "u";
        Throwable thrown = assertThrows(NoteException.class, () -> {
            new NewNote().textValidation(text);
        });
        assertEquals("Введен текст до 3 символов", thrown.getMessage());
    }

    @Test
    public void AddNewNoteTest() {
        List<String> label = new ArrayList<>();
        label.add("LABEL");
        Note note1 = new Note("text1", label);
        Note.notes.add(note1);
        assertEquals(1, Note.notes.size());
        assertEquals(0, note1.getId());
        assertEquals("text1", note1.getText());
        assertEquals(label, note1.getLabel());
    }


    @Test
    void labelValidationNotCorrectTest() {
        List<String> labels = new ArrayList<>();
        labels.add("123");
        Throwable thrown = assertThrows(NoteException.class, () -> {
            new NewNote().labelValidation(labels);
        });
        assertEquals("Введены некорректные метки", thrown.getMessage());
    }
    @Test
    void validationIdCorrectTest() {
        List<String> label = new ArrayList<>();
        label.add("l");
        Note note1 = new Note("text", label);
        Note.notes.add(note1);
        assertEquals(note1, new RemoveNote().validationId(note1.getId()));
    }

    @Test
    void validationIdNotCorrectTest() {
        List<String> label = new ArrayList<>();
        label.add("l");
        Note note1 = new Note("text", label);
        Note.notes.add(note1);
        int id = note1.getId();
        Note.notes.remove(id);
        assertNull(new RemoveNote().validationId(id));
    }

}