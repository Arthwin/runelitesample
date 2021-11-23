// plugin package
package net.runelite.client.plugins.arthwin;

// panel imports
import lombok.extern.slf4j.Slf4j;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.PluginPanel;
import java.lang.reflect.InvocationTargetException;
import net.runelite.client.ui.components.PluginErrorPanel;

// plugin panel
@Slf4j
class ArthwinPanel extends PluginPanel
{
    void init() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException
    {
        // build panel here

        // example text title
        setBorder(new EmptyBorder(10, 10, 10, 10));
        final PluginErrorPanel errorPanel = new PluginErrorPanel();
        errorPanel.setBorder(new EmptyBorder(10, 25, 10, 25));
        errorPanel.setContent("Arthwin Panel", "Simple panel example");
        add(errorPanel, BorderLayout.NORTH);
    }
}
