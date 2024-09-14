package org.example;

import org.example.btns.InterfaceBtns;
import org.example.btns.InterfaceBtnsIMPL;
import org.example.btns.Resource;
import org.example.dictionary.DictionaryTranslator;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Controller extends TelegramLongPollingBot {
    private final String TOKEN="BOT_TOKEN";
    private final String USERNAME="BOT_USERNAME";
    private final InterfaceBtns btns=new InterfaceBtnsIMPL();
    private final DictionaryTranslator translator=new DictionaryTranslator();
    private static String status="";
    private final Resource resource=new Resource();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            if (message.hasText()){
                String text = message.getText(),txt="";
                if (text.equals("/start")||text.equals("Bosh menu")){
                    status="";
                    System.out.println(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("quyidagi tillardan birini tanlang");
                    sendMessage.setReplyMarkup(btns.btnKeyboardBTN(resource.til()));
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (text.equals("С русского на английский")) {
                    System.out.println(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("введите слово");
                    status="ru-en";
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (text.equals("From English to Russian")) {
                    System.out.println(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("enter a word");
                    status="en-ru";
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (status.equals("ru-en")||status.equals("en-ru")) {
                    System.out.println(text);
                    System.out.println("status: "+status);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(translator.getResult((status.equals("ru-en")?"ru":"en"),(status.equals("ru-en")?"en":"ru"),text));
                    sendMessage.setReplyMarkup(btns.btnKeyboardBTN(resource.bosh()));
                    System.out.println(translator.getResult((status.equals("ru-en")?"ru":"en"),(status.equals("en-ru")?"en":"ru"),text));
                    System.out.println("status: "+status);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }
}
