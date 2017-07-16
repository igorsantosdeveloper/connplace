package com.clinus.connplace;

public class Message {

    private final String attentionMessage;
    private final String invalidDate;
    private final String passwordsDoNotMatch;
    private final String nullFields;
    private final String ok;
    private final String invalidLogin;

    public Message(){

        attentionMessage = "Atenção";
        invalidDate = "Data inválida!";
        passwordsDoNotMatch = "As senhas não correspondem!";
        nullFields = "Campos nulos!";
        ok = "OK";
        invalidLogin = "Usuário e/ou senha inválido(s)";
    }

    public String getAttentionMessage() {
        return attentionMessage;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public String getPasswordsDoNotMatch() {
        return passwordsDoNotMatch;
    }

    public String getNullFields() {
        return nullFields;
    }

    public String getOk(){ return ok; }

    public String getInvalidLogin(){ return invalidLogin; }
}
