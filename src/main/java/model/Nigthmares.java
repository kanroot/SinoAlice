package model;

import controller.JsonReader;
import org.json.simple.JSONObject;

import java.util.*;

public class Nigthmares {


    public Nigthmares() {
        generarNightmare();
    }

    public ArrayList<HashMap<String, String>> night = new ArrayList<>();


    public String extraerCard(String nightmare) {
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/assets/img_nightmares/" + nightmare);
    }

    public HashMap<String, String> crearDic(JSONObject nightmare) {
        //UNICO DICCIONARIO
        //COLECCION DE LLAVES Y VALORES
        HashMap<String, String> dicNightmare = new HashMap<>();

        var name = nightmare.get("NAME").toString().toUpperCase() + " ";
        var pAtk = nightmare.get("PATK").toString();
        var pDef = nightmare.get("PDEF").toString();
        var mAtk = nightmare.get("MATK").toString();
        var mDef = nightmare.get("MDEF").toString();
        var total = nightmare.get("TOTAL").toString();
        var lvl = nightmare.get("LVL").toString();
        var ptkFull = nightmare.get("MAXPATK").toString();
        var fullPDef = nightmare.get("MAXPDEF").toString();
        var fullMAtk = nightmare.get("MAXMATK").toString();
        var fullMDEF = nightmare.get("MAXMDEF").toString();
        var maxTotal = nightmare.get("MAXTOTAL").toString();
        var fullLvl = nightmare.get("MAXLVL").toString();
        var skill = nightmare.get("STORY").toString();
        var coloSkill = nightmare.get("COLO").toString();
        var ttatk = nightmare.get("TTATK").toString();
        var ttDef = nightmare.get("TTDEF").toString();
        var patkttdef = nightmare.get("PATKTTDEF").toString();
        var matkttdef = nightmare.get("MATKTTDEF").toString();
        var time = nightmare.get("PREPARATION").toString();
        var duration = nightmare.get("DURATION").toString();
        var nameStorySkill = nightmare.get("TITLESTORY").toString().toUpperCase();
        var nameColo = nightmare.get("TITLECOLO").toString().toUpperCase();
        var img = extraerCard(nightmare.get("Cards").toString());
        //METIENDO UNA LLAVE Y UN VALOR AL DICCIONARIO
        dicNightmare.put("NAME", name);
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
        dicNightmare.put("NAMESTORY", nameStorySkill.trim());
        dicNightmare.put("COLOSKILL", coloSkill);
        dicNightmare.put("NAMECOLO", nameColo.trim());
        //otros
        dicNightmare.put("TTATK", ttatk);
        dicNightmare.put("TTDEF", ttDef);
        dicNightmare.put("PATKTTDEF", patkttdef);
        dicNightmare.put("MATKTTDEF", matkttdef);
        dicNightmare.put("TIME", time);
        dicNightmare.put("DURATION", duration);
        dicNightmare.put("IMG", img);
        return dicNightmare;
    }

    public void generarNightmare() {
        var nightmaresData = JsonReader.parserJson("Nightmares");

        for (Object nightmaresDatum : nightmaresData) {
            JSONObject objectNight = (JSONObject) nightmaresDatum;
            night.add(crearDic(objectNight));
        }
    }

    public HashMap<String, String> buscar(String buscado) {
        for (var element : night) {
            if (element.get("NAME").contains(buscado.toUpperCase())) {
                return element;
            }

        }
        return new HashMap<>();
    }

    public HashMap<String, String> buscar(int buscado) {
        try {
            return night.get(buscado - 1);
        }catch (IndexOutOfBoundsException e){
            return new HashMap<>();
        }


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