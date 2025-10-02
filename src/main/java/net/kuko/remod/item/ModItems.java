package net.kuko.remod.item;

import net.kuko.remod.ReMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReMod.MOD_ID);



//

    public static void registerItems(IEventBus bus) {
        ITEMS.register(bus);
    }



    // accounts = [[1,2,3],[3,2,1]]
    public int maximumWealth(int[][] accounts) {
        int highestWealth = 0;
        for (int[] account : accounts) {
            for (int bank : account) {
                highestWealth += bank;
            }
        }

        return 0;
    }
}
