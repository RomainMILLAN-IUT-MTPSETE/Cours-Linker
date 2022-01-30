package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commanndHelper extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "helper")){
            e.getMessage().getChannel().sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Helper** -  B.D.E. Bot__", "*Voici le helper du BDE BOT, ici vous retrouverai toutes les commandes du bot :* \n\n\n - **l'Emploie du temps:**\n 🔲 's!edt'\n\n - **Le site internet:**\n 🔲 's!website'\n\n - **Les DM:**\n 🔲 's!dm <id_of_user> [message]'\n\n - **Les Annonces:**\n 🔲 's!annonce [message]'\n\n - **Les Acceptations:**\n 🔲 's!accept [ID_of user] <a1/a2/a3/prof> <prenon> <1er_lettre_nom>'\n\n - **Les Devoirs:**\n 🔲 's!devoirs <add> [id] [mat] [date] [name]")).queue();
        }
    }

}
