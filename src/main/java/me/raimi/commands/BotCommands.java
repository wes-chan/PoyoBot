package me.raimi.commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class BotCommands extends ListenerAdapter {

        @Override
        public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

            if (event.getName().equals("pepe")){
                event.deferReply().queue();
                event.getHook().sendMessage("You are meme").queue();
            }

            if (event.getName().equals("calculator")){

                User user1 = Objects.requireNonNull(event.getOption("user1")).getAsUser();
                User user2 = Objects.requireNonNull(event.getOption("user2")).getAsUser();
                int loveScore = calculateLoveScore(user1, user2);
                if(loveScore > 50) {
                    event.reply(user1.getAsMention() + " and " + user2.getAsMention() + ", your love score is: " + loveScore + "%! :heart:").queue();
                } else {
                    event.reply(user1.getAsMention() + " and " + user2.getAsMention() + ", your love score is: " + loveScore + "%! :broken_heart:").queue();

                }
            }


            if (event.getName().equals("coinflip")){
                event.reply(coinFlipper()).queue();

            }


        }

    private int calculateLoveScore(User player, User player1) {
        // Add your love calculation logic here (you can use a random number or any algorithm)
        return (int) (Math.random() * 100);
    }

    private String coinFlipper(){
          int Coin =  (int)(Math.random() * 2);
        if (Coin == 0) {
            return "Heads";
        } else {
            return "Tails";
        }

    }

}

