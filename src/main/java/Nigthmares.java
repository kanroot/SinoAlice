import java.io.File;
import java.util.*;

public class Nigthmares {

    public Nigthmares() {
        generarNightmare();
    }

    ArrayList<HashMap<String, String>> night = new ArrayList<>();

    private String[] leertxt() {
        String s2 = "</tr><tr><td class=\"colCompare\">";
        String lineaI = "";
        String[] e;
        try {
            Scanner input = new Scanner(new File("C:\\Users\\GeoSS\\IdeaProjects\\SinoAlice\\src\\main\\nightmares.txt"));
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

    //nivel base
    public String extraerUnNom(String e) {
        int reference = e.lastIndexOf("enname");
        int initialpos = e.indexOf("\">", reference);
        int lastpos = e.indexOf("</a>", initialpos);
        return e.substring(initialpos + 2, lastpos);
    }

    //patk
    public String extraerPatk(String s) {
        int reference = s.indexOf("colFullPAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //pDef
    public String extraerpDef(String s) {
        int reference = s.indexOf("colFullPDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //matk
    public String extraerMatk(String s) {
        int reference = s.indexOf("colFullMAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //mdef
    public String extraermdef(String s) {
        int reference = s.indexOf("colFullMDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //total
    public String extraerTotal(String s) {
        int reference = s.indexOf("colFullTotal");
        int initialpos = s.indexOf("bold\">", reference);
        int lastpos = s.indexOf("<br>", reference);
        return s.substring(initialpos + 6, lastpos);
    }

    //nivel inicial
    public String extraerlvl(String s) {
        int reference = s.indexOf("bold");
        int initialpos = s.indexOf("br>", reference);
        int lastpos = s.indexOf("</", reference);
        return s.substring(initialpos + 3, lastpos);
    }

    //PATKFULL
    public String extraerpatkFull(String s) {
        int reference = s.lastIndexOf("colMaxPAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", reference);
        return (s.substring(initialpos + 2, lastpos));
    }

    //PDEFFULL
    public String extraerFullpDef(String s) {
        int reference = s.lastIndexOf("colMaxPDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", reference);
        return (s.substring(initialpos + 2, lastpos));
    }

    //MAtkFULL
    public String extraerFullMaxMAtk(String s) {
        int reference = s.indexOf("colMaxMAtk");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", reference);
        return (s.substring(initialpos + 2, lastpos));
    }

    //MDEFFULL
    public String extraerFullMDef(String s) {
        int reference = s.indexOf("colMaxMDef");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</", reference);
        return (s.substring(initialpos + 2, lastpos));
    }

    //fulltotal

    public String extraerfullTotal(String s) {
        int reference = s.indexOf("colMaxTotal");
        int initialpos = s.indexOf("bold", reference);
        int lastpos = s.indexOf("<br>", reference);
        return (s.substring(initialpos + 6, lastpos));
    }

    //fulllvl

    public String extraerfulllvl(String s) {
        int reference = s.indexOf("colMaxTotal");
        int initialpos = s.indexOf("<br>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 4, lastpos));
    }
    //ST.SKILL

    public String extraerSkillbase(String s) {
        int reference = s.lastIndexOf("questTitle");
        int initialpos = s.indexOf("tableDetail en\"", reference);
        int lastpos = s.indexOf("</div>", initialpos + 16);
        return (s.substring(initialpos + 16, lastpos));
    }

    //NAME STORYSKILL
    public String extraerStorySkill(String s) {
        int reference = s.indexOf("battleImg");
        int initialpos = s.indexOf("\">", reference);
        int lastpos = s.indexOf("</div>", initialpos);
        return (s.substring(initialpos + 3, lastpos)).toUpperCase();
    }

    //COLO SKILL
    public String extrarColoSkill(String s) {
        int reference = s.lastIndexOf("gvgTitle");
        int initialpos = s.indexOf("tableDetail en", reference) + 16;
        String j = (s.substring(initialpos));
        int postfinal = j.indexOf(".") + 1;
        return (j.substring(0, postfinal));
    }

    //NAME SKILL
    public String extraerNameColo(String s) {
        int reference = s.lastIndexOf("battleImg");
        int initialpos = s.indexOf("\">", reference);
        String j = (s.substring(initialpos));
        int postfinal = j.indexOf("</div>") + 1;
        return (j.substring(3, postfinal - 1)).toUpperCase();
    }

    //OTROS
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

    //colMaxMAtkImp
    public String extraermaxMatkImp(String s) {
        int reference = s.indexOf("colMaxMAtkImp");
        int initialpos = s.indexOf("n>", reference);
        int lastpos = s.indexOf("</span>", initialpos);
        return (s.substring(initialpos + 2, lastpos));
    }

    //colGvgSkillLead
    public String extraerTimePre(String s) {
        int reference = s.indexOf("colGvgSkillLead");
        int initialpos = s.indexOf(">", reference);
        int lastpos = s.indexOf("</", initialpos);
        return (s.substring(initialpos + 1, lastpos));
    }

    public String extraerTimeDuration(String s) {
        int reference = s.indexOf("colGvgSkillDur");
        int initialpos = s.indexOf(">", reference);
        int lastpos = s.indexOf("</td>", initialpos);
        return (s.substring(initialpos + 1, lastpos));
    }

    public String extraerCard(String s) {
        int initialpos = s.indexOf("/CardS");
        int postfinal = s.indexOf("\">", initialpos);
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/src/main/img_nightmares/" + s.substring(initialpos, postfinal));
    }

    public HashMap<String, String> crearDic(String nightmare) {
        //UNICO DICCIONARIO
        //COLECCION DE LLAVES Y VALORES
        HashMap<String, String> dicNightmare = new HashMap<>();

        var nombre = extraerUnNom(nightmare).toUpperCase();
        var pAtk = extraerPatk(nightmare);
        var pDef = extraerpDef(nightmare);
        var mAtk = extraerMatk(nightmare);
        var mDef = extraermdef(nightmare);
        var total = extraerTotal(nightmare);
        var lvl = extraerlvl(nightmare);
        var ptkFull = extraerpatkFull(nightmare);
        var fullPDef = extraerFullpDef(nightmare);
        var fullMAtk = extraerFullMaxMAtk(nightmare);
        var fullMDEF = extraerFullMDef(nightmare);
        var maxTotal = extraerfullTotal(nightmare);
        var fullLvl = extraerfulllvl(nightmare);
        var skill = extraerSkillbase(nightmare);
        var coloSkill = extrarColoSkill(nightmare);
        var ttatk = extraerTtATK(nightmare);
        var ttDef = extraerTtDef(nightmare);
        var patkttdef = extraermaxAtkImp(nightmare);
        var matkttdef = extraermaxMatkImp(nightmare);
        var time = extraerTimePre(nightmare);
        var duration = extraerTimeDuration(nightmare);
        var nameStorySkill = extraerStorySkill(nightmare);
        var nameColo = extraerNameColo(nightmare);
        var img = extraerCard(nightmare);
        //METIENDO UNA LLAVE Y UN VALOR AL DICCIONARIO
        dicNightmare.put("NOMBRE", nombre);
        dicNightmare.put("PATK", pAtk);
        dicNightmare.put("PDEF", pDef);
        dicNightmare.put("MATK", mAtk);
        dicNightmare.put("MDEF", mDef);
        dicNightmare.put("TOTAL", total);
        dicNightmare.put("LVL", lvl);
        //lvl max
        dicNightmare.put("PAKTOTAL", ptkFull);
        dicNightmare.put("FULLDEF", fullPDef);
        dicNightmare.put("FULLMATK", fullMAtk);
        dicNightmare.put("FULLMDEF", fullMDEF);
        dicNightmare.put("TOTALMAXLEV", maxTotal);
        dicNightmare.put("FULLLVL", fullLvl);
        dicNightmare.put("SKILL", skill);
        dicNightmare.put("NAMESTORY", nameStorySkill);
        dicNightmare.put("COLOSKILL", coloSkill);
        dicNightmare.put("NAMECOLO", nameColo);
        //otros
        dicNightmare.put("TTATK", ttatk);
        dicNightmare.put("TTDEF", ttDef);
        dicNightmare.put("PATKTTDEF", patkttdef);
        dicNightmare.put("MATKTTDEF", matkttdef);
        dicNightmare.put("TIME", time);
        dicNightmare.put("DURATION", duration);
        dicNightmare.put("IMG",img);
        return dicNightmare;
    }

    public void generarNightmare() {
        var leer = leertxt();

        for (String s : leer) {
            var nightmare = crearDic(s);
            night.add(nightmare);
        }
    }

    public HashMap<String, String> buscar(String buscado) {
        for (var element : night) {
            if (element.get("NOMBRE").contains(buscado.toUpperCase())) {
                return element;
            }

        }
        return new HashMap<>();
    }

    public HashMap<String, String> buscar(int buscado) {

        return night.get(buscado - 1);
    }


    public ArrayList<HashMap<String, String>> point() {
        int totalpoint = 0;
        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        var Hash = new HashMap<String, String>();
        for (HashMap<String, String> stringStringHashMap : night) {
            if (totalpoint <= Integer.parseInt(stringStringHashMap.get("TOTAL"))) {
                Hash = stringStringHashMap;
                totalpoint = Integer.parseInt(stringStringHashMap.get("TOTAL"));
            }
        }
        for (HashMap<String, String> stringStringHashMap : night) {
            if (Hash.get("TOTAL").equalsIgnoreCase(stringStringHashMap.get("TOTAL"))) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }

    public ArrayList<HashMap<String, String>> storySkill(String storySkill) {

        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : night) {
            if (stringStringHashMap.get("NAMESTORY").contains(storySkill.toUpperCase())) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }

    public ArrayList<HashMap<String, String>> coloSkill(String coloSkill) {

        ArrayList<HashMap<String, String>> array = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : night) {
            if (stringStringHashMap.get("NAMECOLO").contains(coloSkill.toUpperCase())) {
                array.add(stringStringHashMap);
            }
        }
        return array;
    }

}


