package edu.kis.powp.jobs2d.command.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.observer.Subscriber;

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