package commands;

import domain.Note;

import java.util.logging.Logger;

public class CommandHelp implements CommandsHandler {
    private static final Logger log = Logger.getLogger(CommandHelp.class.getName());

    @Override
    public void handler() {
        log.fine("вызов команды для вывода меню");
        Commands.printAllCommands();
    }
}
