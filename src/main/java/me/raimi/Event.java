package me.raimi;

import net.dv8tion.jda.api.entities.GuildWelcomeScreen;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Event extends ListenerAdapter {

    @Override

    public void onMessageReceived(@NotNull MessageReceivedEvent event) { // Controls the Poyo  and Crazy
        if (!event.getAuthor().isBot()) {
            String messageSent = event.getMessage().getContentRaw().toLowerCase();

            if (messageSent.contains("poyo")) {
                event.getChannel().sendMessage("Poyo! <@" + Objects.requireNonNull(event.getMember()).getId() + ">").queue();
            }

            if (messageSent.contains("crazy")){
                event.getChannel().sendMessage("Crazy? I was crazy once.\n" +
                        "They put me in a room.\n" +
                        "A rubber room.\n" +
                        "A rubber room with rats.\n" +
                        "They put me in a rubber room with rubber rats.\n" +
                        "Rubber rats? I hate rubber rats.\n" +
                        "They make me crazy.\n" +
                        "Crazy? I was crazy once.\n" +
                        "They put me in a room….").queue();
            }

            }
    }


    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) { // For Welcome Page

        String username = event.getMember().getUser().getName();
        String profileImageURL = event.getMember().getUser().getEffectiveAvatarUrl();


        try {
            BufferedImage backgroundImage = ImageIO.read(new File("Kirby.png"));

            int height = backgroundImage.getHeight();
            int width = backgroundImage.getWidth();

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();

            URI uri = new URI(profileImageURL);
            URL url = uri.toURL();
            BufferedImage profileImage = ImageIO.read(url);
            g2d.drawImage(profileImage, 455, 100, 200, 200, null);

            g2d.drawImage(backgroundImage, 0, 0, null);

            File welcomeImageFile = new File("welcome.png");
            ImageIO.write(image, "png", welcomeImageFile);
            g2d.dispose();
            TextChannel targetChannel = event.getGuild().getTextChannelById("1112676979053953084");


            FileUpload file = FileUpload.fromData(new File("welcome.png"), "image.png");

            if (targetChannel != null) {
                Objects.requireNonNull(event.getGuild().getTextChannelById("1112676979053953084")).sendMessage("Welcome to the Kingdom of Dreamland! <@" + Objects.requireNonNull(event.getMember()).getId() + ">").queue();
                targetChannel.sendFiles(file).queue();

            } else {
                System.err.println("The specified channel does not exist.");
            }

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
















