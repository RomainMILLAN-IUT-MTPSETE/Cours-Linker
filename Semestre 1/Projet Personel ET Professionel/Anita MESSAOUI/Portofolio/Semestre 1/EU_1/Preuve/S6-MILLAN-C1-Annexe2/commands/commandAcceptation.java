package fr.skytor.studio.commands;

import fr.skytor.studio.Start;
import fr.skytor.studio.manager.embedBuilder;
import fr.skytor.studio.manager.logger;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandAcceptation extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        Role admin = e.getGuild().getRoleById("886543544666451999");

        if(e.getMessage().getContentRaw().startsWith(Start.prefix + "accept")){
            String not = "886835557899046934";
            String members = "884763930696757329";
            String a1 = "886549069525295124";
            String a2 = "886549109199228978";
            String a3 = "886549137091346512";
            String s6 = "886101069883650088";
            String prof = "887995381978378291";
            String[] args = e.getMessage().getContentRaw().split(" ");

            //s!accept @Wabezeter A1 Romain M.
            if(args.length >= 2 || args[0].equalsIgnoreCase(Start.prefix + "accept")){
                if(e.getMember().getRoles().contains(admin)){
                    System.out.println("0 :" + args[0]);
                    System.out.println("1 :" + args[1]);
                    System.out.println("2 :" + args[2]);
                    System.out.println("3 :" + args[3]);
                    System.out.println("4 :" + args[4]);
                    e.getGuild().addRoleToMember(args[1], e.getJDA().getRoleById(members)).queue();
                    e.getGuild().addRoleToMember(args[1], e.getJDA().getRoleById(s6)).queue();
                    e.getGuild().removeRoleFromMember(args[1], e.getJDA().getRoleById(not)).queue();
                    if(args[2].equalsIgnoreCase("a1")){
                        e.getGuild().addRoleToMember(args[1], e.getJDA().getRoleById(a1)).queue();
                    }else if(args[2].equalsIgnoreCase("a2")){
                        e.getGuild().addRoleToMember(args[1], e.getJDA().getRoleById(a2)).queue();
                    }else if(args[2].equalsIgnoreCase("a3")){
                        e.getGuild().addRoleToMember(args[1], e.getJDA().getRoleById(a3)).queue();
                    }else if(args[2].equalsIgnoreCase("prof")){
                        e.getGuild().addRoleToMember(args[1], e.getJDA().getRoleById(prof)).queue();
                    }else {
                        e.getMember().getUser().openPrivateChannel().queue(channel -> {
                            channel.sendMessageEmbeds(embedBuilder.embedBuilderErrorCmd("s!accept <id_of_user> <a1/a2/a3/prof> <Name>")).queue();
                        });
                    }
                    String p = args[3];
                    String n = args[4];
                    String pn = p + " " + n;
                    System.out.println(pn);
                    e.getGuild().retrieveMemberById(args[1]).complete().modifyNickname(pn).queue();                    
                }else {
                    e.getMessage().delete().queue();
                    logger.log(e.getGuild(), "**Accept Command**", e.getMember().getAsMention() + " A essayer d'effectuer la commande : \n\n - '" + e.getMessage().getContentRaw() + "'");
                }
            }
        }else if(e.getMessage().getContentRaw().startsWith(Start.prefix + "reload")){
            if(e.getMember().getRoles().contains(admin)){
                e.getGuild().getTextChannelById("886583692292677662").sendMessageEmbeds(embedBuilder.createEmbedBuilder("__**Join or Quit** | Comment rentrer sur le serveur ?__", " - Pour pouvoir avoir accès au serveur du B.U.T. Informatique de l'I.U.T. Montpellier/Sète [***Site de Sète***], merci de mettre après ceci un meessage comme celui ci-joint.\n Cependant avant de faire vôtre message merci de bien vouloir lire le règlement !.\n Si vous n'avez pas acceptez les règles nous ne vous accepterons pas sur le serveur discord.\n\n\n  - **Le message à envoyer :**\n 🔲 'Prénom + 1er Lettre de vôtre Nom de famille + Année d'étude [A1/A2/A3] + Classe [S1/S2/S3/S4/S5/S6]'")).queue();
                logger.log(e.getGuild(), "**Reload Command**", e.getMember().getAsMention() + " A effectuer la commande : \n\n - '" + e.getMessage().getContentRaw() + "'");
            }else {
                e.getMessage().delete().queue();
                logger.log(e.getGuild(), "**Reload Commande**", e.getMember().getAsMention() + " A essayer d'effectuer la commande : \n\n - '" + e.getMessage().getContentRaw() + "'");
            }
        }
    }

}
