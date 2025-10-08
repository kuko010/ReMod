package net.kuko.remod.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public final class Keybindings {
    public static final Keybindings INSTANCE = new Keybindings();

    private Keybindings() {}

    private static final String CATEGORY = "key.categories.remod";

    public final KeyMapping MenuOpenKey = new KeyMapping(
            "key.remod.open",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            CATEGORY
    );
}
