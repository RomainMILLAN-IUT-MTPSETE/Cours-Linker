package fr.skytor.studio.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import fr.skytor.studio.manager.logger;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.Objects;

public class commandDM extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "dm")){
            Role members = e.getGuild().getRoleById("884763930696757329");
            System.out.println(members);
            if(Objects.requireNonNull(e.getMember()).getRoles().contains(members)){
                e.getMessage().delete().queue();
                String[] args = e.getMessage().getContentRaw().split(" ");
                String message = "";
                Member membre = e.getGuild().retrieveMemberById(args[1]).complete();
                System.out.println(args.length);
                System.out.println(args[2]);
                for(int i=2; i< args.length; i++){
                    message = message + " " + args[i];
                }
                String mes = message;
                System.out.println(mes);
                //s!dm @Wabezeter Test juste trkl reste !
                //s!dm Wabezeter tesfzri nri nsnf ezsncdso
                System.out.println(e.getMember().getUser().getAsMention());
                e.getMember().getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessageEmbeds(embedBuilder.createEmbedBuilder("**Direct Message**", " - Tu vient d'envoyer un message à " + membre.getAsMention() + ". \n\n - **Le message :**\n 🔲 " + mes)).queue();
                    // logger.log(e.getGuild(), "**Direct Message**", e.getMember().getAsMention() + " vient d'envoyer un message à " + e.getGuild().getMemberById(args[1]).getAsMention() + ". \n\n - **Le message :**\n 🔲 " + mes);
                });
                // e.getGuild().retrieveMemberById(e.getMember().getId()).complete().getUser().openPrivateChannel().queue(channel -> {
                //     channel.sendMessageEmbeds(embedBuilder.createEmbedBuilder("**Direct Message**", " - Tu vient d'envoyer un message à " + e.getGuild().getMemberById(args[1]).getAsMention() + ". \n\n - **Le message :**\n 🔲 " + mes)).complete();
                //     // logger.log(e.getGuild(), "**Direct Message**", e.getMember().getAsMention() + " vient d'envoyer un message à " + e.getGuild().getMemberById(args[1]).getAsMention() + ". \n\n - **Le message :**\n 🔲 " + mes);
                // });
                System.out.println(e.getGuild().retrieveMemberById(args[1]).complete().getAsMention());
                // e.getGuild().getMemberById(args[1]).getUser().openPrivateChannel().queue(channel -> {
                //     channel.sendMessageEmbeds(embedBuilder.createEmbedBuilder("**Direct Message** - From : " + e.getGuild().getMemberById(args[1]).getNickname(), " - " + mes)).queue();
                // });
                e.getGuild().retrieveMemberById(args[1]).complete().getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessageEmbeds(embedBuilder.createEmbedBuilder("**Direct Message** - From : " + e.getMember().getNickname(), " - " + mes)).queue();
                });
            }else {
                e.getMember().getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessageEmbeds(embedBuilder.embedBuilderErrorPerms()).queue();
                    logger.log(e.getGuild(), "**Error - DM**", e.getMember().getAsMention() + " A essayer d'effectuer la commande s!dm, cependant il n'as pas la permission !");
                });
            }
        }
    }

}
