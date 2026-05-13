package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.CommandManager;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class ComplexCommandEditor extends JFrame {

    private final CommandManager commandManager;
    private final CompoundCommand workingCopy;
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> commandList = new JList<>(listModel);

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
        refreshList();

        add(new JScrollPane(commandList), BorderLayout.CENTER);
    }

    private void refreshList() {
        listModel.clear();
        Iterator<DriverCommand> iterator = workingCopy.iterator();

        while (iterator.hasNext()) {
            DriverCommand command = iterator.next();
            listModel.addElement(commandToString(command));
        }
    }

    private String commandToString(DriverCommand command) {
        if (command instanceof SetPositionCommand) {
            SetPositionCommand c = (SetPositionCommand) command;
            return "SetPosition(" + c.getPosX() + ", " + c.getPosY() + ")";
        }
        if (command instanceof OperateToCommand) {
            OperateToCommand c = (OperateToCommand) command;
            return "OperateTo(" + c.getPosX() + ", " + c.getPosY() + ")";
        }
        return command.toString();
    }
}
