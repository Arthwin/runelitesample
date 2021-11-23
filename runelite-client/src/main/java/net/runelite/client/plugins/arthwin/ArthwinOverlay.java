// plugin package
package net.runelite.client.plugins.arthwin;

// overlay imports
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

// plugin overlay
class ArthwinOverlay extends Overlay
{
    // define needed variables
    private final PanelComponent panelComponent = new PanelComponent();

    // these are needed for the example
    private final Client client;
    private final ArthwinConfig config;

    // overlay constructor
    @Inject
    private ArthwinOverlay(Client client, ArthwinConfig config)
    {
        // define position
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);

        // initialize needed variables

        // these are needed for the example
        this.config = config;
        this.client = client;
    }

    // render overlay
    @Override
    public Dimension render(Graphics2D graphics)
    {
        // clear panel
        panelComponent.getChildren().clear();

        // define overlay here

        // build the  title
        String overlayTitle = "Arthwin";
        panelComponent.getChildren().add(TitleComponent.builder()
            .text(overlayTitle)
            .color(Color.GREEN)
            .build());

        // set the size of the overlay (width)
        panelComponent.setPreferredSize(new Dimension(
                graphics.getFontMetrics().stringWidth(overlayTitle) + 30,
                0));

        // add a line on the overlay for world number
        // these are needed for the example which provides communication with the configuration
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Number:")
            .right(Integer.toString(config.intConfig()))
            .build());

        // return the panel
        return panelComponent.render(graphics);
    }
}
