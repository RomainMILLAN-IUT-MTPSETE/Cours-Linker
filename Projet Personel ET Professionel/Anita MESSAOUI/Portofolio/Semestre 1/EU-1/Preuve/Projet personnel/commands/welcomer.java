package fr.skytor.studio.commands;

import fr.skytor.studio.manager.embedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class welcomer extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        e.getGuild().getTextChannelById("886548570327621634").sendMessage("Bonjour et bienvenue aux " + e.getGuild().getRoleById("886835557899046934").getAsMention() + ", merci de suivre les instruction dans : " + e.getGuild().getTextChannelById("886583692292677662").getAsMention()).queue();
        e.getUser().openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessageEmbeds(embedBuilder.createEmbedBuilder("**Welcome** | B.U.T. INFO Discord", " > Bienvenue à toi sur le serveur du B.U.T. Informatique à Sète, si tu veut avoir accès au serveur vas dans le salon sécurité [ " + e.getGuild().getTextChannelById("886583692292677662").getAsMention() + " ]")).queue();
        });
    }


}
