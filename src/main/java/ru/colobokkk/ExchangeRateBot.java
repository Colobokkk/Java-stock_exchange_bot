package ru.colobokkk;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class ExchangeRateBot extends TelegramLongPollingBot {
    private static final String Bot_Token = "7397475840:AAEr5nYS8vckbGjsT2bCjYR60i-Mqkuua-g";
    private static final String Bot_Username = "Colostokkk";
    private static final long Chat_Id = 1107358655;
    private double lastDollarRate = 0;
    private double lastEuroRate = 0;

    @Override
    public String getBotToken(){
        return Bot_Token;
    }

    @Override
    public String getBotUsername(){
        return Bot_Username;
    }

    @Override
    public void onUpdateReceived(Update update){

    }

    public void checkRates(){
        try{
            double currentDollarRate = CBRExchangeRateFetcher.getDollarRate();
            double currentEuroRate = CBRExchangeRateFetcher.getEuroRate();
            System.out.println("Текущий курс доллара: " + currentDollarRate);
            System.out.println("Текущий курс евро: " + currentEuroRate);

            checkRate("доллара", currentDollarRate, lastDollarRate);
            checkRate("евро", currentEuroRate, lastEuroRate);

            lastDollarRate = currentDollarRate;
            lastEuroRate = currentEuroRate;
            } catch (IOException e){
            System.out.println("Ошибка при получении курсов: " + e.getMessage());
            e.printStackTrace();;
        }
    }

    public void checkRate(String currency, double currentRate, double lastRate){
        if (lastRate == 0) return; // ропустить проверку при первом запуске

        if (Math.abs(currentRate - lastRate) >= 2){
            String direction = currentRate > lastRate ? "вырос" : "понизился";
            String messageText = String.format("Курс %s %s на 2 рубля: %.2f", currency, direction, currentRate);
            System.out.println("Отправка сообщения: " + messageText);
            sendMessage(messageText);
        }
    }

    private void sendMessage(String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(Chat_Id));
        message.setText(text);
        try{
            System.out.println("Попытка отправки сообщения: " + message);
            execute(message);
            System.out.println("Сообщение отправлено: " + text);
        }catch (TelegramApiException e){
            System.out.println("Ошибка отправки сообщения: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
