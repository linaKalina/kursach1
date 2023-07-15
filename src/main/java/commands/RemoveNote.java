package commands;

import domain.Note;
import exceptions.NoteException;

import java.util.Scanner;
import java.util.logging.Logger;

import static commands.Validate.validationId;
import static domain.Note.notes;

public class RemoveNote implements CommandsHandler {
    private static final Logger log = Logger.getLogger(NoteList.class.getName());

    @Override
    public void handler() throws NoteException {
        log.fine("вызов команды удаления заметки");
        System.out.println("Введите id удаляемой заметки");
        int id;
        try {
            id = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            log.warning("должно быть введено число");
            throw new NoteException("Введено не число");
        }
        if (validationId(id) != null) {
            notes.remove(validationId(id));
        } else {
            log.info("такого id нет");
            throw new NoteException("Такого id нет");
        }

    }


}
