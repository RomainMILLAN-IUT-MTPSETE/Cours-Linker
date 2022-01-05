package fr.skytor.studio;

import fr.skytor.studio.commands.*;
import fr.skytor.studio.manager.configurator;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Start {

    public static String version = "1.5";
    public static String bdesete = "[B.D.E. - BOT] - ";
    public static String looger = "[SS] / ";

    public static String prefix = "s!";

    public static void main(String[] args) throws LoginException{
        System.out.println(looger + "Logining ...");
        JDA jda = JDABuilder.createDefault("ODkxOTUwNzAzNTIwNjQ5MjI2.YVFz0w.aFmSKoDb4HhnrEZfGeh893pP-4o").setIdle(true).setActivity(Activity.playing("Bureau des Etudiants - by Skytor-Studio")).build();
        System.out.println(looger + "B.D.E. BOT - login at version : " + version);

        jda.addEventListener(new commandEDT());
        jda.addEventListener(new commandAnnonce());
        jda.addEventListener(new commanndHelper());
        jda.addEventListener(new commandWebsite());
        jda.addEventListener(new commandAcceptation());
        jda.addEventListener(new commandLink());
        jda.addEventListener(new commandDM());
        jda.addEventListener(new welcomer());
        jda.addEventListener(new QuickVoice());
        jda.addEventListener(new commandDevoir());





        //Adding in idDoNotDelete
        //Public
        configurator.idDoNotDeleteChannel.add("884764714683473921");
        configurator.idDoNotDeleteChannel.add("903929707223978065");
        configurator.idDoNotDeleteChannel.add("884767910084636692");

        //3eme Annee
        configurator.idDoNotDeleteChannel.add("886578585098416139");
        configurator.idDoNotDeleteChannel.add("886578611014995999");

        //2eme Annee
        configurator.idDoNotDeleteChannel.add("886578330940375060");
        configurator.idDoNotDeleteChannel.add("886578436070572112");

        //1er Annee
        configurator.idDoNotDeleteChannel.add("886577983396134912");
        configurator.idDoNotDeleteChannel.add("886578175373639680");
        configurator.idDoNotDeleteChannel.add("892673797377884181");
        configurator.idDoNotDeleteChannel.add("892673979544915968");
        configurator.idDoNotDeleteChannel.add("892763918437597267");
        configurator.idDoNotDeleteChannel.add("892766012242546718");

        //Aide - 1er Annee
        configurator.idDoNotDeleteChannel.add("893547656549380158");
        configurator.idDoNotDeleteChannel.add("893536658014756944");
        configurator.idDoNotDeleteChannel.add("893536805431967765");
        configurator.idDoNotDeleteChannel.add("893536982213464075");

        //Cours - 1er Annee
        configurator.idDoNotDeleteChannel.add("907968873272328242");
        configurator.idDoNotDeleteChannel.add("907986220213235814");

        //Projet SAE - 1.01
        //Line:
        configurator.idDoNotDeleteChannel.add("915247383154147348");
        //Channel:
        configurator.idDoNotDeleteChannel.add("915247449734537266");

        //Projet SAE - 1.03
        //Line:
        configurator.idDoNotDeleteChannel.add("917316440409931776");
        //Channel:
        configurator.idDoNotDeleteChannel.add("917316423532044328");

        //Projet SAE - 1.04
        //Line:
        configurator.idDoNotDeleteChannel.add("913334377075851265");
        //Channel:
        configurator.idDoNotDeleteChannel.add("914787719618633769");
        configurator.idDoNotDeleteChannel.add("914787743794626600");

        //Projet SAE - 1.05
        //Line:
        configurator.idDoNotDeleteChannel.add("910569294675476560");
        //Channel:
        configurator.idDoNotDeleteChannel.add("914786900181663777");
        configurator.idDoNotDeleteChannel.add("912999447858929664");
        configurator.idDoNotDeleteChannel.add("914786867151507506");

        //OTHERS => configurator.idDoNotDeleteChannel.add("");
    }


}
