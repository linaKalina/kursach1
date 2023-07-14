package domain;

import java.util.logging.Logger;

public class ID {
    private static int id;
    private static final Logger log = Logger.getLogger(ID.class.getName());
    public static int generateId() {
        log.fine("вызов команды generateId");
        return id++;
    }
}
