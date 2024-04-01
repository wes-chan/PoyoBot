package me.raimi;

import me.raimi.commands.BotCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, InterruptedException {

        // Startup Menu
        JDA bot = JDABuilder.createDefault("CODE")
                .setActivity(Activity.playing("Poyo~"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .addEventListeners(new Event())
                .addEventListeners(new BotCommands())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .build().awaitReady();


        Guild guild = bot.getGuildById("GUILD CODE");


        if (guild != null){

            guild.upsertCommand("pepe", "meme").queue();

            guild.upsertCommand("calculator", "Name two names")
                .addOption(OptionType.USER, "user1", "One person to compare", true)
                    .addOption(OptionType.USER, "user2", "One person to compare", true)
                    .queue();

            guild.upsertCommand("coinflip", "Heads or Tails").queue();

            }



        }






}
