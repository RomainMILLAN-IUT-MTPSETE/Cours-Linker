package fr.skytor.studio.commands;

import java.awt.Color;

import fr.skytor.studio.Start;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;

public class commandAnnonce extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "annonce")){
            Role adminRole = e.getGuild().getRoleById("886543544666451999");

            if(e.getMember().getRoles().contains(adminRole)){
                e.getMessage().delete().queue();
                EmbedBuilder annonce = new EmbedBuilder();

                annonce.setThumbnail(e.getGuild().getMemberById("891950703520649226").getUser().getAvatarUrl());
                annonce.setTitle("__**Annonce** - B.D.E. Sète__");
                annonce.setDescription(e.getMessage().getContentRaw().substring(9));
                annonce.setFooter("Made by Skytor-Studio & Wabezeter");

                e.getGuild().getTextChannelById("884765368525139998").sendMessageEmbeds(annonce.build()).queue();
                e.getGuild().getTextChannelById("884765368525139998").sendMessage("|| " + e.getGuild().getRoleById("884763930696757329").getAsMention() + " ||").queue();

                System.out.println(Start.looger + "Nouvelle Annonce => " + e.getMessage().getContentRaw().substring(9));
            }else {
                e.getMember().getUser().openPrivateChannel().queue(channel -> {
                    e.getMessage().delete().queue();
                    String command = "s!annonce";
                    EmbedBuilder errorHowToValidate = new EmbedBuilder();

                    errorHowToValidate.setThumbnail(e.getGuild().getMemberById("891950703520649226").getUser().getAvatarUrl());
                    errorHowToValidate.setTitle("**Error** - Annonce");
                    errorHowToValidate.setDescription("*Vous ne pouvez pas effectuer la commande voulu !*");
                    errorHowToValidate.addField("La commande :", command, true);
                    errorHowToValidate.setFooter("Made by Skytor-Studio & Wabezeter");
                    errorHowToValidate.setColor(Color.RED);

                    channel.sendMessageEmbeds(errorHowToValidate.build()).queue();
                    System.out.println(Start.looger + "Erreur commande Annonce - " + e.getMember().getNickname());

                });
            }
        }
    }
    
}
