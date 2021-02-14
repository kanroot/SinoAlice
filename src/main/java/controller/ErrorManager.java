package controller;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
public class ErrorManager {

    public static void errorCommand(MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Command not found, please see the commands (!h)");
        info.setColor(Color.red);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
    }

    public static void errorNightmare(MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("ERROR BEEP BEEP! \n" +
                "Nightmare searched not found, please use \"!n all\" for see all names.");
        info.setColor(Color.red);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
    }

    public static void errorWeapon(MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("ERROR BEEP BEEP! \n" +
                "Weapon searched not found, please use \"!w all\" for see all names.");
        info.setColor(Color.red);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
    }

    public static void errorArmor(MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("ERROR BEEP BEEP! \n" +
                "Armor searched not found, please use \"!a all\" for see all names.");
        info.setColor(Color.red);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
    }

}
