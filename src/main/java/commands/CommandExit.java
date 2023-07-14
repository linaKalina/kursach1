package commands;

import exceptions.NoteException;

import java.util.logging.Logger;

public class CommandExit implements CommandsHandler{
    private static final Logger log = Logger.getLogger(CommandExit.class.getName());
    @Override
    public void handler() throws NoteException {
        log.fine("вызов команды exit");
        System.exit(0);
    }
}
