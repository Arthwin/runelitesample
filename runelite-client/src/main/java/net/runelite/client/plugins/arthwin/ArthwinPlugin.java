
// plugin package
package net.runelite.client.plugins.arthwin;

// plugin imports
import javax.inject.Inject;
import com.google.inject.Provides;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.PluginDescriptor;
import java.awt.image.BufferedImage;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.overlay.OverlayManager;

// plugin descriptor
@PluginDescriptor(
        name = "Arthwin",
        description = "Example plugin description",
        tags = {"cool", "meaningfull", "tags", "arthwin"},
        loadWhenOutdated = true
)
public class ArthwinPlugin extends Plugin
{

    // inject panel (order matters)
    @Inject
    private ClientToolbar clientToolbar;
    private ArthwinPanel panel;
    private NavigationButton navButton;

    // inject overlay
    @Inject
    private OverlayManager overlayManager;
    private ArthwinOverlay overlay;

    // inject configuration
    @Inject
    private ArthwinConfig config;
    @Provides
    ArthwinConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(ArthwinConfig.class);
    }

    // plugin startup
    @Override
    protected void startUp() throws Exception
    {
        // add panel
        panel = injector.getInstance(ArthwinPanel.class);
        panel.init();
        final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "lnn.png");
        navButton = NavigationButton.builder()
                .tooltip("Arthwin")
                .icon(icon)
                .priority(0)
                .panel(panel)
                .build();
        clientToolbar.addNavigation(navButton);

        // add overlay
        overlayManager.add(overlay);

        // do main stuff
    }

    // plugin shutdown
    @Override
    protected void shutDown() throws Exception
    {
        // remove overlay
        overlayManager.remove(overlay);

        // remove panel
        clientToolbar.removeNavigation(navButton);
    }

    // configuration changed
    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (event.getGroup().equals("arthwin"))
        {
            // do config stuff
        }
    }
}
