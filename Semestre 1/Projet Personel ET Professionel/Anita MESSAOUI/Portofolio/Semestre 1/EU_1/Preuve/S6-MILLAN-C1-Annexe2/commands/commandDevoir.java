package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandDevoir extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "devoir")){
            //s!devoir <a1/a2/a3> [Mat] [Date] [Piece Jointes] [Devoir]
            String[] args = e.getMessage().getContentRaw().split(" ");

            if(args[1].equalsIgnoreCase("a1")){
                String devoirIdChannel = "893423243904581682";
                String matiere = args[2];
                String date = args[3];
                String pieceJointe = args[4];
                String devoir = e.getMessage().getContentRaw().substring(args[0].length() + args[1].length() + args[2].length() + args[3].length() + args[4].length() + 5);
                e.getGuild().getTextChannelById(devoirIdChannel).sendMessageEmbeds(embedBuilder.devoirEmbedBuilder(matiere, devoir, pieceJointe, date)).queue();
                e.getMessage().delete().queue();

            }else if (args[1].equalsIgnoreCase("a2")){
                e.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessageEmbeds(embedBuilder.embedBuilderErrorPerms()).queue();
                });
            }else if(args[1].equalsIgnoreCase("a3")){
                e.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessageEmbeds(embedBuilder.embedBuilderErrorPerms()).queue();
                });
            }else {
                e.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessageEmbeds(embedBuilder.embedBuilderErrorPerms()).queue();
                });
            }
        }


    }

}
