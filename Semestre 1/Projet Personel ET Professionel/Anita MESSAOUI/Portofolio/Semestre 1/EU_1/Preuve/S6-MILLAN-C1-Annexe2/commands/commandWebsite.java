package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandWebsite extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "website")){
            e.getMessage().getChannel().sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Website** - BUT-Info__", "*Voici le site de du B.U.T. Informatique de Sète*\n\n - **Le lien:**\n 🔲 'https://but-info.wdss.eu/'")).queue();
        }
    }

}
