package com.hawklawfirm.email_signature_tool;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class BrowserLauncher {
    @EventListener(ApplicationReadyEvent.class)
    public void launchBrowser(){
        System.setProperty("java.awt.headless","false");
        Desktop desktop = Desktop.getDesktop();
        try {
//            Open web browser to MailDev server for testing
            desktop.browse(new URI("http://localhost:1080"));
//            Open web browser to main application
            desktop.browse(new URI("http://localhost:705/single"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
