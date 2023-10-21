package me.raimi;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault("MTE2NTMyOTY4MzE2OTE1NzIwMg.GBC4M8.Z8s4EYEwW098ERKitBKrGfvWE-bj7G9IM6gOwk")
                .setActivity(Activity.playing("Poyo~"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();

    }
}
