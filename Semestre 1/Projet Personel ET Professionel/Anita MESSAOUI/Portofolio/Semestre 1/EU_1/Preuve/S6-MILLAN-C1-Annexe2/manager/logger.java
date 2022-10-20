package fr.skytor.studio.manager;

import fr.skytor.studio.Start;
import net.dv8tion.jda.api.entities.Guild;

public class logger {

    public static void logChannel(Guild guild, String titleName, String description){
        guild.getTextChannelById("886551244234182697").sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**LOGGER**__: " + titleName, description)).queue();
    }

    public static void logConsole(String titleName, String description){
        System.out.println(Start.looger + titleName + " | " + description);
    }

    public static void log(Guild guild, String titleName, String description){
        guild.getTextChannelById("886551244234182697").sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**LOGGER**__: " + titleName, description)).queue();
        System.out.println(Start.looger + titleName + " | " + description);
    }
    
}
