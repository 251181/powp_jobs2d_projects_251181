package edu.kis.powp.jobs2d.command.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.observer.Subscriber;

/**
 * Observer responsible for storing history of all commands
 * set as current in CommandManager.
 * Each update stores a textual representation of the command.
 */
public class CommandHistoryObserver implements Subscriber {

    private final List<String> history = new ArrayList<>();

    @Override
    public void update() {
        DriverCommand command =
                CommandsFeature.getDriverCommandManager().getCurrentCommand();

        if (command != null) {
            history.add(command.toString());
        }
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public String toString() {
        return "Command History Observer";
    }
}