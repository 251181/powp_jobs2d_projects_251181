package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class MouseClickDrawPanelListener extends MouseAdapter {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public enum ClickMode { DRAW_LINE, SET_POSITION }

    private ClickMode mode = ClickMode.DRAW_LINE;
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

        if (e.getButton() == MouseEvent.BUTTON1) {
            logger.info("Mouse draw line to (" + driverX + ", " + driverY + ")");
            driverManager.getCurrentDriver().operateTo(driverX, driverY);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            logger.info("Mouse set position to (" + driverX + ", " + driverY + ")");
            driverManager.getCurrentDriver().setPosition(driverX, driverY);
        }
    }

    public void toggleMode() {
        mode = (mode == ClickMode.DRAW_LINE) ? ClickMode.SET_POSITION : ClickMode.DRAW_LINE;
        logger.info("Mouse click mode switched to: " + mode);
    }

}