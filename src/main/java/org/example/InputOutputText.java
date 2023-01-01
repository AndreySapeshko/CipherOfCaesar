package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class InputOutputText {
    public static String inputText(String path) {
        String text = "";
        try(FileChannel channel = FileChannel.open(Path.of(path), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            StringBuilder sb = new StringBuilder();
            channel.read(buffer);
            buffer.flip();
            text = new String(buffer.array(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            text = "Неверный путь к файлу или файл не существует. Проверьте путь к файлу!";
        }
        return text;
    }
}
