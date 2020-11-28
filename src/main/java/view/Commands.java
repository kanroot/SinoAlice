package view;

import java.util.ArrayList;
import java.util.HashMap;

import controller.MessageManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    private final String keyName = "NAME";

    public void onMessageReceived(MessageReceivedEvent event) {
        //no lee mensajes propios
        if (event.getAuthor().equals(event.getJDA().getSelfUser())) return;

        String[] args = event.getMessage().getContentRaw().split(" ", 5);

        String opc = args[0].toUpperCase();
        switch (opc) {
            case Main.prefix + "HELPER":
                MessageManager.help(event);
                break;
            case Main.prefix + "INFO":
                MessageManager.info(event);
                break;
            case Main.prefix + "NIGHTMARES":
                if (args[1].equalsIgnoreCase("all")) {
                    MessageManager.createList(event, nightmarePattern(" "), "All names of nightmares");
                } else {
                    MessageManager.createList(event, nightmarePattern(args[1]), "Matched");
                }
                break;
            case Main.prefix + "SEARCHN":
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
            case Main.prefix + "MAXN":
                var point = Main.nigthmares.point();
                for (HashMap<String, String> stringStringHashtable : point) {
                    MessageManager.pestanaNightmare(event, stringStringHashtable);
                }
                break;
            case Main.prefix + "ARMORS":
                if (args[1].equalsIgnoreCase("all")) {
                    MessageManager.createList(event, armorsfind(" "), "All armors");
                } else {
                    MessageManager.createList(event, armorsfind(args[1]), "Matched");
                }
                break;
            case Main.prefix + "SEARCHA":
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
            case Main.prefix + "MAXA":
                var pointA = Main.armors.point();
                for (HashMap<String, String> stringStringHashtable : pointA) {
                    MessageManager.pestanaArmor(event, stringStringHashtable);
                }

            case Main.prefix + "ARM":
                if (args.length == 3) {
                    var buscado = Main.armors.filtroElemType(args[1], args[2], "TOTAL");
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        MessageManager.pestanaArmor(event, stringStringHashtable);
                    }
                }

                if (args.length == 4) {
                    var buscado = Main.armors.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        MessageManager.pestanaArmor(event, stringStringHashtable);
                    }
                }
                if (args.length == 5) {
                    var buscado = Main.armors.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    int trunc;
                    trunc = Integer.parseInt(args[4]);
                    if (trunc > buscado.size()) {
                        trunc = buscado.size();
                    }
                    for (int i = 0; i < trunc; i++) {
                        MessageManager.pestanaArmor(event, buscado.get(i));
                    }
                }
                break;
            case Main.prefix + "WEAPONS":
                if (args[1].equalsIgnoreCase("all")) {
                    MessageManager.createList(event, weaponsfind(" "), "Matched");
                } else {
                    MessageManager.createList(event, weaponsfind(args[1]), "Matched");
                }
                break;
            case Main.prefix + "SEARCHW":
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
            case Main.prefix + "MAXW":
                var pointW = Main.weapons.point();
                for (HashMap<String, String> stringStringHashtable : pointW) {
                    MessageManager.pestanaWeapons(event, stringStringHashtable);
                }
                break;
            case Main.prefix + "WPN":
                if (args.length == 3) {
                    var buscado = Main.weapons.filtroElemType(args[1], args[2], "TOTAL");
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        MessageManager.pestanaWeapons(event, stringStringHashtable);
                    }
                }
                if (args.length == 4) {
                    var buscado = Main.weapons.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    for (HashMap<String, String> stringStringHashtable : buscado) {
                        MessageManager.pestanaWeapons(event, stringStringHashtable);
                    }
                }
                if (args.length == 5) {
                    var buscado = Main.weapons.filtroElemType(args[1], args[2], args[3].toUpperCase());
                    int trunc = Integer.parseInt(args[4]);
                    if (trunc > buscado.size()) {
                        trunc = buscado.size();
                    }
                    for (int i = 0; i < trunc; i++) {
                        MessageManager.pestanaWeapons(event, buscado.get(i));
                    }
                }
                break;
            case Main.prefix + "STORYN":
                if (args.length >= 2) {
                    StringBuilder nameS = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameS.append(args[i].toUpperCase()).append(" ");
                    }
                    nameS.deleteCharAt(nameS.lastIndexOf(" "));
                    var buscado = Main.nigthmares.storySkill(nameS.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaNightmare(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "COLON":
                if (args.length >= 2) {
                    StringBuilder nameC = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameC.append(args[i].toUpperCase()).append(" ");
                    }
                    nameC.deleteCharAt(nameC.lastIndexOf(" "));
                    var buscado = Main.nigthmares.coloSkill(nameC.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaNightmare(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "AIDW":
                if (args.length >= 2) {
                    StringBuilder nameS = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameS.append(args[i].toUpperCase()).append(" ");
                    }
                    nameS.deleteCharAt(nameS.lastIndexOf(" "));
                    var buscado = Main.weapons.aidSkill(nameS.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaWeapons(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "COLOW":
                if (args.length >= 2) {
                    StringBuilder nameC = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameC.append(args[i].toUpperCase()).append(" ");
                    }
                    nameC.deleteCharAt(nameC.lastIndexOf(" "));
                    var buscado = Main.weapons.coloSkill(nameC.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaWeapons(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "STORYA":
                if (args.length >= 2) {
                    StringBuilder nameS = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameS.append(args[i].toUpperCase()).append(" ");
                    }
                    nameS.deleteCharAt(nameS.lastIndexOf(" "));
                    var buscado = Main.armors.storySkill(nameS.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaArmor(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "SETEFFECT":
                if (args.length >= 2) {
                    StringBuilder nameC = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        nameC.append(args[i].toUpperCase()).append(" ");
                    }
                    nameC.deleteCharAt(nameC.lastIndexOf(" "));
                    var buscado = Main.armors.coloSkill(nameC.toString());
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaArmor(event, stringStringHashMap);
                    }
                }
            case Main.prefix + "CLASS":
                StringBuilder jobs = new StringBuilder();
                String jobClass = "";
                String nameJob = "";
                if (args.length >= 2) {
                    for (int i = 1; i < args.length; i++) {
                        jobs.append(args[i].toUpperCase()).append(" ");
                        switch (jobs.toString()) {
                            case "ALICE ":
                            case "SNOW WHITE ":
                            case "BRIAR ROSE ":
                            case "KAGUYA ":
                            case "NIER ":
                            case "RED RIDING HOOD ":
                            case "NUTCRACKER ":
                            case "YOUNG NIER ":
                            case "LITTLE MERMAID ":
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
                            case "YOUNG EMIL ":
                                nameJob = String.valueOf(jobs);
                                jobClass = String.valueOf(args[args.length - 1]).toUpperCase();
                                break;
                        }
                    }
                    if (nameJob.equals(jobs.toString()) && nameJob.contains(jobClass)) {
                        var pjfind = Main.pjs.find(nameJob);
                        for (HashMap<String, String> stringStringHashMap : pjfind) {
                            MessageManager.pestanaClass(event, stringStringHashMap);
                        }
                    } else {
                        var pjfind = Main.pjs.find(nameJob, jobClass);
                        for (HashMap<String, String> stringStringHashMap : pjfind) {
                            MessageManager.pestanaClass(event, stringStringHashMap);
                        }

                    }
                }
                break;
        }

    }

    public ArrayList<String> nightmarePattern(String buscado) {
        ArrayList<String> namesNightmares = new ArrayList<>();
        for (int i = 0; i < Main.nigthmares.night.size(); i++) {
            if (Main.nigthmares.night.get(i).get(keyName).contains(buscado.toUpperCase())) {
                int n = (i + 1);
                namesNightmares.add("**" + n + "**" + ". " + Main.nigthmares.night.get(i).get(keyName) + "\n");
            }
        }
        return namesNightmares;
    }

    private void searchNightmare(MessageReceivedEvent event, String arg) {
        try {
            var point = Main.nigthmares.buscar(Integer.parseInt(arg));
            MessageManager.pestanaNightmare(event, point);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            var point = Main.nigthmares.buscar(arg);
            MessageManager.pestanaNightmare(event, point);
        }
    }

    public ArrayList<String> armorsfind(String buscado) {
        ArrayList<String> namesArmors = new ArrayList<>();
        for (int i = 0; i < Main.armors.armor.size(); i++) {
            if (Main.armors.armor.get(i).get(keyName).contains(buscado.toUpperCase())) {
                int n = (i + 1);
                namesArmors.add("**" + n + "**" + ". " + Main.armors.armor.get(i).get(keyName) + "\n");
            }
        }
        return namesArmors;
    }

    private void searchA(MessageReceivedEvent event, String arg) {
        try {
            var armorSearched = Main.armors.buscar(Integer.parseInt(arg));
            MessageManager.pestanaArmor(event, armorSearched);
        } catch (NumberFormatException e) {
            var armorSearched = Main.armors.buscar(arg);
            MessageManager.pestanaArmor(event, armorSearched);
            e.printStackTrace();
        }
    }

    public ArrayList<String> weaponsfind(String searched) {
        ArrayList<String> namesWeapons = new ArrayList<>();
        for (int i = 0; i < Main.weapons.weapons.size(); i++) {
            if (Main.weapons.weapons.get(i).get(keyName).contains(searched.toUpperCase())) {
                int n = (i + 1);
                namesWeapons.add("**" + n + "**" + ". " + Main.weapons.weapons.get(i).get(keyName) + "\n");
            }
        }
        return namesWeapons;
    }

    private void searchW(MessageReceivedEvent event, String arg2) {
        try {
            var buscado = Main.weapons.buscar(Integer.parseInt(arg2));
            MessageManager.pestanaWeapons(event, buscado);
        } catch (NumberFormatException e) {
            var buscado = Main.weapons.buscar(arg2);
            MessageManager.pestanaWeapons(event, buscado);
        }
    }
}//fin del listener

