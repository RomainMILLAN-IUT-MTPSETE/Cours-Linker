package fr.skytor.studio.manager;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class embedBuilder {

    public static MessageEmbed createEmbedBuilder(String titleName, String description){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor("Bureau Des Etudiant - Sète");
        embed.setTitle(titleName);
        embed.setDescription(description);
        embed.addBlankField(true);
        embed.setFooter("Made by Skytor-Studio & Wabezeter");

        return embed.build();
    }

    public static MessageEmbed devoirEmbedBuilder(String matiere, String devoirAFaire, String pieceJointes, String date){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("**" + matiere + "**");
        embed.setDescription(devoirAFaire);
        embed.addField("Pièces jointes:", pieceJointes, false);
        embed.addBlankField(true);
        embed.setFooter("Pour le " + date);
        embed.setColor(new Color(113,199,165));

        return embed.build();
    }

    public static MessageEmbed embedBuilderErrorPerms(){
        EmbedBuilder embedErrorPerm = new EmbedBuilder();
        embedErrorPerm.setAuthor("Bureau Des Etudiant - Sète");
        embedErrorPerm.setTitle("__**ERROR**: Permissions__");
        embedErrorPerm.setDescription(" > Désolé, vous n'avez pas la permission d'utiliser cette commande");
        embedErrorPerm.addBlankField(true);
        embedErrorPerm.setFooter("Made by Skytor-Studio & Wabezeter");

        return embedErrorPerm.build();
    }

    public static MessageEmbed embedBuilderErrorCmd(String command){
        EmbedBuilder embedErrorCmd = new EmbedBuilder();
        embedErrorCmd.setAuthor("Bureau Des Etudiant - Sète");
        embedErrorCmd.setTitle("__**ERROR**: Command__");
        embedErrorCmd.setDescription(" > Désoler, la commande que vous avez effectué n'existe pas !\n\n **La commande à utiliser :** \n     🔲 " + command);
        embedErrorCmd.addBlankField(true);
        embedErrorCmd.setFooter("Made by Skytor-Studio & Wabezeter");

        return embedErrorCmd.build();
    }

    public static MessageEmbed embedBuilderErrorConfiguration(String configName){
        EmbedBuilder embedErrorConfiguration = new EmbedBuilder();
        embedErrorConfiguration.setAuthor("Bureau Des Etudiant - Sète");
        embedErrorConfiguration.setTitle("__**ERROR**: Configuration__");
        embedErrorConfiguration.setDescription(" > Désoler, la commande n'as pas été activé dans la configuration\n\n **Ligne de Configuration :**\n    🔲 " + configName);
        embedErrorConfiguration.addBlankField(true);
        embedErrorConfiguration.setFooter("Made by Skytor-Studio & Wabezeter");

        return embedErrorConfiguration.build();
    }
    
}
