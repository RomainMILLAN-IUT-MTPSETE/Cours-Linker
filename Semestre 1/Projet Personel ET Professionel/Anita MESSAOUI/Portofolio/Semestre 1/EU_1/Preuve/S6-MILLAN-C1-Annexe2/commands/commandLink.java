package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import fr.skytor.studio.manager.logger;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandLink  extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        Role members = e.getGuild().getRoleById("884763930696757329");
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "drive")){
            if(e.getMember().getRoles().contains(members)){
                String[] args = e.getMessage().getContentRaw().split(" ");
                System.out.println(args.length);
                if(args.length ==2){
                    if(args[1].equalsIgnoreCase("a1")){
                        e.getMessage().getChannel().sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Google Drive** | Drive de Classe__", " - *Voici le drive de classe:* \n\n - **Le lien :**\n 🔲 'https://drive.google.com/drive/folders/1aAnyJtei-hNaPNkbXH5ghg4ZIA965vcW?usp=sharing'")).queue();
                        logger.log(e.getGuild(), "**Command - Drive**", e.getAuthor().getAsMention() + "A effectuer la commande s!drive A1.");
                    }else if(args[1].equalsIgnoreCase("a2")){
                        e.getMessage().getChannel().sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Google Drive** | Drive de Classe__", " - *Voici le drive de classe:* \n\n - **Le lien :**\n 🔲 'ERROR'")).queue();
                        logger.log(e.getGuild(), "**Command - Drive**", e.getAuthor().getAsMention() + "A effectuer la commande s!drive A2.");
                    }else if(args[1].equalsIgnoreCase("a3")){
                        e.getMessage().getChannel().sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Google Drive** | Drive de Classe__", " - *Voici le drive de classe:* \n\n - **Le lien :**\n 🔲 'ERROR'")).queue();
                        logger.log(e.getGuild(), "**Command - Drive**", e.getAuthor().getAsMention() + "A effectuer la commande s!drive A3.");
                    }else {
                        e.getMember().getUser().openPrivateChannel().queue(channel -> {
                            channel.sendMessageEmbeds(embedBuilder.embedBuilderErrorCmd(Start.prefix + "drive <a1/a2/a3>")).queue();
                            logger.log(e.getGuild(), "**ERROR - Drive**", e.getAuthor().getAsMention() + "A voulu effectuer la commande s!drive, mais c'est tromper dans la commande !");
                        });
                    }
                }else {
                    e.getMember().getUser().openPrivateChannel().queue(channel -> {
                        channel.sendMessageEmbeds(embedBuilder.embedBuilderErrorCmd(Start.prefix + "drive <a1/a2/a3>")).queue();
                        logger.log(e.getGuild(), "**ERROR - Drive**", e.getAuthor().getAsMention() + "A voulu effectuer la commande s!drive, mais c'est tromper dans la commande !");
                    });
                }
                
            }else {
                e.getMember().getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessageEmbeds(embedBuilder.embedBuilderErrorPerms()).queue();
                    logger.log(e.getGuild(), "**Error - Drive**", e.getMember().getAsMention() + " A essayer d'effectuer la commande s!drive, cependant il n'as pas la permission !");
                });
            }
        }
    }

}
