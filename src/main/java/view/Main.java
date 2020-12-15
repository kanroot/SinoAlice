package view;

import controller.HelloWorld;
import model.Armors;
import model.Nigthmares;
import model.Pj;
import model.Weapons;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {


    public static final String prefix = "!";
    public static Nigthmares nigthmares = new Nigthmares();
    public static Armors armors = new Armors();
    public static Weapons weapons = new Weapons();
    public static Pj pjs = new Pj();


    public static void main(String []args) throws LoginException {
        if (System.getenv("ENTORNO").equals("PRODUCTION")) {
            HelloWorld.main(args);
        }

        JDA jda = JDABuilder.createDefault(System.getenv("token")).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("SINoAlice"));

        //generacion de instancias
        jda.addEventListener(new Commands());
    }
}
