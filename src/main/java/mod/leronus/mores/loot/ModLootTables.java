package mod.leronus.mores.loot;

import mod.leronus.mores.Mores;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class ModLootTables {
    private ModLootTables() {}

    public static final RegistryKey<LootTable> DUCK =
            RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Mores.MOD_ID, "entities/duck"));

    public static final RegistryKey<LootTable> HARDENED_STEEL_GOLEM =
            RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Mores.MOD_ID, "entities/hardened_steel_golem"));
}
