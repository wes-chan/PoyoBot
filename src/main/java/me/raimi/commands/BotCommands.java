package me.raimi;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


    public class BotCommands extends ListenerAdapter {

        @Override
        public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

            if (event.getName().equals("PoyoPoyo")){
                event.deferReply().queue();
                event.getHook().sendMessage("You are gay").setEphemeral(true).queue();
            }





        }
    }
