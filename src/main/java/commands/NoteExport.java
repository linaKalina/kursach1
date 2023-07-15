package commands;

import domain.Note;
import exceptions.NoteException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static domain.Note.notes;

public class NoteExport implements CommandsHandler {
    private static final Logger log = Logger.getLogger(NoteExport.class.getName());

    @Override
    public void handler() throws NoteException {
        log.fine("вызов команды export");
        try {
            FileWriter fileWriter = new FileWriter(fileName());
            for (Note note : notes) {
                fileWriter.write(note.toString());
            }
            fileWriter.flush();
        } catch (IOException e) {
            log.warning("ошибка io при записи заметок в файл");
            e.printStackTrace();
        }
    }

    private String fileName() {
        log.fine("вызов метода установки имени файла");
        String dateTime = DateTimeFormatter.ofPattern("yyyy.MM.dd_hh:mm:ss")
                .format(LocalDateTime.now());
        return "notes_" + dateTime + ".txt";
    }
}
