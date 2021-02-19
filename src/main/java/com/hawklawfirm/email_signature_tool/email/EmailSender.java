package com.hawklawfirm.email_signature_tool.email;

public interface EmailSender {
    void send(String to, String email, String subject);
}
