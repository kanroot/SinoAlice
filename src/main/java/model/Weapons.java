package model;

import java.io.File;
import java.util.*;

public class Weapons {

    public ArrayList<HashMap<String, String>> weapons = new ArrayList<>();

    public Weapons() {
        generarWeapon();
    }

    private String[] leertxt() {
        String s2 = "</div></td></tr><tr>";
        String lineaI = "";
        String[] e;
        try {
            Scanner input = new Scanner(new File("C:\\Users\\GeoSS\\IdeaProjects\\SinoAlice\\assets\\data\\weapons.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains("enname")) {
                    lineaI = line;
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        e = lineaI.split(s2);
        return e;
    }

    public String extraerUnNom(String e) {
        int reference = e.lastIndexOf("enname");
        int initialpos = e.indexOf("\">", reference);
        int lastpos = e.indexOf("</a>", reference);
        return e.substring(initialpos + 2, lastpos) + " ";
    }

    public String extraertype(String e) {
        int reference = e.lastIndexOf("eqtypeImg");
        int initialpos = e.indexOf("<br>", reference);
        int lastpos = e.indexOf("</span>", reference);
        return e.substring(initialpos + 4, lastpos);
    }

    //convertir img
    public String convertirImg(String s) {
        var e = extraerImagen(s);
        String j = "";
        if (e.contains("002")) {
            j = "Water";
        }
        if (e.contains("003")) {
            j = "Wind";
        }
        if (e.contains("001")) {
            j = "Fire";
        }
        return j;
    }

    //img
    public String extraerImagen(String s) {
        int reference = s.lastIndexOf("attrImg");
        int initialpos = s.indexOf("src", reference) + 5;
        int postfinal = s.indexOf("\">", initialpos);
        return (s.substring(initialpos, postfinal));

    }

    public String extraerCard(String s) {
        int initialpos = s.indexOf("/CardS");
        int postfinal = s.indexOf("\">", initialpos);
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/assets/img_weapons" + s.substring(initialpos, postfinal));
    }

    public String extraerPatk(String s) {
        int reference = s.indexOf("colMaxPAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));

    }

    public String extraerPDef(String s) {
        int reference = s.indexOf("colMaxPDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    public String extraerMatk(String s) {
        int reference = s.indexOf("colMaxMAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    public String extraerMDef(String s) {
        int reference = s.indexOf("colMaxMDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    public String extraerTotal(String s) {
        int reference = s.indexOf("colMaxTotal");
        int initialpos = s.indexOf("bold\">", reference);
        int lastpos = s.indexOf("<br>", initialpos);
        return s.substring(initialpos + 6, lastpos);
    }

    //nivel inicial
    public String extraerlvl(String s) {
        int reference = s.indexOf("bold");
        int initialpos = s.indexOf("br>", reference);
        int lastpos = s.indexOf("</", reference);
        return s.substring(initialpos + 3, lastpos);
    }

    //Tt.ATK colMaxTotalAtk
    public String extraerTtATK(String s) {
        int reference = s.indexOf("colMaxTotalAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //Tt.DEF colMaxTotalAtk
    public String extraerTtDef(String s) {
        int reference = s.indexOf("colMaxTotalDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //colMaxAtkImp PATK + TT.DEF
    public String extraermaxAtkImp(String s) {
        int reference = s.indexOf("colMaxAtkImp");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //colMaxMAtkImp MATK + DEF
    public String extraermaxMatkImp(String s) {
        int reference = s.indexOf("colMaxMAtkImp");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //ST.SKILL
    public String extraerSkillbase(String s) {
        int reference = s.indexOf("tableDetail en");
        int initialpos = s.indexOf("\">", reference);
        int lastpos = s.indexOf("</div>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //COLO SKILL
    public String extraerSkillcolo(String s) {
        int reference = s.lastIndexOf("colGvgAidSkill");
        int initialpos = s.indexOf("</div><div class=\"tableDetail en\">", reference);
        int lastpos = s.indexOf(".", initialpos);
        return (s.substring(initialpos + 34, lastpos));
    }

    //NAME COLO SKILL
    public String extraerNameColo(String s) {
        int reference = s.indexOf("battleImg");
        int initialpos = s.indexOf("\">", reference);
        String j = (s.substring(initialpos));
        int postfinal = j.indexOf("</div>") + 1;
        return (j.substring(3, postfinal - 1).toUpperCase());
    }

    //AID
    public String extraerCAid(String s) {
        int reference = s.lastIndexOf("battleImg");
        int initialpos = s.indexOf("\">", reference);
        String j = (s.substring(initialpos));
        int postfinal = j.indexOf("</div>") + 1;
        return (j.substring(3, postfinal - 1).toUpperCase());
    }


    public HashMap<String, String> crearDic(String weapons) {
        //UNICO DICCIONARIO
        //COLECCION DE LLAVES Y VALORES
        HashMap<String, String> dicWeapon = new HashMap<>();

        var nombre = extraerUnNom(weapons).toUpperCase();
        var type = extraertype(weapons);
        var element = convertirImg(weapons);
        var Patk = extraerPatk(weapons);
        var PDef = extraerPDef(weapons);
        var Matk = extraerMatk(weapons);
        var mDef = extraerMDef(weapons);
        var total = extraerTotal(weapons);
        var lvl = extraerlvl(weapons);
        var tTATK = extraerTtATK(weapons);
        var tTDef = extraerTtDef(weapons);
        var pAtkTTdef = extraermaxAtkImp(weapons);
        var mAtkTtDef = extraermaxMatkImp(weapons);
        var skill = extraerSkillbase(weapons);
        var coloSkill = extraerSkillcolo(weapons);
        var nameColoSkill = extraerNameColo(weapons);
        var aidskill = extraerCAid(weapons);
        var img = extraerCard(weapons);

        //METIENDO UNA LLAVE Y UN VALOR AL DICCIONARIO
        dicWeapon.put("NAME", nombre);
        dicWeapon.put("TYPE", type);
        dicWeapon.put("PATK", Patk);
        dicWeapon.put("PDEF", PDef);
        dicWeapon.put("MATK", Matk);
        dicWeapon.put("MDEF", mDef);
        dicWeapon.put("TOTAL", total);
        dicWeapon.put("LVL", lvl);
        dicWeapon.put("TTATK", tTATK);
        dicWeapon.put("TTDEF", tTDef);
        dicWeapon.put("PATKTTDEF", pAtkTTdef);
        dicWeapon.put("MATKTTDEF", mAtkTtDef);
        dicWeapon.put("SKILL", skill);
        dicWeapon.put("COLOSKILL", coloSkill);
        dicWeapon.put("NAMECOLO", nameColoSkill);
        dicWeapon.put("ELEMENT", element);
        dicWeapon.put("AID", aidskill);
        dicWeapon.put("IMG", img);
        return dicWeapon;
    }

    public void generarWeapon() {
        var leer = leertxt();
        for (String s : leer) {
            var valores = crearDic(s);
            weapons.add(valores);
        }
    }

    public HashMap<String, String> buscar(String buscado) {
        for (var e : weapons) {
            if (e.get("NAME").contains(buscado.toUpperCase())) {
                return e;
            }
        }
        return new HashMap<>();
    }

    public HashMap<String, String> buscar(int buscado) {

        return weapons.get(buscado - 1);
    }

    public ArrayList<HashMap<String, String>> buscare(String element) {
        ArrayList<HashMap<String, String>> f = new ArrayList<>();
        if (element.equalsIgnoreCase("fire") || element.equalsIgnoreCase("wind") ||
                element.equalsIgnoreCase("water")) {
            for (HashMap<String, String> weapon : weapons) {
                if (weapon.get("ELEMENT").equalsIgnoreCase(element)) {
                    f.add(weapon);
                }
            }
        } else {
            for (HashMap<String, String> weapon : weapons) {
                if (weapon.get("TYPE").equalsIgnoreCase(element)) {
                    f.add(weapon);
                }
            }
        }
        return f;
    }

    public ArrayList<HashMap<String, String>> filtroElemType(String element, String type, String filtro) {
        ArrayList<HashMap<String, String>> f = new ArrayList<>();
        for (HashMap<String, String> weapon : weapons) {
            if (weapon.get("ELEMENT").equalsIgnoreCase(element) && weapon.get("TYPE").equalsIgnoreCase(type)) {
                f.add(weapon);
            }
        }
        //orden inverso
        f.sort(Comparator.comparing(m -> Integer.parseInt(m.get(filtro)), Comparator.nullsLast(Comparator.reverseOrder())));
        return f;
    }

    public ArrayList<HashMap<String, String>> point() {
        int totalpoint = 0;
        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        var Hash = new HashMap<String, String>();
        for (HashMap<String, String> stringStringHashMap : weapons) {
            if (totalpoint <= Integer.parseInt(stringStringHashMap.get("TOTAL"))) {
                Hash = stringStringHashMap;
                totalpoint = Integer.parseInt(stringStringHashMap.get("TOTAL"));
            }
        }
        for (HashMap<String, String> stringStringHashMap : weapons) {
            if (Hash.get("TOTAL").equalsIgnoreCase(stringStringHashMap.get("TOTAL"))) {
                array.add(stringStringHashMap);
            }
        }

        return array;
    }

    public ArrayList<HashMap<String, String>> aidSkill(String aidskill) {

        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : weapons) {
            if (stringStringHashMap.get("AID").contains(aidskill.toUpperCase())) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }

    public ArrayList<HashMap<String, String>> coloSkill(String coloSkill) {

        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : weapons) {
            if (stringStringHashMap.get("NAMECOLO").contains(coloSkill.toUpperCase())) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }
}
