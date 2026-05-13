package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.manager.CommandManager;

import javax.swing.*;
import java.awt.*;

public class ComplexCommandEditor extends JFrame {

    private final CommandManager commandManager;
    private final CompoundCommand workingCopy;

    public ComplexCommandEditor(CommandManager commandManager) {
        this.commandManager = commandManager;

        if (commandManager.getCurrentCommand() == null) {
            workingCopy = new CompoundCommand();
        } else {
            workingCopy = (CompoundCommand) commandManager.getCurrentCommand().deepCopy();
        }

        setTitle("Complex Command Editor");
        setSize(500, 400);
        setLayout(new BorderLayout());
    }
}
