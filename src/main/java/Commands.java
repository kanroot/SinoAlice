import java.awt.*;
import java.util.HashMap;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Commands extends ListenerAdapter {

    private final String keyNombre = "NAME";

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
                StringBuilder jobs = new StringBuilder();
                String jobClass = null;
                String nameJob = null;
                if (args.length > 2) {
                    for (int i = 1; i < args.length; i++) {
                        jobs.append(args[i].toUpperCase()).append(" ");
                        switch (jobs.toString()){
                            case "ALICE ":
                            case "NIER ":
                            case "YOUNG NIER ":
                            case "SNOW WHITE ":
                            case "KAGUYA ":
                            case "GRETEL ":
                            case "PINOCCHIO ":
                            case "DOROTHY ":
                            case "CINDERELLA ":
                            case "THREE LITTLE PIGGIES ":
                            case "2B ":
                            case "9S ":
                            case "A2 ":
                            case "EMIL CLONE ":
                            case "EMIL ":
                            case "KAINE ":
                            case "DEVOLA&POPOLA ":
                            case "YOUNG EMIL":
                                nameJob = String.valueOf(jobs.deleteCharAt(jobs.lastIndexOf(" ")));
                                jobClass = args[args.length - 1];
                                break;
                        }
                    }
                    if (nameJob != null && nameJob.equals(jobs.toString())) {
                        var pjfind = Main.pjs.find(nameJob);
                        for (HashMap<String, String> stringStringHashMap : pjfind) {
                            pestanaClass(event, stringStringHashMap);
                        }
                    }else {
                        var pjfind = Main.pjs.find(nameJob,jobClass);
                        for (HashMap<String, String> stringStringHashMap : pjfind) {
                            pestanaClass(event, stringStringHashMap);
                        }
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
        helper.addField("!setEfect", "```Show all armor with the set effect searched."
                + "\n" + "\nExamples:" + "\n!ColoSkill Zephyr Fairy Mastery (II)" +
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
            if (Main.pesadillas.night.get(i).get(keyNombre).contains(buscado.toUpperCase())) {
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
            if (Main.armaduras.armor.get(i).get("NAME").contains(buscado.toUpperCase())) {
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

    public void weaponsfind(MessageReceivedEvent event, String searched) {
        StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < Main.armas.weapons.size(); i++) {
            if (Main.armas.weapons.get(i).get("NAME").contains(searched.toUpperCase())) {
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
        }
    }
    //endregion

    //region pestañas
    private void pestanaNightmare(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        EmbedBuilder j = new EmbedBuilder();
        j.setTitle(String.valueOf(hashMap.get("NAME")));
        j.setImage(hashMap.get("IMG"));
        j.setDescription(
                "**Story skill**:" + "```fix" + "\n" + hashMap.get("NAMESTORY") + ": "
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
                        + "\t" + "Duration: " + hashMap.get("DURATION") + "```"
        );
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(j.build()).queue();
    }

    private void pestanaArmor(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        EmbedBuilder ar = new EmbedBuilder();
        ar.setTitle(String.valueOf(hashMap.get(keyNombre)));
        ar.setImage(hashMap.get("IMG"));
        ar.setDescription("**Story skill**: " + "```fix" + "\n" + hashMap.get("NAMESKILL") + ": " + hashMap.get("SKILL") + "```"
                + "\n" + "**Set  effect**: " + "```fix" + "\n" + hashMap.get("NAMECOLO") + ": " + hashMap.get("COLOSKILL") + "```"
                + "```ELM" + "\n" + "Element: " + hashMap.get("ELEMENT")
                + "\t" + "Type: " + hashMap.get("TYPE")
                + "\t" + "P.Def: " + hashMap.get("PDEF")
                + "\t" + "M.Def: " + hashMap.get("MDEF")
                + "\t" + "Total: " + hashMap.get("TOTAL") + "```" + "```YAML"
                + "\n" + "Set total: " + hashMap.get("SETTOTAL") + "```"
        );
        if (hashMap.get("ELEMENT").equalsIgnoreCase("Fire")) {
            ar.setColor(Color.red);
        }
        if (hashMap.get("ELEMENT").equalsIgnoreCase("Wind")) {
            ar.setColor(Color.green);
        }
        if (hashMap.get("ELEMENT").equalsIgnoreCase("Water")) {
            ar.setColor(Color.blue);
        }
        if (hashMap.get("ELEMENT").equalsIgnoreCase("Humans")) {
            ar.setColor(Color.BLACK);
        }
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(ar.build()).queue();
    }

    private void pestanaWeapons(MessageReceivedEvent event, HashMap<String, String> hashMap) {
        EmbedBuilder showWeapon = new EmbedBuilder();
        showWeapon.setTitle(hashMap.get(keyNombre));
        showWeapon.setImage(hashMap.get("IMG"));
        System.out.println(hashMap.get("IMG"));
        showWeapon.setDescription("**Colosseum  skill**: " + "```fix" + "\n" + hashMap.get("NAMECOLO") + ": " + hashMap.get("SKILL") + "```"
                + "\n" + "**Colosseum Aid Skill**: " + "```fix" + "\n" + hashMap.get("AID") + ": " + hashMap.get("COLOSKILL") + "```" + "\n"
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
                + "\n" + "Element: " + hashMap.get("ELEMENT") + "```"
        );
        if (hashMap.get("ELEMENT").equalsIgnoreCase("Fire")) {
            showWeapon.setColor(Color.red);
        } else {
            if (hashMap.get("ELEMENT").equalsIgnoreCase("Wind")) {
                showWeapon.setColor(Color.green);
            } else {
                if (hashMap.get("ELEMENT").equalsIgnoreCase("Water")) {
                    showWeapon.setColor(Color.blue);
                }
            }
        }
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(showWeapon.build()).queue();

    }
    private void pestanaClass(MessageReceivedEvent event, HashMap<String, String> hashMap){
        EmbedBuilder showClass= new EmbedBuilder();
        showClass.setTitle(hashMap.get("NAME") + "/" + hashMap.get("JOB"));
        showClass.setImage(hashMap.get("IMG"));
        showClass.setDescription("**Primary weapon**: " + "```fix" + "\n" + hashMap.get("PRIMARY") + "```"
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
                + "**Level 12**: " + "```fix" + "\n" + hashMap.get("LVL12") + "```");
        showClass.setColor(Color.cyan);
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(showClass.build()).queue();
    }
    //endregion


}//fin del listener

