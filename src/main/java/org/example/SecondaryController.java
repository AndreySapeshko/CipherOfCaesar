package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary", "CRYPTO-MACHINE \"CAESAR\" / decrypt without key");
    }

    @FXML
    private void printInputTextArea() {
        String textFromFile = InputOutputText.inputText(App.getTextField("#file").getText());
        App.getTextArea("#input_text").setText(textFromFile);
    }

    @FXML
    private void decrypt() {
        String text = App.getTextArea("#input_text").getText();
        String decryptedText = CipherOfCaesar.decryptWithoutKey(text);
        App.getTextArea("#output_text").setText(decryptedText);
    }

    @FXML
    private void finished() {
        CipherOfCaesar.decryptTextFinished();
    }
}