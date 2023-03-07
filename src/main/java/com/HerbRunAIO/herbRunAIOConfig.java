package com.HerbRunAIO;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("herbRunAIOReminder")
public interface herbRunAIOConfig extends Config{
	@ConfigItem(
			keyName = "enableUI",
			name = "Enable Side-Panel",
			description = "Enables side panel UI, provides an interface to view logged data."
	)
	default boolean enableUI()
	{
		return true;
	}

	@ConfigItem(
			position = 1,
			keyName = "useCurrentPrices",
			name = "Use GE prices to calculate profits",
			description =  "Toggle automatic cost/sale price (may not be representative of actual gains.)"
	)
	default boolean useCurrentPrices()
	{
		return true;
	}
}
