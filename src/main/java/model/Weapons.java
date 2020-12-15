package model;

import controller.JsonReader;
import org.json.simple.JSONObject;
import java.util.*;

public class Weapons {

    public ArrayList<HashMap<String, String>> weapons = new ArrayList<>();

    public Weapons() {
        generarWeapon();
    }

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
        return j;
    }

    public String extraerCard(String s) {
        return ("https://raw.githubusercontent.com/kanroot/SinoAlice/master/assets/img_weapons/" + s);
    }


    public HashMap<String, String> crearDic(JSONObject weaponsData) {
        //UNICO DICCIONARIO
        //COLECCION DE LLAVES Y VALORES
        HashMap<String, String> dicWeapon = new HashMap<>();

        var nombre = weaponsData.get("NAME").toString().toUpperCase() + " ";
        var type = weaponsData.get("TYPE").toString();
        var element = convertirImg(weaponsData.get("ELEMENT").toString());
        var Patk = weaponsData.get("PATK").toString();
        var PDef = weaponsData.get("PDEF").toString();
        var Matk = weaponsData.get("MATK").toString();
        var mDef = weaponsData.get("MDEF").toString();
        var total = weaponsData.get("TOTAL").toString();
        var lvl = weaponsData.get("LVL").toString();
        var tTATK = weaponsData.get("TTATK").toString();
        var tTDef = weaponsData.get("TTDEF").toString();
        var pAtkTTdef = weaponsData.get("PATKTTDEF").toString();
        var mAtkTtDef = weaponsData.get("MATKTTDEF").toString();
        var skill = weaponsData.get("STORY").toString().toUpperCase();
        var skillStory =   weaponsData.get("SKILLSTORY").toString();
        var coloSkill = weaponsData.get("SKILLCOLO").toString();
        var nameColoSkill = weaponsData.get("COLO").toString().toUpperCase();
        var nameAid = weaponsData.get("AID").toString().toUpperCase();
        var aidskill = weaponsData.get("SKILLAID").toString();
        var cost = weaponsData.get("COST").toString();
        var img = extraerCard(weaponsData.get("CARD").toString());

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
        dicWeapon.put("STORYSKILL", skillStory);
        dicWeapon.put("SKILL", skill);
        dicWeapon.put("NAMECOLO", nameColoSkill);
        dicWeapon.put("COLOSKILL", coloSkill);
        dicWeapon.put("ELEMENT", element);
        dicWeapon.put("NAMEAID", nameAid);
        dicWeapon.put("AID", aidskill);
        dicWeapon.put("IMG", img);
        dicWeapon.put("COST", cost);
        return dicWeapon;
    }

    public void generarWeapon() {
        var jsonArray = JsonReader.parserJson("Weapons");
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            var dic = crearDic(jsonObject);
            weapons.add(dic);
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
