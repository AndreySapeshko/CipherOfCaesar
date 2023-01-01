package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary", "CRYPTO-MACHINE \"CAESAR\" / crypto with key");
    }

    @FXML
    private void printInputTextArea() {
        String textFromFile = InputOutputText.inputText(App.getTextField("#file").getText());
        App.getTextArea("#input_text").setText(textFromFile);
    }

    @FXML
    private void encrypt() {
        String text = App.getTextArea("#input_text").getText();
        String key = App.getTextField("#key").getText();
        String encryptedText = CipherOfCaesar.encryptText(text, key);
        App.getTextArea("#output_text").setText(encryptedText);
    }

    @FXML
    private void decrypt() {
        String text = App.getTextArea("#input_text").getText();
        String key = App.getTextField("#key").getText();
        String decryptedText = CipherOfCaesar.decryptText(text, key);
        App.getTextArea("#output_text").setText(decryptedText);
    }
}
