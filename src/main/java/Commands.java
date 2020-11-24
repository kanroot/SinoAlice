import java.awt.*;
import java.util.HashMap;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Commands extends ListenerAdapter {

    private final String keyNombre = "NOMBRE";

    public void onMessageReceived(MessageReceivedEvent event) {
        //no lee mensajes propios
        if (event.getAuthor().equals(event.getJDA().getSelfUser())) return;

        String[] args = event.getMessage().getContentRaw().split(" ", 5);

        String opc = args[0].toUpperCase();
        switch (opc) {
            case "!HELPER":
                help(event);
                break;
            case "!INFO":
                info(event);
                break;
            case "!NIGHTMARES":
                if (args[1].equalsIgnoreCase("all")) {
                    nameNight(event);
                } else {
                    nightmarepattern(event, args[1]);
                }
                break;
            case "!SEARCHN":
                StringBuilder name = new StringBuilder();
                if (args.length > 2) {
                    for (int i = 1; i < args.length; i++) {
                        name.append(args[i].toUpperCase()).append(" ");
                    }
                    name.deleteCharAt(name.lastIndexOf(" "));
                } else {
                    name = new StringBuilder(args[1]);
                }
                searchNightmare(event, name.toString());
                break;
            case "!MAXN":
                var point = Main.pesadillas.point();
                for (HashMap<String, String> stringStringHashtable : point) {
                    pestanaNightmare(event, stringStringHashtable);
                }
                break;
            case "!ARMORS":
                if (args[1].equalsIgnoreCase("all")) {
                    nameArmors(event);
                } else {
                    armorsfind(event, args[1]);
                }
                break;
            case "!SEARCHA":
                StringBuilder nameA = new StringBuilder();
                if (args.length > 2) {
                    for (int i = 1; i < args.length; i++) {
                        nameA.append(args[i].toUpperCase()).append(" ");
                    }
                    nameA.deleteCharAt(nameA.lastIndexOf(" "));
                } else {
                    nameA = new StringBuilder(args[1]);
                }
                searchA(event, nameA.toString());
                break;
            case "!MAXA":
                var pointA = Main.armaduras.point();
                for (HashMap<String, String> stringStringHashtable : pointA) {
                    pestanaArmor(event, stringStringHashtable);
                }

            case "!ARM":
                if (args.length == 3) {
                    var buscado = Main.armaduras.filtroElemType(args[1], args[2], "TOTAL");
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        pestanaArmor(event, stringStringHashtable);
                    }
                }

                if (args.length == 4) {
                    var buscado = Main.armaduras.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        pestanaArmor(event, stringStringHashtable);
                    }
                }
                if (args.length == 5) {
                    var buscado = Main.armaduras.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    int trunc;
                    trunc = Integer.parseInt(args[4]);
                    if (trunc > buscado.size()) {
                        trunc = buscado.size();
                    }
                    for (int i = 0; i < trunc; i++) {
                        pestanaArmor(event, buscado.get(i));
                    }
                }
                break;
            case "!WEAPONS":
                if (args[1].equalsIgnoreCase("all")) {
                    nameWeapons(event);
                } else {
                    weaponsfind(event, args[1]);
                }
                break;
            case "!SEARCHW":
                StringBuilder nameW = new StringBuilder();
                if (args.length > 2) {
                    for (int i = 1; i < args.length; i++) {
                        nameW.append(args[i].toUpperCase()).append(" ");
                    }
                    nameW.deleteCharAt(nameW.lastIndexOf(" "));
                } else {
                    nameW = new StringBuilder(args[1]);
                }
                searchW(event, nameW.toString());
                break;
            case "!MAXW":
                var pointW = Main.armas.point();
                for (HashMap<String, String> stringStringHashtable : pointW) {
                    pestanaWeapons(event, stringStringHashtable);
                }
                break;
            case "!WPN":
                if (args.length == 3) {
                    var buscado = Main.armas.filtroElemType(args[1], args[2], "TOTAL");
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        pestanaWeapons(event, stringStringHashtable);
                    }
                }
                if (args.length == 4) {
                    var buscado = Main.armas.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        pestanaWeapons(event, stringStringHashtable);
                    }
                }
                if (args.length == 5) {
                    var buscado = Main.armas.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    int trunc = Integer.parseInt(args[4]);
                    if (trunc > buscado.size()) {
                        trunc = buscado.size();
                    }
                    for (int i = 0; i < trunc; i++) {
                        pestanaWeapons(event, buscado.get(i));
                    }
                }
                break;
            case "!STORYN":
                if (args.length >= 2) {
                    StringBuilder nameS = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameS.append(args[i].toUpperCase()).append(" ");
                    }
                    nameS.deleteCharAt(nameS.lastIndexOf(" "));
                    var buscado = Main.pesadillas.storySkill(nameS.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaNightmare(event, stringStringHashMap);
                    }
                }
                break;
            case "!COLON":
                if (args.length >= 2) {
                    StringBuilder nameC = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameC.append(args[i].toUpperCase()).append(" ");
                    }
                    nameC.deleteCharAt(nameC.lastIndexOf(" "));
                    var buscado = Main.pesadillas.coloSkill(nameC.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaNightmare(event, stringStringHashMap);
                    }
                }
                break;
            case "!AIDW":
                if (args.length >= 2) {
                    StringBuilder nameS = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameS.append(args[i].toUpperCase()).append(" ");
                    }
                    nameS.deleteCharAt(nameS.lastIndexOf(" "));
                    var buscado = Main.armas.aidSkill(nameS.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaWeapons(event, stringStringHashMap);
                    }
                }
            case "!COLOW":
                if (args.length >= 2) {
                    StringBuilder nameC = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameC.append(args[i].toUpperCase()).append(" ");
                    }
                    nameC.deleteCharAt(nameC.lastIndexOf(" "));
                    var buscado = Main.armas.coloSkill(nameC.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaWeapons(event, stringStringHashMap);
                    }
                }
            case "!STORYA":
                if (args.length >= 2) {
                    StringBuilder nameS = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameS.append(args[i].toUpperCase()).append(" ");
                    }
                    nameS.deleteCharAt(nameS.lastIndexOf(" "));
                    var buscado = Main.armaduras.storySkill(nameS.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaArmor(event, stringStringHashMap);
                    }
                }
            case "!SETEFFECT":
                if (args.length >= 2) {
                    StringBuilder nameC = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameC.append(args[i].toUpperCase()).append(" ");
                    }
                    nameC.deleteCharAt(nameC.lastIndexOf(" "));
                    var buscado = Main.armaduras.coloSkill(nameC.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaArmor(event, stringStringHashMap);
                    }
                }
            case "!CLASS":
                if (args.length == 2) {
                    var buscado = Main.pjs.find(args[1].toUpperCase());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaClass(event, stringStringHashMap);
                    }
                }
                if (args.length == 3) {
                    var buscado = Main.pjs.find(args[1].toUpperCase(), args[2].toUpperCase());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        pestanaClass(event, stringStringHashMap);
                    }
                }
        }
    }

    //methods
    //region info
    private void info(MessageReceivedEvent event) {
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
    //endregion

    //region help
    private void help(MessageReceivedEvent event) {
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
                + "\n" + "\nExamples:" + "\n!aidW Blazing Wildfire (I)" +
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
        /*
        helper.addField("!setEfect", "```Show all armor with the set effect searched."
                + "\n" + "\nExamples:" + "\n!ColoSkill Zephyr Fairy Mastery (II)" +
                "\n!coloA Human Hunter's Soul" +
                "\n!coloA Hunter's Soul" +
                "\n!coloA Machine Lifeform and Emil's Hunting Spirit```", false);
        */
        helper.setColor(Color.pink);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(helper.build()).queue();
    }
    //endregion

    //region pesadillas
    private void nameNight(MessageReceivedEvent event) {
        StringBuilder nombres = new StringBuilder();
        int contador = 0;
        int color = 0;
        for (int i = 0; i < Main.pesadillas.night.size(); i++) {
            nombres.append("**").append(i + 1).append("**").append(". ").append(Main.pesadillas.night.get(i).get(keyNombre)).
                    append("\n");
            contador++;
            if (contador == 50) {
                color++;
                EmbedBuilder night = new EmbedBuilder();
                night.setTitle("All names of nightmares");
                night.setDescription(nombres.toString());

                if (color % 2 == 0) {
                    night.setColor(Color.BLACK);
                } else {
                    night.setColor(Color.yellow);
                }

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(night.build()).queue();
                contador = 0;
                nombres = new StringBuilder();
            }
        }
        if (contador > 0) {

            EmbedBuilder night = new EmbedBuilder();
            night.setTitle("All names of nightmares");
            night.setDescription(nombres.toString());
            night.setColor(Color.yellow);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(night.build()).queue();
        }
    }

    public void nightmarepattern(MessageReceivedEvent event, String buscado) {
        StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < Main.pesadillas.night.size(); i++) {
            if (Main.pesadillas.night.get(i).get("NOMBRE").contains(buscado.toUpperCase())) {
                nombres.append("**").append(i + 1).append("**").append(". ").append(Main.pesadillas.night.get(i).get(keyNombre)).append("\n");
            }
        }
        EmbedBuilder armor = new EmbedBuilder();
        armor.setTitle("All nightmares");
        armor.setDescription(nombres.toString());
        armor.setColor(Color.magenta);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(armor.build()).queue();
    }

    private void searchNightmare(MessageReceivedEvent event, String arg) {
        try {
            var point = Main.pesadillas.buscar(Integer.parseInt(arg));
            pestanaNightmare(event, point);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            var point = Main.pesadillas.buscar(arg);
            pestanaNightmare(event, point);
        }
    }
    //endregion

    //region armaduras
    private void nameArmors(MessageReceivedEvent event) {
        StringBuilder nombres = new StringBuilder();
        int contador = 0;
        int color = 0;

        for (int i = 0; i < Main.armaduras.armor.size(); i++) {
            nombres.append("**").append(i + 1).append("**").append(". ").append(Main.armaduras.armor.get(i).get(keyNombre)).append("\n");
            contador++;

            if (contador == 25) {
                color++;
                EmbedBuilder armor = new EmbedBuilder();
                armor.setTitle("All armors");
                armor.setDescription(nombres.toString());
                if (color % 2 == 0) {
                    armor.setColor(Color.red);
                } else {
                    armor.setColor(Color.magenta);
                }

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(armor.build()).queue();
                contador = 0;
                nombres = new StringBuilder();
            }
        }
        if (contador > 0) {

            EmbedBuilder armor = new EmbedBuilder();
            armor.setTitle("All names of armors");
            armor.setDescription(nombres.toString());
            armor.setColor(Color.red);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(armor.build()).queue();
        }
    }

    public void armorsfind(MessageReceivedEvent event, String buscado) {
        StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < Main.armaduras.armor.size(); i++) {
            if (Main.armaduras.armor.get(i).get("NOMBRE").contains(buscado.toUpperCase())) {
                nombres.append("**").append(i + 1).append("**").append(". ").append(Main.armaduras.armor.get(i).get(keyNombre)).append("\n");
            }
        }
        EmbedBuilder armor = new EmbedBuilder();
        armor.setTitle("All armors");
        armor.setDescription(nombres.toString());
        armor.setColor(Color.magenta);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(armor.build()).queue();
    }

    private void searchA(MessageReceivedEvent event, String arg) {
        try {
            var armorSearched = Main.armaduras.buscar(Integer.parseInt(arg));
            pestanaArmor(event, armorSearched);
        } catch (NumberFormatException e) {
            var armorSearched = Main.armaduras.buscar(arg);
            pestanaArmor(event, armorSearched);
            e.printStackTrace();
        }
    }
    //endregion

    //region armas
    private void nameWeapons(MessageReceivedEvent event) {
        StringBuilder nombres = new StringBuilder();
        int contador = 0;
        int color = 0;

        for (int i = 0; i < Main.armas.weapons.size(); i++) {
            nombres.append("**").append(i + 1).append("**").append(". ").append(Main.armas.weapons.get(i).get(keyNombre)).append("\n");
            contador++;

            if (contador == 50) {
                color++;
                EmbedBuilder armas = new EmbedBuilder();
                armas.setTitle("All weapons");
                armas.setDescription(nombres.toString());
                if (color % 2 == 0) {
                    armas.setColor(Color.green);
                } else {
                    armas.setColor(Color.ORANGE);
                }

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(armas.build()).queue();
                contador = 0;
                nombres = new StringBuilder();
            }
        }
        if (contador > 0) {
            EmbedBuilder armas = new EmbedBuilder();
            armas.setTitle("All weapons");
            armas.setDescription(nombres.toString());
            armas.setColor(Color.orange);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(armas.build()).queue();
        }
    }

    public void weaponsfind(MessageReceivedEvent event, String buscado) {
        StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < Main.armas.weapons.size(); i++) {
            if (Main.armas.weapons.get(i).get("NOMBRE").contains(buscado.toUpperCase())) {
                nombres.append("**").append(i + 1).append("**").append(". ").
                        append(Main.armas.weapons.get(i).get(keyNombre)).append("\n");
            }
        }
        EmbedBuilder armas = new EmbedBuilder();
        armas.setTitle("All weapons");
        armas.setDescription(nombres.toString());
        armas.setColor(Color.magenta);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(armas.build()).queue();
    }

    private void searchW(MessageReceivedEvent event, String arg2) {
        try {
            var buscado = Main.armas.buscar(Integer.parseInt(arg2));
            pestanaWeapons(event, buscado);
        } catch (NumberFormatException e) {
            var buscado = Main.armas.buscar(arg2);
            pestanaWeapons(event, buscado);
            e.printStackTrace();
        }
    }
    //endregion

    //region pestañas
    private void pestanaNightmare(MessageReceivedEvent event, HashMap<String, String> point) {
        EmbedBuilder j = new EmbedBuilder();
        j.setTitle(String.valueOf(point.get("NOMBRE")));
        j.setImage(point.get("IMG"));
        j.setDescription(
                "**Story skill**:" + "```fix" + "\n" + point.get("NAMESTORY") + ": "
                        + point.get("SKILL") + "```" + "\n" +
                        "**Colosseum skill**:" + "```fix" + "\n" + point.get("NAMECOLO") + ": " +
                        point.get("COLOSKILL") + "```" + "\n" +
                        "**Level**: " + point.get("LVL") + "```ELM"
                        + "\n" + "P.Atk: " + point.get("PATK")
                        + "\t" + "P.Atk: " + point.get("PDEF")
                        + "\t" + "M.Atk: " + point.get("MATK")
                        + "\t" + "M.Atk: " + point.get("MDEF")
                        + "\t" + "Total: " + point.get("TOTAL") + "```"
                        + "\n" + "**Level**: " + point.get("FULLLVL") + "```ELM"
                        + "\n" + "P.Akt: " + point.get("PAKTOTAL")
                        + "\t" + "P.Def: " + point.get("FULLDEF")
                        + "\t" + "Max.ATK: " + point.get("FULLMATK")
                        + "\t" + "Max.DEF: " + point.get("FULLMDEF")
                        + "\t" + "Total: " + point.get("TOTALMAXLEV") + "```" + "**Others**" + "```ELM"
                        + "\n" + "Tt.Atk: " + point.get("TTATK")
                        + "\t" + "Tt.Def: " + point.get("TTDEF")
                        + "\t" + "PATK+Tt.Def : " + point.get("PATKTTDEF")
                        + "\t" + "M.Atk+Tt.Def : " + point.get("MATKTTDEF")
                        + "\t" + "Time: " + point.get("TIME")
                        + "\t" + "Duration: " + point.get("DURATION") + "```"
        );


        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(j.build()).queue();
    }

    private void pestanaArmor(MessageReceivedEvent event, HashMap<String, String> armor) {
        EmbedBuilder ar = new EmbedBuilder();
        ar.setTitle(String.valueOf(armor.get(keyNombre)));
        ar.setImage(armor.get("IMG"));
        ar.setDescription("**Story skill**: " + "```fix" + "\n" + armor.get("NAMESKILL") + ": " + armor.get("SKILL") + "```"
                + "\n" + "**Set  effect**: " + "```fix" + "\n" + armor.get("NAMECOLO") + ": " + armor.get("COLOSKILL") + "```"
                + "```ELM" + "\n" + "Element: " + armor.get("ELEMENT")
                + "\t" + "Type: " + armor.get("TYPE")
                + "\t" + "P.Def: " + armor.get("PDEF")
                + "\t" + "M.Def: " + armor.get("MDEF")
                + "\t" + "Total: " + armor.get("TOTAL") + "```" + "```YAML"
                + "\n" + "Set total: " + armor.get("SETTOTAL") + "```"
        );
        if (armor.get("ELEMENT").equalsIgnoreCase("Fire")) {
            ar.setColor(Color.red);
        }
        if (armor.get("ELEMENT").equalsIgnoreCase("Wind")) {
            ar.setColor(Color.green);
        }
        if (armor.get("ELEMENT").equalsIgnoreCase("Water")) {
            ar.setColor(Color.blue);
        }
        if (armor.get("ELEMENT").equalsIgnoreCase("Humans")) {
            ar.setColor(Color.BLACK);
        }
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(ar.build()).queue();
    }

    private void pestanaWeapons(MessageReceivedEvent event, HashMap<String, String> buscado) {
        EmbedBuilder showWeapon = new EmbedBuilder();
        showWeapon.setTitle(buscado.get("NOMBRE"));
        showWeapon.setImage(buscado.get("IMG"));
        showWeapon.setDescription("**Colosseum  skill**: " + "```fix" + "\n" + buscado.get("NAMECOLO") + ": " + buscado.get("SKILL") + "```"
                + "\n" + "**Colosseum Aid Skill**: " + "```fix" + "\n" + buscado.get("AID") + ": " + buscado.get("COLOSKILL") + "```" + "\n"
                + "**Level**: " + buscado.get("LVL") + "```ELM"
                + "\n" + "Type: " + buscado.get("TYPE")
                + "\t" + "P.Atk: " + buscado.get("PATK")
                + "\t" + "P.Def: " + buscado.get("PDEF")
                + "\t" + "M.Atk: " + buscado.get("MATK")
                + "\t" + "M.Def: " + buscado.get("MDEF")
                + "\t" + "Total: " + buscado.get("TOTAL")
                + "\t" + "Tt.ATK: " + buscado.get("TTATK")
                + "\t" + "Tt.Def: " + buscado.get("TTDEF")
                + "\t" + "PATK+Tt.Def: " + buscado.get("PATKTTDEF")
                + "\t" + "M.Atk+Tt.Def: " + buscado.get("MATKTTDEF") + "```" + "```YAML"
                + "\n" + "Element: " + buscado.get("ELEMENT") + "```"
        );
        if (buscado.get("ELEMENT").equalsIgnoreCase("Fire")) {
            showWeapon.setColor(Color.red);
        } else {
            if (buscado.get("ELEMENT").equalsIgnoreCase("Wind")) {
                showWeapon.setColor(Color.green);
            } else {
                if (buscado.get("ELEMENT").equalsIgnoreCase("Water")) {
                    showWeapon.setColor(Color.blue);
                }
            }
        }
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(showWeapon.build()).queue();

    }
    private void pestanaClass(MessageReceivedEvent event, HashMap<String, String> buscado){
        EmbedBuilder showClass= new EmbedBuilder();
        showClass.setTitle(buscado.get("NAME") + "/" + buscado.get("JOB"));
        showClass.setImage(buscado.get("IMG"));
        showClass.setDescription("**Primary weapon**: " + "```fix" + "\n" + buscado.get("PRIMARY") + "```"
                + "\n" + "**Usable weapons**: " + "```fix" + "\n" + buscado.get("USABLE") + "```" + "\n"
                + "**Level 1**: " + "```fix" + "\n" + buscado.get("LVL1") + "```"
                + "**Level 2**: " + "```fix" + "\n" + buscado.get("LVL2") + "```"
                + "**Level 3**: " + "```fix" + "\n" + buscado.get("LVL3") + "```"
                + "**Level 4**: " + "```fix" + "\n" + buscado.get("LVL4") + "```"
                + "**Level 5**: " + "```fix" + "\n" + buscado.get("LVL5") + "```"
                + "**Level 6**: " + "```fix" + "\n" + buscado.get("LVL6") + "```"
                + "**Level 7**: " + "```fix" + "\n" + buscado.get("LVL7") + "```"
                + "**Level 8**: " + "```fix" + "\n" + buscado.get("LVL8") + "```"
                + "**Level 9**: " + "```fix" + "\n" + buscado.get("LVL9") + "```"
                + "**Level 10**: " + "```fix" + "\n" + buscado.get("LVL10") + "```"
                + "**Level 11**: " + "```fix" + "\n" + buscado.get("LVL11") + "```"
                + "**Level 12**: " + "```fix" + "\n" + buscado.get("LVL12") + "```");

        showClass.setColor(Color.cyan);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(showClass.build()).queue();
    }
    //endregion


}//fin del listener

