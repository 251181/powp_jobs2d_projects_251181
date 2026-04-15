package edu.kis.powp.jobs2d.command;

import java.util.Arrays;

public class DeepCopyTest {

    public static void main(String[] args) {
        CompoundCommand original = new CompoundCommand(
                Arrays.asList(new SetPositionCommand(1, 2), new OperateToCommand(3, 4)), "cmd");

        CompoundCommand copy = (CompoundCommand) original.deepCopy();

        if (original == copy)
            throw new AssertionError("compound must be a new object");

        DriverCommand origChild = original.iterator().next();
        DriverCommand copyChild = copy.iterator().next();
        if (origChild == copyChild)
            throw new AssertionError("children must be new objects");

        original.addCommand(new OperateToCommand(99, 99));
        if (copy.getCommandCount() != 2)
            throw new AssertionError("copy must not be affected by changes to original");

        System.out.println("DeepCopyTest PASSED.");
    }
}
