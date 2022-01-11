package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandEDT extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "edt")){
            e.getChannel().sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Emploie du Temps**__", "*Vous pouvez retrouvez l'emploie du temps sur le lien suivant* \n\n - **Le lien :**\n 🔲 https://proseconsult.umontpellier.fr/direct/?data=9d70788422d098818a1b70d9d14e21834f51f7d91eb3648604d628113e82760dbed8d89011b8db3f565a6eba3fb421d313f6c63370d69630c73e5d47e7b4caa205b671755e2e313accf1c0ae7bea9fe2ffaaa69cbd14fea5a6d0111bfaa17a823cc1c3b4302fc5dd2762be0aa3a53986aa46015363b2752612a410752d15eaafd211eeb7936734e0cd7fd38213cedc0eec845302a004ead06829e11b88069c04e0a1249a51c245e3f446955c31272adc81f1f145cfed024e0e5ecdc219c24b08166c54e36382c1aa3eb0ff5cb8980cdb,1")).queue();
        }
    }

}
