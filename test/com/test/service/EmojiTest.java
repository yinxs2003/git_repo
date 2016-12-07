package com.test.service;

import com.vdurmont.emoji.EmojiParser;

public class EmojiTest {
    public static void main(String[] args){
        String emojiStr = "An \uD83D\uDE30awesome 😃string with a few 😉emojis!";

        String convertedString = EmojiParser.parseToHtmlDecimal(emojiStr);

        System.out.println(convertedString);
    }
}
