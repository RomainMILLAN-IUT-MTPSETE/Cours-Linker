package fr.skytor.studio.commands;

import fr.skytor.studio.manager.configurator;
import fr.skytor.studio.manager.logger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.EnumSet;

public class QuickVoice extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent e){
        System.out.println(e.getChannelJoined().getId());
        //Public
        if(e.getChannelJoined().getId().equals(configurator.idChannelPublicRoomCreator)){
            //Set of permission to the user
            EnumSet<Permission> allow = EnumSet.of(Permission.MANAGE_CHANNEL, Permission.PRIORITY_SPEAKER, Permission.VOICE_MUTE_OTHERS, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_SPEAK);
            EnumSet<Permission> deny = EnumSet.of(Permission.BAN_MEMBERS, Permission.KICK_MEMBERS);
            //Creating of channel
            e.getGuild().getCategoryById(configurator.idParentPublicRoomCreator).createVoiceChannel("\uD83D\uDCE2 Public Room - " + e.getMember().getEffectiveName()).addMemberPermissionOverride(Long.parseLong(e.getMember().getId()), allow, deny).queue();
            try {
                Thread.sleep(1000);
                //Move player who create the public room
                e.getGuild().moveVoiceMember(e.getMember(), e.getGuild().getVoiceChannelsByName("\uD83D\uDCE2 Public Room - " + e.getMember().getEffectiveName(), false).get(0)).queue();
                logger.log(e.getGuild(), "__**QuickVoice** - Create Voice Channel__", " > Création d'un channel vocal  \n\n - **La Personne :**\n  🔲 " + e.getMember().getAsMention());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent e){
        if(configurator.QuickVoice == true){
            if (e.getChannelLeft().getMembers().isEmpty()){
                if(!(configurator.idDoNotDeleteChannel.contains(e.getChannelLeft().getId()))){
                    e.getChannelLeft().delete().queue();

                    logger.log(e.getGuild(), "__**QuickVoice** | Delete voice channel__", "L'utilisateur " + e.getMember().getAsMention() + ", viens de delete un channel");
                }
            }
        }

    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent e){
        if(configurator.QuickVoice == true){
            if(e.getChannelJoined().getId().equals("798167855669051423")){
                EnumSet<Permission> allow = EnumSet.of(Permission.MANAGE_CHANNEL, Permission.PRIORITY_SPEAKER, Permission.VOICE_MUTE_OTHERS, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_SPEAK);
                EnumSet<Permission> deny = EnumSet.of(Permission.BAN_MEMBERS, Permission.KICK_MEMBERS);
                Category parent = e.getGuild().getCategoryById("707457638514032731");
                parent.createVoiceChannel("\uD83D\uDCE2 Public Room - " + e.getMember().getEffectiveName()).addMemberPermissionOverride(Long.parseLong(e.getMember().getId()), allow, deny).queue();
                try {
                    Thread.sleep(500);
                    e.getGuild().moveVoiceMember(e.getMember(), e.getGuild().getVoiceChannelsByName("\uD83D\uDCE2 Public Room - " + e.getMember().getEffectiveName(), false).get(0)).queue();

                    logger.log(e.getGuild(), "__**QuickVoice** | Create new voice channel__", " Le user " + e.getMember().getAsMention() + ", viens de crée un voice channel.");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }

            if (e.getChannelLeft().getMembers().isEmpty()){
                if(!(configurator.idDoNotDeleteChannel.contains(e.getChannelLeft().getId()))){
                    e.getChannelLeft().delete().queue();

                    logger.log(e.getGuild(), "__**QuickVoice** | Delete voice channel__", "L'utilisateur " + e.getMember().getAsMention() + ", viens de delete un channel");
                }
            }
        }

    }

}
