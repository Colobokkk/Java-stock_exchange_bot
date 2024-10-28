package ru.colobokkk;
/*import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SimpleTestBot extends TelegramLongPollingBot {
    private static final String BOT_TOKEN = "7397475840:AAEr5nYS8vckbGjsT2bCjYR60i-Mqkuua-g";  // замените на ваш реальный токен
    private static final String BOT_USERNAME = "Colostokkk_Bot";  // замените на ваше реальное имя пользователя
    private static final long CHAT_ID = 1107358655;  // замените на ваш реальный ID чата

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Не используем для теста
    }

    public void sendTestMessage() {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(CHAT_ID));
        message.setText("Это тестовое сообщение!");
        try {
            execute(message);
            System.out.println("Сообщение отправлено: " + message.getText());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleTestBot bot = new SimpleTestBot();
        bot.sendTestMessage();
    }
}*/
