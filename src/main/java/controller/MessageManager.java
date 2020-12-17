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
        info.addField("Version", "1.0", false);
        info.addField("acknowledgment to", "gn.draw (search his instagram), ultima, Radzinskys0雷, colossi, Trickstar BlackLôtus\n," +
                " and all people what send me a message, THANKS!", false);
        info.addField("Donatios", "If you wanna a feature, or for better servers, or only for love," +
                " please let me know with your sino-love:\n" + "https://ko-fi.com/rootkan",false);
        info.setColor(Color.cyan);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
    }

    public static void help(MessageReceivedEvent event) {
        EmbedBuilder helper = new EmbedBuilder();
        helper.setTitle("Helper");
        helper.setImage("https://i.redd.it/lljcy3vj9ei51.png");
        helper.setDescription("**All commands:**"
                + "\n" + "```!h```"
                + "```!i```"
                + "```!n [all/Pattern to find]```"
                + "```!nn [number / nightmare's name]```"
                + "```!mn```"
                + "```!a [all/Pattern to find]```"
                + "```!na [number / Armor's name]```"
                + "```!ea [element][Type](Stat)(number of elements)(optional)```"
                + "```!weapons [all/Pattern to find]```"
                + "```!searchW [number / Weapon's name]```"
                + "```!ew [element][Type](Stat)(number of elements)(optional)```"
                + "```!sn [name of skill]```"
                + "```!ncn [name of skill]```"
                + "```!nc [name of pj](job)```"
        );
        helper.addField("!h", "```Show all commands.```", false);
        helper.addField("!i", "```Show all information of bot.```", false);
        helper.addField("!n", "```Show all nightmares and it's number or matched with a user input (Pattern)."
                + "\n" + "Examples:"
                + "\n" + "!n (Show all nightmares)"
                + "\n" + "!n hound"
                + "\n" + "!n Real Lizard"
                + "\n" + "!n orc```", false);
        helper.addField("!a", "```Show all armors names and it's number or matched with a user input (Pattern)."
                + "\n" + "Examples:"
                + "\n" + "!a (Show all armors)"
                + "\n" + "!a golden"
                + "\n" + "!a Schoolgirl```", false);
        helper.addField("!w", "```Show all weapons names and it's number or matched with a user input (Pattern)"
                + "\n" + "Examples:"
                + "\n" + "!w (Show all weapons)"
                + "\n" + "!w staff"
                + "\n" + "!w Book of Observation```", false);
        helper.addField("!nn", "```Search one nightmare by its number/name or matched with a user input."
                + "\n" + "!nn 1" + "\n" +
                "!nn Flying Magician" +
                "\n!nn 148" +
                "\n!nn UGALLU```", false);
        helper.addField("!na", "```Search one armor by its number/name."
                + "\n" + "\nExamples: \n!na 1"
                + "\n" + "!na Nameless Youth's Hairband (Projectile)"
                + "\n" + "!na 31"
                + "\n" + "!na Nameless Youth's Shoes (Blade)```", false);
        helper.addField("!nw", "```Search one weapon by it's number/name."
                + "\n" + "!nw 1" + "\n"
                + "!nw Origin of Truth"
                + "\n" + "!nw 387"
                + "\n" + "!nw War Song's Echo```", false);
        helper.addField("!mn", "```Show the nightmare with the highest points.```", false);
        helper.addField("!ea", "```Show all armors filtered by it's element [fire/wind/water/humans] and type [head/body/hands/feet]."
                + "\n" +
                "\nExamples:" + "\n" + "!Arm wind body" +
                "\n!ea wind Head PDEF " +
                "\n!ea wind Hands MDEF 1" +
                "\n!ea wind Feet SETTOTAL 5```", false);
        helper.addField("!ew", "```Show all weapons filtered by it's element [fire/wind/water] and type [Instr./polearm/blade/tome/focus/staff/hammer/ranged]."
                + "\n" + "\nExamples:" + "\n!ew wind polearm" +
                "\n!ew wind Instr. PATK" +
                "\n!ew wind polearm PDEF" +
                "\n!ew wind blade MATK" +
                "\n!ew wind Tome MDEF" +
                "\n!ew wind focus TTATK 1" +
                "\n!ew wind Staff TTATK 2" +
                "\n!ew wind Hammer TTDEF 3" +
                "\n!ew wind Ranged PATKTTDEF 4" +
                "\n!ew wind Instr. MATKTTDEF 5```", false);
        helper.addField("!nsn", "```Show all nightmares with the Story Skill searched."
                + "\n" + "\nExamples:" + "\n!nsn Blazing Wildfire (I)" +
                "\n!nsn Lover's Embrace (II)" +
                "\n!nsn Song of Camaraderie (II)" +
                "\n!nsn Engulfing```", false);
        helper.addField("!ncn", "```Show all nightmares with the Colosseum Skill searched."
                + "\n" + "\nExamples:" + "\n!ncn Zephyr Fairy Mastery (II)" +
                "\n!ncn Zephyr" +
                "\n!ncn Tidal Fairy Master (I)" +
                "\n!ncn Tidal Fairy```", false);
        helper.addField("!nc", "```Show jobs with the name's pj and job.\n"
                + "\nPjs:\n" +
                "Alice, Snow White, Red Riding Hood,\n" +
                "Cinderella, Pinocchio, Little Mermaid,\n" +
                "Gretel, Briar Rose, Kaguya,\n" +
                "Dorothy, Nutcracker,Three Little Piggies,\n" +
                "Nier, Young Nier, Kaine,\n" +
                "Young Emil, Devola&Popola,\n" +
                "Emil Clone, 2B,\n" +
                "9S, 2A and Emil\n"
                + "\nJobs:\n"
                + "Mage, Gunner, Alternative\n"
                + "Half-Nightmare, Minstrel, Sorcerer\n"
                + "Cleric, Paladin, Breaker, Invader,\n"
                + "Poacher and Crusher."
                + "\n" + "\nExamples:" +
                "\n!nc 2b" +
                "\n!nc 2b breaker" +
                "\n!nc alice " +
                "\n!nc alice Alternative```", false);
        helper.setFooter("If you wanna a feature, or for better servers, or only for love," + " please let me know with your sino-love:\n"
                + "https://ko-fi.com/rootkan");
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
        String fix = "```fix";
        String end = "```";
        String elm = "```ELM";
        String description =
                "**Colosseum  skill**: " + fix + "\n" + hashMap.get("NAMECOLO") + ":" +
                        hashMap.get("COLOSKILL") + end
                        + "\n" + "**Story Skill**: " + fix
                        + "\n" + hashMap.get("SKILL") + ":"
                        + hashMap.get("STORYSKILL") + end
                        + "\n" + "**Colosseum Aid Skill**:" + fix
                        + "\n" + hashMap.get("NAMEAID") + ":"
                        + hashMap.get("AID") + end
                        + "**Level**: " + hashMap.get("LVL") + elm
                        + "\n" + "Type:" + hashMap.get("TYPE") + end + elm
                        + "\n" + "P.Atk:" + hashMap.get("PATK")
                        + "\t" + "P.Def:" + hashMap.get("PDEF") + end + elm
                        + "\n" + "M.Atk:" + hashMap.get("MATK")
                        + "\t" + "M.Def:" + hashMap.get("MDEF") + end + elm
                        + "\n" + "Total:" + hashMap.get("TOTAL")
                        + "\t" + "Tt.ATK:" + hashMap.get("TTATK") + end + elm
                        + "\n" + "Tt.Def:" + hashMap.get("TTDEF")
                        + "\t" + "PAtk+Tt.Def:" + hashMap.get("PATKTTDEF") + end + elm
                        + "\n" + "M.Atk+Tt.Def:" + hashMap.get("MATKTTDEF")
                        + "\t" + "Cost:" + hashMap.get("COST")
                        + "```" + "```YAML"
                        + "\n" + "Element:" + hashMap.get("ELEMENT") + end;
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
