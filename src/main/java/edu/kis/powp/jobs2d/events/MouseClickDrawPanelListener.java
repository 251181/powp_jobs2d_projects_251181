package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import edu.kis.powp.jobs2d.drivers.visitor.VisitableDriver;

public class MouseClickDrawPanelListener extends MouseAdapter {
    private final DriverManager driverManager;

    public MouseClickDrawPanelListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int panelCenterX = e.getComponent().getWidth()  / 2;
        int panelCenterY = e.getComponent().getHeight() / 2;

        int driverX = e.getX() - panelCenterX;
        int driverY = e.getY() - panelCenterY;

        VisitableDriver driver = driverManager.getCurrentDriver();
        if (e.getButton() == MouseEvent.BUTTON1)
            driver.operateTo(driverX, driverY);
        else if (e.getButton() == MouseEvent.BUTTON3)
            driver.setPosition(driverX, driverY);

    }
}