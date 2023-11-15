package ru.bot_hak.bot_tictac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.bot_hak.bot_tictac.config.BotConfig;

@SpringBootApplication
@EnableConfigurationProperties({
		BotConfig.class,
})
public class BotTictacApplication {

	public static void main(String[] args) {

		SpringApplication.run(BotTictacApplication.class, args);
	}

}
