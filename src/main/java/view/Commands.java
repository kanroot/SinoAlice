package view;

import java.util.ArrayList;
import java.util.HashMap;

import controller.MessageManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Commands extends ListenerAdapter {

    private final String keyName = "NAME";

    public void onMessageReceived(MessageReceivedEvent event) {
        //no lee mensajes propios
        if (event.getAuthor().equals(event.getJDA().getSelfUser())) return;

        String[] args = event.getMessage().getContentRaw().split(" ", 5);

        String opc = args[0].toUpperCase();
        switch (opc) {
            case Main.prefix + "H":
                MessageManager.help(event);
                break;
            case Main.prefix + "I":
                MessageManager.info(event);
                break;
            case Main.prefix + "N":
                if (args.length == 1) {
                    MessageManager.createList(event, nightmarePattern(" "), "All names of nightmares");
                } else {
                    String pattern = getString(args);
                    MessageManager.createList(event, nightmarePattern(pattern), "Matched");
                }
                break;
            case Main.prefix + "NN":
                String name;
                if (args.length > 2) {
                    name = getString(args);
                } else {
                    name = args[1];
                }
                searchNightmare(event, name);
                break;
            case Main.prefix + "MN":
                var point = Main.nigthmares.point();
                for (HashMap<String, String> stringStringHashtable : point) {
                    MessageManager.pestanaNightmare(event, stringStringHashtable);
                }
                break;
            case Main.prefix + "A":
                if (args.length == 1) {
                    MessageManager.createList(event, armorsfind(" "), "All armors");
                } else {
                    String pattern = getString(args);
                    MessageManager.createList(event, armorsfind(pattern), "Matched");
                }
                break;
            case Main.prefix + "NA":
                String nameArmors;
                if (args.length > 2) {
                    nameArmors = getString(args);
                } else {
                    nameArmors = args[1];
                }
                searchA(event, nameArmors);
                break;
            case Main.prefix + "MA":
                var pointA = Main.armors.point();
                for (HashMap<String, String> stringStringHashtable : pointA) {
                    MessageManager.pestanaArmor(event, stringStringHashtable);
                }

            case Main.prefix + "EA":
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
            case Main.prefix + "W":
                if (args.length == 1) {
                    MessageManager.createList(event, weaponsfind(" "), "All weapons");
                } else {
                    String pattern = getString(args);
                    MessageManager.createList(event, weaponsfind(pattern), "Matched");
                }
                break;
            case Main.prefix + "NW":
                String nameWeapon;
                if (args.length > 2) {
                    nameWeapon = getString(args);
                } else {
                    nameWeapon = args[1];
                }
                searchW(event, nameWeapon);
                break;
            case Main.prefix + "MW":
                var pointW = Main.weapons.point();
                for (HashMap<String, String> stringStringHashtable : pointW) {
                    MessageManager.pestanaWeapons(event, stringStringHashtable);
                }
                break;
            case Main.prefix + "EW":
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
            case Main.prefix + "NSN":
                if (args.length >= 2) {
                    String nameStory = getString(args);
                    var buscado = Main.nigthmares.storySkill(nameStory);
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaNightmare(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "NCN":
                if (args.length >= 2) {
                    String nameColo = getString(args);
                    var buscado = Main.nigthmares.coloSkill(nameColo);
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaNightmare(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "NCSW":
                if (args.length >= 2) {
                    String nameAid = getString(args);
                    var buscado = Main.weapons.aidSkill(nameAid);
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaWeapons(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "NCW":
                if (args.length >= 2) {
                    String nameWeaponColo = getString(args);
                    var buscado = Main.weapons.coloSkill(nameWeaponColo);
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaWeapons(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "NSA":
                if (args.length >= 2) {
                    String armorStory = getString(args);
                    var buscado = Main.armors.storySkill(armorStory);
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaArmor(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "NSET":
                if (args.length >= 2) {
                    String armorColo = getString(args);
                    var buscado = Main.armors.coloSkill(armorColo);
                    for (HashMap<String, String> stringStringHashMap : buscado) {
                        MessageManager.pestanaArmor(event, stringStringHashMap);
                    }
                }
                break;
            case Main.prefix + "NC":
                StringBuilder jobs = new StringBuilder();
                String jobClass = null;
                String nameJob = null;
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
                    if (nameJob != null) {
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
                }
                break;
        }

    }

    @NotNull
    private String getString(String[] args) {
        StringBuilder name = new StringBuilder();
        String pattern;
        for (int i = 1; i < args.length; i++) {
            name.append(args[i].toUpperCase()).append(" ");
        }
        name.deleteCharAt(name.lastIndexOf(" "));
        pattern = name.toString();
        return pattern;
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

