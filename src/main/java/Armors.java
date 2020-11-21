import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Armors {
    ArrayList<HashMap<String, String>> armor = new ArrayList<>();

    public Armors() {
        generarArmor();
    }

    private String[] leertxt() {
        String s2 = "</div></div></td></tr><tr><td class=\"colCompare\">";
        String lineaI = "";
        String[] e;
        try {
            Scanner input = new Scanner(new File("C:\\Users\\GeoSS\\IdeaProjects\\SinoAlice\\src\\main\\armors.txt"));
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
        return e.substring(initialpos + 2, lastpos);

    }

    public String extraerPDef(String s) {
        int reference = s.lastIndexOf("colFullPDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    public String extraerMDef(String s) {
        int reference = s.lastIndexOf("colFullMDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    public String extraerTotal(String s) {
        int reference = s.lastIndexOf("colFullTotal");
        int initialpos = s.indexOf("class=\"bold\">", reference);
        int lastpos = s.indexOf("<br>", reference);
        return s.substring(initialpos + 13, lastpos);
    }

    public String extraerType(String s) {
        int reference = s.lastIndexOf("colEqType");
        int initialpos = s.indexOf("<span>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 6, lastpos));
    }

    //ST.SKILL
    public String extraerSkillbase(String s) {
        int reference = s.lastIndexOf("questTitle");
        int initialpos = s.indexOf("<div>", reference);
        int lastpos = s.indexOf("</div>", initialpos);
        return (s.substring(initialpos + 5, lastpos));
    }

    //NAME STORYSKILL
    public String extraerStorySkill(String s) {
        int reference = s.indexOf("battleImg");
        int initialpos = s.indexOf("\">", reference);
        int lastpos = s.indexOf("</div>", initialpos);
        return (s.substring(initialpos + 3, lastpos).toUpperCase());
    }

    //COLO SKILL
    public String extraerSkillcolo(String s) {
        int reference = s.lastIndexOf("gvgTitle");
        int initialpos = s.indexOf("</div><div>", reference);
        int lastpos = s.indexOf(".", initialpos);
        return (s.substring(initialpos + 11, lastpos + 1));
    }

    //NAME COLO SKILL
    public String extraerNameColo(String s) {
        int reference = s.lastIndexOf("battleImg");
        int initialpos = s.indexOf("\">", reference);
        String j = (s.substring(initialpos));
        int postfinal = j.indexOf("</div>") + 1;
        return (j.substring(3, postfinal - 1).toUpperCase());
    }

    //settotal
    public String extraerSetTotal(String s) {
        int reference = s.lastIndexOf("colMaxSetSummary");
        int initialpos = s.indexOf("bold\">", reference);
        int lastpos = s.indexOf("<br>", initialpos);
        return (s.substring(initialpos + 6, lastpos));
    }

    //img
    public String extraerImagen(String s) {
        int reference = s.lastIndexOf("attrImg");
        int initialpos = s.indexOf("src", reference) + 5;
        int postfinal = s.indexOf("\">", initialpos);
        return (s.substring(initialpos, postfinal));
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
        if (e.contains("000")) {
            j = "Humans";
        }

        return j;
    }
    //img

    public String extraerCard(String s) {
        int initialpos = s.indexOf("CardS");
        int postfinal = s.indexOf("\">", initialpos);
        System.out.println("https://raw.githubusercontent.com/kanroot/SinoAlice/master/src/main/img_armor/" + s.substring(initialpos, postfinal));
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/src/main/img_armor/" + s.substring(initialpos, postfinal));
    }


    public HashMap<String, String> crearDic(String armors) {
        //UNICO DICCIONARIO
        //COLECCION DE LLAVES Y VALORES
        HashMap<String, String> dicArmor = new HashMap<>();

        var nombre = extraerUnNom(armors).toUpperCase();
        var type = extraerType(armors);
        var PDef = extraerPDef(armors);
        var mDef = extraerMDef(armors);
        var total = extraerTotal(armors);
        var skill = extraerSkillbase(armors);
        var nameSkill = extraerStorySkill(armors);
        var coloSkill = extraerSkillcolo(armors);
        var nameColo = extraerNameColo(armors);
        var element = convertirImg(armors);
        var settotal = extraerSetTotal(armors);
        var card = extraerCard(armors);
        //METIENDO UNA LLAVE Y UN VALOR AL DICCIONARIO
        dicArmor.put("NOMBRE", nombre);
        dicArmor.put("TYPE", type);
        dicArmor.put("PDEF", PDef);
        dicArmor.put("MDEF", mDef);
        dicArmor.put("TOTAL", total);
        dicArmor.put("SKILL", skill);
        dicArmor.put("NAMESKILL", nameSkill);
        dicArmor.put("COLOSKILL", coloSkill);
        dicArmor.put("NAMECOLO", nameColo);
        dicArmor.put("ELEMENT", element);
        dicArmor.put("SETTOTAL", settotal);
        dicArmor.put("IMG", card);
        return dicArmor;
    }

    public void generarArmor() {
        var leer = leertxt();

        for (String s : leer) {
            var valores = crearDic(s);
            armor.add(valores);
        }
    }

    public HashMap<String, String> buscar(String buscado) {
        for (var e : armor) {
            if (e.get("NOMBRE").contains(buscado.toUpperCase())) {
                return e;
            }
        }
        return new HashMap<>();
    }

    public ArrayList<HashMap<String, String>> buscare(String element) {
        ArrayList<HashMap<String, String>> f = new ArrayList<>();
        for (HashMap<String, String> armor : armor) {
            if (armor.get("ELEMENT").equalsIgnoreCase(element)) {
                f.add(armor);
            }
        }
        return f;
    }

    public ArrayList<HashMap<String, String>> filtroElemType(String element, String type, String filtro) {

        ArrayList<HashMap<String, String>> f = new ArrayList<>();
        for (HashMap<String, String> armor : armor) {
            if (armor.get("ELEMENT").equalsIgnoreCase(element) && armor.get("TYPE").equalsIgnoreCase(type)) {
                f.add(armor);
            }
        }
        f.sort(Comparator.comparing(m -> Integer.parseInt(m.get(filtro)), Comparator.nullsLast(Comparator.reverseOrder())));
        return f;
    }

    public HashMap<String, String> buscar(int buscado) {
        return armor.get(buscado - 1);
    }

    public ArrayList<HashMap<String, String>> point() {
        int totalpoint = 0;
        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        var Hash = new HashMap<String, String>();
        for (HashMap<String, String> stringStringHashMap : armor) {
            if (totalpoint <= Integer.parseInt(stringStringHashMap.get("TOTAL"))) {
                Hash = stringStringHashMap;
                totalpoint = Integer.parseInt(stringStringHashMap.get("TOTAL"));
            }
        }
        for (HashMap<String, String> stringStringHashMap : armor) {
            if (Hash.get("TOTAL").equalsIgnoreCase(stringStringHashMap.get("TOTAL"))) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }

    public ArrayList<HashMap<String, String>> storySkill(String storySkill) {

        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : armor) {
            if (stringStringHashMap.get("NAMESKILL").contains(storySkill.toUpperCase())) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }

    public ArrayList<HashMap<String, String>> coloSkill(String coloSkill) {

        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : armor) {
            if (stringStringHashMap.get("NAMECOLO").contains(coloSkill.toUpperCase())) {
                array.add(stringStringHashMap);
            }
        }
        return array;

    }
}