package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.events.MouseClickDrawPanelListener;

import javax.swing.*;

public class MouseClickFeature implements IFeature {

    private static MouseClickDrawPanelListener mouseListener;

    @Override
    public void setup(Application application) {
        JPanel panel = application.getFreePanel();

        mouseListener = new MouseClickDrawPanelListener(DriverFeature.getDriverManager());
        panel.addMouseListener(mouseListener);

    }
    @Override
    public String getName() { return "Mouse Click"; }
}