package controller;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageManager {

    private static final String keyName = "NAME";

    public static void info(MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Information of bot");
        info.setDescription("All content and materials are trademarks and copyrights of " +
                "[Pokelabo Inc./SQUARE ENIX CO., LTD.] All rights reserved.");
        info.addField("Creator", "By KAN", false);
        info.addField("Version", "1.4.1", false);
        info.setColor(Color.cyan);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
    }

    public static void help(MessageReceivedEvent event) {
        EmbedBuilder helper = new EmbedBuilder();
        helper.setTitle("Helper");
        helper.setImage("https://i.redd.it/lljcy3vj9ei51.png");
        helper.setDescription("**All commands:**"
                + "\n" + "```!helper```"
                + "```!info```"
                + "```!nightmares [all/Pattern to find]```"
                + "```!searchN [number / nightmare's name]```"
                + "```!maxN```"
                + "```!armors [all/Pattern to find]```"
                + "```!searchA [number / Armor's name]```"
                + "```!arm [element][Type](Stat)(number of elements)(optional)```"
                + "```!weapons [all/Pattern to find]```"
                + "```!searchW [number / Weapon's name]```"
                + "```!wpn [element][Type](Stat)(number of elements)(optional)```"
                + "```!storyN [name of skill]```"
                + "```!coloN [name of skill]```"
                + "```!aidW [name of skill]```"
                + "```!coloW [name of skill]```"
                + "```!storyA [name of skill]```"
                + "```!setEfect [name of skill]```"
                + "```!class [name of pj](job)```"
        );
        helper.addField("!helper", "```Show all commands.```", false);
        helper.addField("!info", "```Show all information of bot.```", false);
        helper.addField("!nightmares", "```Show all nightmares and it's number or matched with a user input."
                + "\n" + "Examples:"
                + "\n" + "!nightmares All"
                + "\n" + "!nightmares hound"
                + "\n" + "!nightmares Real Lizard"
                + "\n" + "!nightmares orc```", false);
        helper.addField("!armors", "```Show all armors names and it's number or matched with a user input."
                + "\n" + "Examples:"
                + "\n" + "!armors All"
                + "\n" + "!armors golden"
                + "\n" + "!armors Schoolgirl```", false);
        helper.addField("!weapons", "```Show all weapons names and it's number or matched with a user input"
                + "\n" + "Examples:"
                + "\n" + "!weapons All"
                + "\n" + "!weapons staff"
                + "\n" + "!weapons Book of Observation```", false);
        helper.addField("!searchN", "```Search one nightmare by it's number/name or matched with a user input."
                + "\n" + "!searchN 1" + "\n" +
                "!searchN Flying Magician" +
                "\n!searchN 148" +
                "\n!searchN UGALLU```", false);
        helper.addField("!searchA", "```Search one armor by it's number/name."
                + "\n" + "\nExamples: \n!searchA 1"
                + "\n" + "!searchA Nameless Youth's Hairband (Projectile)"
                + "\n" + "!SearchA 31"
                + "\n" + "!SearchA Nameless Youth's Shoes (Blade)```", false);
        helper.addField("!searchW", "```Search one weapon by it's number/name."
                + "\n" + "!searchW 1" + "\n"
                + "!searchW Origin of Truth"
                + "\n" + "!SearchW 387"
                + "\n" + "!SearchW War Song's Echo```", false);
        helper.addField("!MaxN", "```Show the nightmare with the highest points.```", false);
        helper.addField("!Arm", "```Show all armors filtered by it's element [fire/wind/water/humans] and type [head/body/hands/feet]."
                + "\n" +
                "\nExamples:" + "\n" + "!Arm wind body" +
                "\n!Arm wind Head PDEF " +
                "\n!Arm wind Hands MDEF 1" +
                "\n!Arm wind Feet SETTOTAL 5```", false);
        helper.addField("!Wpn", "```Show all weapons filtered by it's element [fire/wind/water] and type [Instr./polearm/blade/tome/focus/staff/hammer/ranged]."
                + "\n" + "\nExamples:" + "\n!Wpn wind polearm" +
                "\n!Wpn wind Instr. PATK" +
                "\n!Wpn wind polearm PDEF" +
                "\n!Wpn wind blade MATK" +
                "\n!Wpn wind Tome MDEF" +
                "\n!Wpn wind focus TTATK 1" +
                "\n!Wpn wind Staff TTATK 2" +
                "\n!Wpn wind Hammer TTDEF 3" +
                "\n!Wpn wind Ranged PATKTTDEF 4" +
                "\n!Wpn wind Instr. MATKTTDEF 5```", false);
        helper.addField("!storyN", "```Show all nightmares with the Story Skill searched."
                + "\n" + "\nExamples:" + "\n!StoryN Blazing Wildfire (I)" +
                "\n!StoryN Lover's Embrace (II)" +
                "\n!StoryN Song of Camaraderie (II)" +
                "\n!StoryN Engulfing```", false);
        helper.addField("!coloN", "```Show all nightmares with the Colosseum Skill searched."
                + "\n" + "\nExamples:" + "\n!coloN Zephyr Fairy Mastery (II)" +
                "\n!coloN Zephyr" +
                "\n!coloN Tidal Fairy Master (I)" +
                "\n!coloN Tidal Fairy```", false);
        helper.addField("!aidW", "```Show all weapons with the aid Skill searched."
                + "\n" + "\nExamples:" + "\n!aidW Replenish Magic (II)" +
                "\n!aidW M.ATK Debuff (I)" +
                "\n!aidW Replenish Magic (I)" +
                "\n!aidW Support```", false);
        helper.addField("!coloW", "```Show all weapons with the Colosseum Skill searched."
                + "\n" + "\nExamples:" + "\n!coloW Zephyr Fairy Mastery (II)" +
                "\n!coloW Torrent of Destruction (III)" +
                "\n!coloW Blessed Gospel (III)" +
                "\n!coloW Wave```", false);
        helper.addField("!storyA", "```Show all armor with the Story Skill searched."
                + "\n" + "\nExamples:" + "\n!StoryA Blazing Wildfire (I)" +
                "\n!StoryA Instrument Merit" +
                "\n!StoryA Ranged Water Soul" +
                "\n!StoryA Ranged Water Soul```", false);
        helper.addField("!setEfect", "```Show all armor with the set effect searched."
                + "\n" + "\nExamples:" + "\n!coloA Zephyr Fairy Mastery (II)" +
                "\n!coloA Human Hunter's Soul" +
                "\n!coloA Hunter's Soul" +
                "\n!coloA Machine Lifeform and Emil's Hunting Spirit```", false);
        helper.addField("!class", "```Show jobs with the name's pj and job (Mage/Gunner/Alternative" +
                "Half-Nightmare/Minstrel/Sorcerer/Cleric/Paladin/Breaker/Invader/Poacher/Crusher)."
                + "\n" + "\nExamples:" +
                "\n!class 2b" +
                "\n!class 2b breaker" +
                "\n!class alice " +
                "\n!class alice Alternative```", false);
        helper.setColor(Color.pink);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(helper.build()).queue();
    }

    public static void jdaStandard(String title, String url, String description, Color color, MessageReceivedEvent event) {
        EmbedBuilder standard = new EmbedBuilder();
        standard.setTitle(title);
        standard.setImage(url);
        standard.setDescription(description);
        standard.setColor(color);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(standard.build()).queue();
    }

    public static Color jdaColor(String element) {
        Color color;
        switch (element) {
            case "Water":
                color = Color.blue;
                break;
            case "Fire":
                color = Color.red;
                break;
            case "Wind":
                color = Color.green;
                break;
            default:
                color = Color.black;
        }
        return color;
    }

    public static void pestanaNightmare(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        String title = hashMap.get(keyName);
        String url = hashMap.get("IMG");
        String description = "**Story skill**:" + "```fix" + "\n" + hashMap.get("NAMESTORY") + ": "
                + hashMap.get("SKILL") + "```" + "\n" +
                "**Colosseum skill**:" + "```fix" + "\n" + hashMap.get("NAMECOLO") + ": " +
                hashMap.get("COLOSKILL") + "```" + "\n" +
                "**Level**: " + hashMap.get("LVL") + "```ELM"
                + "\n" + "P.Atk: " + hashMap.get("PATK")
                + "\t" + "P.Atk: " + hashMap.get("PDEF")
                + "\t" + "M.Atk: " + hashMap.get("MATK")
                + "\t" + "M.Atk: " + hashMap.get("MDEF")
                + "\t" + "Total: " + hashMap.get("TOTAL") + "```"
                + "\n" + "**Level**: " + hashMap.get("FULLLVL") + "```ELM"
                + "\n" + "P.Akt: " + hashMap.get("PAKTOTAL")
                + "\t" + "P.Def: " + hashMap.get("FULLDEF")
                + "\t" + "Max.ATK: " + hashMap.get("FULLMATK")
                + "\t" + "Max.DEF: " + hashMap.get("FULLMDEF")
                + "\t" + "Total: " + hashMap.get("TOTALMAXLEV") + "```" + "**Others**" + "```ELM"
                + "\n" + "Tt.Atk: " + hashMap.get("TTATK")
                + "\t" + "Tt.Def: " + hashMap.get("TTDEF")
                + "\t" + "PATK+Tt.Def : " + hashMap.get("PATKTTDEF")
                + "\t" + "M.Atk+Tt.Def : " + hashMap.get("MATKTTDEF")
                + "\t" + "Time: " + hashMap.get("TIME")
                + "\t" + "Duration: " + hashMap.get("DURATION") + "```";
        jdaStandard(title, url, description, jdaColor(""), event);
    }

    public static void pestanaArmor(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        String title = hashMap.get(keyName);
        String url = hashMap.get("IMG");
        String description = "**Story skill**: " + "```fix"
                + "\n" + hashMap.get("NAMESKILL") + ": "
                + hashMap.get("SKILL") + "```"
                + "\n" + "**Set  effect**: " + "```fix"
                + "\n" + hashMap.get("NAMECOLO") + ": "
                + hashMap.get("COLOSKILL") + "```"
                + "```ELM" + "\n" + "Element: " + hashMap.get("ELEMENT")
                + "\t" + "Type: " + hashMap.get("TYPE")
                + "\t" + "P.Def: " + hashMap.get("PDEF")
                + "\t" + "M.Def: " + hashMap.get("MDEF")
                + "\t" + "Total: " + hashMap.get("TOTAL") + "```" + "```YAML"
                + "\n" + "Set total: " + hashMap.get("SETTOTAL") + "```";
        jdaStandard(title, url, description, jdaColor(hashMap.get("ELEMENT")), event);
    }

    public static void pestanaWeapons(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        String title = hashMap.get(keyName);
        String url = hashMap.get("IMG");
        String description = "**Colosseum  skill**: " + "```fix"
                + "\n" + hashMap.get("NAMECOLO") + ": "
                + hashMap.get("SKILL") + "```"
                + "\n" + "**Colosseum Aid Skill**: " + "```fix"
                + "\n" + hashMap.get("AID") + ": "
                + hashMap.get("COLOSKILL") + "```" + "\n"
                + "**Level**: " + hashMap.get("LVL") + "```ELM"
                + "\n" + "Type: " + hashMap.get("TYPE")
                + "\t" + "P.Atk: " + hashMap.get("PATK")
                + "\t" + "P.Def: " + hashMap.get("PDEF")
                + "\t" + "M.Atk: " + hashMap.get("MATK")
                + "\t" + "M.Def: " + hashMap.get("MDEF")
                + "\t" + "Total: " + hashMap.get("TOTAL")
                + "\t" + "Tt.ATK: " + hashMap.get("TTATK")
                + "\t" + "Tt.Def: " + hashMap.get("TTDEF")
                + "\t" + "PATK+Tt.Def: " + hashMap.get("PATKTTDEF")
                + "\t" + "M.Atk+Tt.Def: " + hashMap.get("MATKTTDEF") + "```" + "```YAML"
                + "\n" + "Element: " + hashMap.get("ELEMENT") + "```";
        jdaStandard(title, url, description, jdaColor(hashMap.get("ELEMENT")), event);
    }

    public static void pestanaClass(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        String title = hashMap.get(keyName) + "/" + hashMap.get("JOB");
        String url = hashMap.get("IMG");
        String description = "**Primary weapon**: " + "```fix" + "\n" + hashMap.get("PRIMARY") + "```"
                + "\n" + "**Usable weapons**: " + "```fix" + "\n" + hashMap.get("USABLE") + "```" + "\n"
                + "**Level 1**: " + "```fix" + "\n" + hashMap.get("LVL1") + "```"
                + "**Level 2**: " + "```fix" + "\n" + hashMap.get("LVL2") + "```"
                + "**Level 3**: " + "```fix" + "\n" + hashMap.get("LVL3") + "```"
                + "**Level 4**: " + "```fix" + "\n" + hashMap.get("LVL4") + "```"
                + "**Level 5**: " + "```fix" + "\n" + hashMap.get("LVL5") + "```"
                + "**Level 6**: " + "```fix" + "\n" + hashMap.get("LVL6") + "```"
                + "**Level 7**: " + "```fix" + "\n" + hashMap.get("LVL7") + "```"
                + "**Level 8**: " + "```fix" + "\n" + hashMap.get("LVL8") + "```"
                + "**Level 9**: " + "```fix" + "\n" + hashMap.get("LVL9") + "```"
                + "**Level 10**: " + "```fix" + "\n" + hashMap.get("LVL10") + "```"
                + "**Level 11**: " + "```fix" + "\n" + hashMap.get("LVL11") + "```"
                + "**Level 12**: " + "```fix" + "\n" + hashMap.get("LVL12") + "```";
        jdaStandard(title, url, description, jdaColor(" "), event);
    }

    //revisar
    public static void createList(MessageReceivedEvent event, ArrayList<String> listOfMatches, String title) {
        int contador = 0;
        StringBuilder names = new StringBuilder();
        for (String listOfMatch : listOfMatches) {
            contador++;
            names.append(listOfMatch);
            if (contador == 25) {
                EmbedBuilder j = new EmbedBuilder();
                j.setTitle(title);
                j.setDescription(names);
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(j.build()).queue();
                contador = 0;
                names = new StringBuilder();
            }
        }
        if (contador > 0) {
            EmbedBuilder j = new EmbedBuilder();
            j.setTitle(title);
            j.setDescription(names);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(j.build()).queue();
        }
    }
}
