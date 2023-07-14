package commands;

import exceptions.NoteException;

public interface CommandsHandler {
    void handler() throws NoteException;
}
