package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pj {
    ArrayList<HashMap<String, String>> pjs = new ArrayList<>();

    public Pj() {
        generarAlice();
    }

    private ArrayList<String> leertxt() {
        ArrayList<String> e = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("C:\\Users\\GeoSS\\IdeaProjects\\SinoAlice\\assets\\data\\all_jobs.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("Character：")) {
                    e.add(line);
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public String extractName(String e) {
        int reference = e.indexOf("Character：");
        int initialpos = e.indexOf("\">", reference);
        int lastpos = e.indexOf("</a>", initialpos);
        return e.substring(initialpos + 2, lastpos) + " ";
    }

    public String extractJob(String e) {
        int reference = e.indexOf("Job：");
        int initialpos = e.indexOf("\">", reference);
        int lastpos = e.indexOf("</a>", initialpos);
        return e.substring(initialpos + 2, lastpos);
    }

    public String extractPrimaryWeapon(String e) {
        int reference = e.indexOf("eqTypeDiv");
        int initialpos = e.indexOf("/weapon", reference);
        int lastpos = e.indexOf("\">", initialpos);
        return e.substring(initialpos + 13, lastpos - 4);
    }

    public String giveStringWeapon(String e) {
        var number = extractPrimaryWeapon(e);
        String weaponString = "";
        switch (number) {
            case "001":
                weaponString = "Instr.";
                break;
            case "002":
                weaponString = "Tome";
                break;
            case "003":
                weaponString = "Focus";
                break;
            case "004":
                weaponString = "Staff";
                break;
            case "005":
                weaponString = "Blade";
                break;
            case "006":
                weaponString = "Hammer";
                break;
            case "007":
                weaponString = "Ranged";
                break;
            case "008":
                weaponString = "Polearm";
                break;
        }
        return weaponString;
    }

    public String[] extractUrlUsableWeapon(String e) {
        String[] f;
        int reference = e.indexOf("Usable<br>Weapon");
        int initialpos = e.indexOf("/weapon", reference);
        int lastpos = e.indexOf("></div></div></td></tr></tbody></table>", initialpos);
        f = (e.substring(initialpos, lastpos)).split("</div></div>");
        return f;
    }

    public ArrayList<String> extractNumberUsable(String e) {
        var f = extractUrlUsableWeapon(e);
        ArrayList<String> number = new ArrayList<>();
        for (String s : f) {
            int reference = s.indexOf("weapon_icon_");
            int initialpos = s.indexOf("0", reference);
            int lastpos = s.indexOf(".png", initialpos);
            number.add(s.substring(initialpos, lastpos));
        }
        return number;
    }

    public String giveStringWeaponUsable(String e) {
        var number = extractNumberUsable(e);
        StringBuilder weaponString = new StringBuilder();
        for (String s : number) {
            switch (s) {
                case "001":
                    weaponString.append(" Instr. ");
                    break;
                case "002":
                    weaponString.append(" Tome ");
                    break;
                case "003":
                    weaponString.append(" Focus ");
                    break;
                case "004":
                    weaponString.append(" Staff ");
                    break;
                case "005":
                    weaponString.append(" Blade ");
                    break;
                case "006":
                    weaponString.append(" Hammer ");
                    break;
                case "007":
                    weaponString.append(" Ranged ");
                    break;
                case "008":
                    weaponString.append(" Polearm ");
                    break;
            }
        }
        return weaponString.toString();
    }

    public String extractLvl1(String e) {
        int reference = e.indexOf("Lv1</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl2(String e) {
        int reference = e.indexOf("Lv2</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl3(String e) {
        int reference = e.indexOf("Lv3</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl4(String e) {
        int reference = e.indexOf("Lv4</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl5(String e) {
        int reference = e.indexOf("Lv5</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl6(String e) {
        int reference = e.indexOf("Lv6</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl7(String e) {
        int reference = e.indexOf("Lv7</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl8(String e) {
        int reference = e.indexOf("Lv8</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl9(String e) {
        int reference = e.indexOf("Lv9</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl10(String e) {
        int reference = e.indexOf("Lv10</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl11(String e) {
        int reference = e.indexOf("Lv11</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractLvl12(String e) {
        int reference = e.indexOf("Lv12</span>");
        int initialpos = e.indexOf("\"abSkill\">", reference);
        int lastpos = e.indexOf("</span>", initialpos);
        int initialpos2 = e.indexOf("abType", reference);
        int lastpos2 = e.indexOf("</span>", initialpos2);
        return e.substring(initialpos2 + 14, lastpos2) + ": " + e.substring(initialpos + 10, lastpos);
    }

    public String extractCard(String s) {
        int initialpos = s.indexOf("/CharacterIcon");
        int postfinal = s.indexOf("\">", initialpos);
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/assets/img_jobs/" + s.substring(initialpos, postfinal));
    }

    public HashMap<String, String> crearDic(String pjs) {
        //UNICO DICCIONARIO
        //COLECCION DE LLAVES Y VALORES
        HashMap<String, String> dicPj = new HashMap<>();
        var name = extractName(pjs).toUpperCase();
        var job = extractJob(pjs).toUpperCase();
        var primary = giveStringWeapon(pjs);
        var usable = giveStringWeaponUsable(pjs);
        var lv1 = extractLvl1(pjs);
        var lv2 = extractLvl2(pjs);
        var lv3 = extractLvl3(pjs);
        var lv4 = extractLvl4(pjs);
        var lv5 = extractLvl5(pjs);
        var lv6 = extractLvl6(pjs);
        var lv7 = extractLvl7(pjs);
        var lv8 = extractLvl8(pjs);
        var lv9 = extractLvl9(pjs);
        var lv10 = extractLvl10(pjs);
        var lv11 = extractLvl11(pjs);
        var lv12 = extractLvl12(pjs);
        var img = extractCard(pjs);
        //var img = extractCard(pjs);
        dicPj.put("NAME", name);
        dicPj.put("JOB", job);
        dicPj.put("PRIMARY", primary);
        dicPj.put("USABLE", usable);
        dicPj.put("LVL1", lv1);
        dicPj.put("LVL2", lv2);
        dicPj.put("LVL3", lv3);
        dicPj.put("LVL4", lv4);
        dicPj.put("LVL5", lv5);
        dicPj.put("LVL6", lv6);
        dicPj.put("LVL7", lv7);
        dicPj.put("LVL8", lv8);
        dicPj.put("LVL9", lv9);
        dicPj.put("LVL10", lv10);
        dicPj.put("LVL11", lv11);
        dicPj.put("LVL12", lv12);
        dicPj.put("IMG", img);
        return dicPj;
    }

    public void generarAlice() {
        var leer = leertxt();
        for (String s : leer) {
            var valores = crearDic(s);
            pjs.add(valores);
        }
    }

    public ArrayList<HashMap<String, String>> find(String name) {
        ArrayList<HashMap<String, String>> f = new ArrayList<>();
        for (HashMap<String, String> pj : pjs) {
            if (pj.get("NAME").equalsIgnoreCase(name)) {
                f.add(pj);
            }
        }
        return f;
    }

    public ArrayList<HashMap<String, String>> find(String name, String job) {
        ArrayList<HashMap<String, String>> f = new ArrayList<>();
        for (HashMap<String, String> pj : pjs) {
            if (pj.get("NAME").contains(name) && pj.get("JOB").contains(job)) {
                f.add(pj);
            }
        }
        return f;
    }
}
