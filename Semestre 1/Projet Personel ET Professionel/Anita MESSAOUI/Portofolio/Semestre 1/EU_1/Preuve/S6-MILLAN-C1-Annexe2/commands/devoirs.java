package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import fr.skytor.studio.manager.logger;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Objects;

public class devoirs extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "devoirs")){
            Role members = e.getGuild().getRoleById("884763930696757329");

            if(Objects.requireNonNull(e.getMember()).getRoles().contains(members)){
                //s!devoirs <add> [id] [mat] [date] [name]
                //s!devoirs add 057895145218652 Prog 07/08/2021 Faire l'ex 1
                String[] args = e.getMessage().getContentRaw().split(" ");

                if(args.length <= 3){
                    e.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                        privateChannel.sendMessageEmbeds(embedBuilder.embedBuilderErrorCmd("s!devoirs <add> [id] [mat] [date] [name]")).queue();
                        logger.log(e.getGuild(), "**Devoirs** Command", e.getMember().getAsMention() + " a essayer d'utiliser la commande : " + e.getMessage().getCategory() + " mais c'est trompé dans la syntaxe !");
                    });
                }else {
                    if(args[1].equalsIgnoreCase("add")){
                        e.getMessage().delete().queue();
                        String matiere = args[3].toString();
                        String date = args[4].toString();
                        String idDevoirs = "893423243904581682";
                        String idRoleA1 = "886549069525295124";
                        String idMat = args[2].toString();
                        System.out.println(args.length);
                        System.out.println(args[2]);
                        String message = "";
                        for(int i=5; i< args.length; i++){
                            message = message + " " + args[i];
                        }
                        String mes = message;
                        Objects.requireNonNull(e.getGuild().getTextChannelById(idDevoirs)).sendMessageEmbeds(embedBuilder.createEmbedBuilder("**" + matiere + "** | Devoirs - " + date, " - Un nouveau devoir à était ajouté pour la matiere : " + matiere + ". \n\n\n - **Devoirs :**\n 🔲 " + mes + "\n\n\n\n || " + e.getGuild().getRoleById(idRoleA1).getAsMention() + " ||")).queue();
                        e.getGuild().getTextChannelById(idMat).sendMessage("> Nouveau devoirs ajouter à *" + matiere + "*. Pour pouvoir consulter le devoirs allez à => " + e.getGuild().getTextChannelById(idDevoirs).getAsMention()).queue();
                        logger.log(e.getGuild(), "**Devoirs** Command", " - Une personne à utiliser la commande 's!devoirs' [" + e.getMember().getAsMention() + "]");
                    }else {
                        e.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                            privateChannel.sendMessageEmbeds(embedBuilder.embedBuilderErrorCmd("s!devoirs <add> [id] [mat] [date] [name]")).queue();
                            logger.log(e.getGuild(), "**Devoirs** Command", e.getMember().getAsMention() + " a essayer d'utiliser la commande : " + e.getMessage().getCategory() + " mais c'est trompé dans la syntaxe !");
                        });
                    }
                }
            }else {
                e.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessageEmbeds(embedBuilder.embedBuilderErrorPerms()).queue();
                    logger.log(e.getGuild(), "**Devoirs** Command", e.getMember().getAsMention() + " à essayer d'utiliser la commande : " + e.getMessage().getContentRaw().toString());
                });
            }
        }
    }

}
