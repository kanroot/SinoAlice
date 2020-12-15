package model;

import controller.JsonReader;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Armors {
    public ArrayList<HashMap<String, String>> armor = new ArrayList<>();

    public Armors() {
        generarArmor();
    }


    //convertir img
    public String convertirImg(String s) {
        String j = "";
        if (s.contains("002")) {
            j = "Water";
        }
        if (s.contains("003")) {
            j = "Wind";
        }
        if (s.contains("001")) {
            j = "Fire";
        }
        if (s.contains("000")) {
            j = "Humans";
        }

        return j;
    }
    //img

    public String extraerCard(String s) {
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/assets/img_armor/" + s);
    }


    public HashMap<String, String> crearDic(JSONObject armorData) {
        HashMap<String, String> dicArmor = new HashMap<>();

        var nombre = armorData.get("NAME").toString().toUpperCase() + " ";
        var type = armorData.get("TYPE").toString();
        var PDef = armorData.get("PDEF").toString();
        var mDef = armorData.get("MDEF").toString();
        var total = armorData.get("TOTAL").toString();
        var skill = armorData.get("SKILLSTORY").toString();
        var nameSkill = armorData.get("STORY").toString().toUpperCase();
        var coloSkill = armorData.get("SKILLCOLO").toString();
        var nameColo = armorData.get("COLO").toString().toUpperCase();
        var element = convertirImg(armorData.get("ELEMENT").toString());
        var settotal = armorData.get("SETTOTAL").toString();
        var img = extraerCard(armorData.get("CARD").toString());
        //METIENDO UNA LLAVE Y UN VALOR AL DICCIONARIO
        dicArmor.put("NAME", nombre);
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
        dicArmor.put("IMG", img);
        return dicArmor;
    }

    public void generarArmor() {
        var dataJson = JsonReader.parserJson("Armor");
        for (Object o : dataJson) {
            JSONObject armorData = (JSONObject) o;
            var dic = crearDic(armorData);
            armor.add(dic);
        }
    }

    public HashMap<String, String> buscar(String buscado) {
        for (var e : armor) {
            if (e.get("NAME").contains(buscado.toUpperCase())) {
                return e;
            }
        }
        return new HashMap<>();
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