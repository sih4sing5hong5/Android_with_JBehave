package com.example.android_with_jbehave;

public class StringRenderer {
    Game game;

    public String asString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < game.map.length; i++) {
            if (i != 0)
                stringBuilder.append("\n");
            for (int j = 0; j < game.map[i].length; j++)
                if (game.map[i][j])
                    stringBuilder.append("X");
                else
                    stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }
}
