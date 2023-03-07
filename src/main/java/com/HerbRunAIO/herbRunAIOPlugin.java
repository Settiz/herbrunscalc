package com.HerbRunAIO;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Slf4j
@PluginDescriptor(
		name = "Herb Run AIO",
		description = "Herb run profit and tracking.",
		tags = {"herbs, herb, farming, overlay, profit, tracking, data"}
)

public class herbRunAIOPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private com.HerbRunAIO.herbRunAIOConfig herbRunAIOConfig;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Notifier notifier;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;


	@Provides
	com.HerbRunAIO.herbRunAIOConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(com.HerbRunAIO.herbRunAIOConfig.class);
	}

	@Override
	protected void startUp() throws Exception {
		log.info("Herb Run AIO Started!");
		initialiseCollection();

		panel = new herb
	}


	private	void initialiseCollection() {
		herbRunAIOConfig herbRunAIOConfig = configManager.getConfig(com.HerbRunAIO.herbRunAIOConfig.class);

	}

	@Override
	protected void shutDown() throws Exception {
		log.info("Herb Run AIO stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged) {
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Herb Run AIO", null);
		}
	}
}



