// plugin package
package net.runelite.client.plugins.arthwin;

// config imports
import java.awt.Color;
import java.awt.Dimension;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigGroup;

// plugin config
@ConfigGroup("arthwin")
public interface ArthwinConfig extends Config
{
    // define configurations here

    // example booleanConfig
    @ConfigItem
    (
        position = 1,
        keyName = "booleanConfig",
        name = "Boolean Checkbox",
        description = "Simple example of a checkbox to store a booleans value"
    )
    default boolean booleanConfig() { return false; }

    // example intConfig
    @ConfigItem(
        position = 2,
        keyName = "intConfig",
        name = "Int Spinner",
        description = "Simple example of a spinner to store integers"
    )
    default int intConfig() { return 1; }

    // example stringConfig
    @ConfigItem(
        position = 3,
        keyName = "stringConfig",
        name = "String Textbox",
        description = "Simple example of a textbox to store strings"
    )
    default String stringConfig() { return ""; }

    // example colorConfig
    @ConfigItem(
        position = 4,
        keyName = "colorConfig",
        name = "Color Selector",
        description = "Simple example of a color selector"
    )
    default Color colorConfig() { return Color.GREEN; }

    // example enumConfig
    enum OptionEnum
    {
        OPTION1,
        OPTION2,
        OPTION3
    }
    @ConfigItem(
        position = 5,
        keyName = "enumConfig",
        name = "Combobox Enum",
        description = "Simple example of a combobox to select from a list"
    )
    default OptionEnum enumConfig() { return OptionEnum.OPTION1; }

    // example dimensionConfig
    @ConfigItem(
        position = 6,
        keyName = "dimensionConfig",
        name = "Int Dimension",
        description = "Simple example of a dimension to select to integer values"
    )
    default Dimension dimensionConfig() { return new Dimension(765, 503); }
}