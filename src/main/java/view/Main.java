package view;

import controller.HelloWorld;
import model.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static final String prefix = "!";
    public static Nigthmares pesadillas = new Nigthmares();
    public static Armors armaduras = new Armors();
    public static Weapons armas = new Weapons();
    public static Pj pjs = new Pj();
    // define an eventwaiter, dont forget to add this to the JDABuilder!


    public static void main(String []args) throws LoginException {
        HelloWorld.main(args);
        JDA jda = JDABuilder.createDefault(System.getenv("token")).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("SINoAlice"));

        //generacion de instancias
        jda.addEventListener(new Commands());
    }
}
