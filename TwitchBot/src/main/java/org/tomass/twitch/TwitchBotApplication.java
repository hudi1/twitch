package org.tomass.twitch;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tomass.twitch.model.Chatlog;

import com.github.philippheuer.events4j.core.EventManager;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.IRCMessageEvent;

@SpringBootApplication
public class TwitchBotApplication {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppConfig config;
	@Autowired
	private ChatlogService chatlogService;

	public static void main(String[] args) {
		SpringApplication.run(TwitchBotApplication.class, args);
	}

	@Bean
	public EventManager eventManager() {
		EventManager eventManager = new EventManager();
		eventManager.autoDiscovery();
		eventManager.setDefaultEventHandler(SimpleEventHandler.class);

		eventManager.onEvent(IRCMessageEvent.class, event -> {
			if (event.getChannelName().isPresent() && event.getMessage().isPresent()
					&& config.getChatlogs().contains(event.getChannelName().get())) {
				if (event.getCommandType().equals("PRIVMSG")) {
					chatlogService.createChatlog(new Chatlog().withChannel(event.getChannelName().get())
							.withUser(event.getUserName()).withMessage(event.getMessage().get())
							.withTs(LocalDateTime.now()).withOnline(true));
				}
			}

			if (event.getChannelName().isPresent() && config.getFollows().contains(event.getChannelName().get())) {
				if (event.getCommandType().equals("JOIN") || event.getCommandType().equals("PRIVMSG")) {
					if ((config.getUser().equalsIgnoreCase(event.getUserName())) || (event.getMessage().isPresent()
							&& event.getMessage().get().toLowerCase().contains(config.getMessage()))) {
						try {
							File file = new File("/app/log/" + event.getChannelName().get() + ".txt");
							FileWriter fr = new FileWriter(file, true);

							fr.write(LocalDateTime.now().toString() + " ");
							fr.write(event.getUserName() + ": ");
							fr.write(event.getMessage().orElseGet(() -> "join"));
							fr.write(System.getProperty("line.separator"));
							fr.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}

			/*
			 * System.out.println("ClientName: " + event.getClientName().orElseGet(() ->
			 * "null") + " EventId " + event.getEventId() + " UserId " + event.getUserId() +
			 * " UserName " + event.getUserName() + " Message " +
			 * event.getMessage().orElseGet(() -> "null") + " Payload " + event.getPayload()
			 * + " CommandType " + event.getCommandType() + "channel " +
			 * event.getChannelId() + "channel2 " + event.getChannelName());
			 */
		});

		return eventManager;

	}

	@Bean
	public TwitchClient createClient(EventManager eventManager) {

		TwitchClient client = TwitchClientBuilder.builder()
				// .withChatAccount(new OAuth2Credential("twitch",
				// "*"))
				// .withDefaultAuthToken(new OAuth2Credential("twitch",
				// "*"))
				.withEnableChat(true).withEventManager(eventManager).build();

		Set<String> channels = new HashSet<>();
		channels.addAll(config.getFollows());
		channels.addAll(config.getChatlogs());
		channels.add(config.getUser());

		for (String channel : channels) {
			client.getChat().joinChannel(channel);
		}

		logger.info("Connected to " + config.getUser() + " with message " + config.getMessage() + " and "
				+ channels.size() + " follows");
		// client.getChat().sendMessage("*", "*");
		return client;
	}

}
