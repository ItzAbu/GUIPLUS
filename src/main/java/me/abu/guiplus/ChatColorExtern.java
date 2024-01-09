package me.abu.guiplus;

import org.bukkit.ChatColor;

public final class ChatColorExtern {
    public static String cctrans( String textToTranslate) {
        for( ChatColor color : ChatColor.values() )
            textToTranslate = textToTranslate.replaceAll( "(?i)&" + color.getChar(), "§" + color.getChar() );
        return new String( textToTranslate);
    }

}
