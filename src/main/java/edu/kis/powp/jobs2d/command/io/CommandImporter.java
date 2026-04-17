package edu.kis.powp.jobs2d.command.io;

import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.List;

public interface CommandImporter {
    /**
     * Imports a set of commands from a given text representation.
     *
     * @param text The text containing command declarations (e.g., JSON, XML).
     * @return List of parsed DriverCommands.
     */
    List<DriverCommand> importCommands(String text);
}
