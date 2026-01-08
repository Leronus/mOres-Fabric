package mod.leronus.mores.loot;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

/**
 * Injects our custom music discs into vanilla chest loot tables
 * without overriding the vanilla JSON files (the best compatibility).
 */
public final class ModChestLootInjector {

    // Vanilla chest loot table IDs
    private static final Identifier MINESHAFT = Identifier.of("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier DUNGEON   = Identifier.of("minecraft", "chests/simple_dungeon");
    private static final Identifier END_CITY  = Identifier.of("minecraft", "chests/end_city_treasure");

    // Tweak these to taste:
    // "good chance" = higher than rare items, but not guaranteed.
    private static final float CIPHER_MINESHAFT_CHANCE = 0.25f; // 25%
    private static final float CIPHER_DUNGEON_CHANCE   = 0.35f; // 35%
    private static final float SWEET_END_CITY_CHANCE   = 0.20f; // 20%

    private ModChestLootInjector() {}

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            // Only touch built-in vanilla tables (avoids fighting datapacks)
            if (!source.isBuiltin()) return;

            Identifier id = key.getValue();

            if (MINESHAFT.equals(id)) {
                tableBuilder.pool(singleItemChancePool(ModItems.CIPHER_MUSIC_DISC, CIPHER_MINESHAFT_CHANCE));
            } else if (DUNGEON.equals(id)) {
                tableBuilder.pool(singleItemChancePool(ModItems.CIPHER_MUSIC_DISC, CIPHER_DUNGEON_CHANCE));
            } else if (END_CITY.equals(id)) {
                tableBuilder.pool(singleItemChancePool(ModItems.SWEET_CAROLINE_MUSIC_DISC, SWEET_END_CITY_CHANCE));
            }
        });
    }

    /**
     * Creates a loot pool that rolls once and only yields the item with the given probability.
     */
    private static LootPool.Builder singleItemChancePool(net.minecraft.item.Item item, float chance) {
        return LootPool.builder()
                .rolls(net.minecraft.loot.provider.number.ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(item));
    }
}
