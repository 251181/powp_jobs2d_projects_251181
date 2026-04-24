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

        application.addComponentMenu(MouseClickFeature.class, "Mouse Click");
        application.addComponentMenuElement(MouseClickFeature.class,"Toggle mode (Draw / Set Position)",e -> mouseListener.toggleMode());
    }
    @Override
    public String getName() { return "Mouse Click"; }
}