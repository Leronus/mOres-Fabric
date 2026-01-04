package mod.leronus.mores.entity;

import mod.leronus.mores.Mores;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class ModMobEquipmentHelper {
    private ModMobEquipmentHelper() {}

    public static final float DROP_CHANCE_HAND  = 0.02f;
    public static final float DROP_CHANCE_ARMOR = 0.02f;

    public static final float SKELETON_ARMOR_CHANCE = 0.22f;

    // Withers
    public static final float WITHER_UPGRADE_CHANCE = 0.20f;
    public static final float WITHER_VERY_STRONG_SWORD_CHANCE = 0.06f;
    public static final float WITHER_STRONG_SWORD_CHANCE = 0.18f;
    public static final float WITHER_ARMOR_WITH_UPGRADE_CHANCE = 0.12f;

    // Zombified piglin: explicit 5%
    public static final float ZOMBIFIED_PIGLIN_ROSE_GOLD_SWORD_CHANCE = 0.10f;

    private static final String[] VERY_STRONG_SWORDS = {
            "mores:obsidian_sword",
            "mores:hardened_steel_sword"
    };

    private static final String[] PIGLIN_WEAPONS = {
            "mores:rose_gold_sword"
    };

    private static final String[] ROSE_GOLD_ARMOR = {
            "mores:rose_gold_helmet",
            "mores:rose_gold_chestplate",
            "mores:rose_gold_leggings",
            "mores:rose_gold_boots"
    };

    private static final String[] VINDICATOR_AXES = {
            "mores:bronze_axe",
            "mores:carbon_steel_axe",
            "mores:cobalt_axe"
    };

    /* ===========================
       RANDOM HELPERS
       =========================== */

    private static boolean rollOneInRange(Random random, int min, int max) {
        int denom = min + random.nextInt(max - min + 1);
        return random.nextInt(denom) == 0;
    }

    /* ===========================
       MATERIAL POOLS
       =========================== */

    // Zombie ARMOR pool: reduced cobalt + no hardened on armor
    // sum 100: tin 24, copper 20, silver 15, sterling 10, bronze 15, carbon 12, rose_gold 4, cobalt 0? -> we want SOME cobalt:
    // Let's do cobalt 3, rose_gold 1 = still possible but rare:
    // tin 24, copper 20, silver 15, sterling 10, bronze 15, carbon 12, cobalt 3, rose_gold 1 = 100
    private static String pickZombieArmorMaterial(Random random) {
        int r = random.nextInt(100);
        if (r < 24) return "tin";
        if (r < 44) return "copper";
        if (r < 59) return "silver";
        if (r < 69) return "sterling_silver";
        if (r < 84) return "bronze";
        if (r < 96) return "carbon_steel";
        if (r < 99) return "cobalt";       // 3%
        return "rose_gold";                 // 1%
    }

    // Zombie WEAPON material pool (you wanted rose_gold ~5%, hardened very rare, cobalt noticeable)
    // tin 22, copper 18, silver 14, sterling 8, bronze 14, carbon 10, cobalt 8, rose_gold 5, hardened 1
    private static String pickZombieWeaponMaterial(Random random) {
        int r = random.nextInt(100);
        if (r < 22) return "tin";
        if (r < 40) return "copper";
        if (r < 54) return "silver";
        if (r < 62) return "sterling_silver";
        if (r < 76) return "bronze";
        if (r < 86) return "carbon_steel";
        if (r < 94) return "cobalt";
        if (r < 99) return "rose_gold";
        return "hardened_steel";
    }

    private static String pickSkeletonArmorMaterial(Random random) {
        int r = random.nextInt(100);
        if (r < 20) return "tin";
        if (r < 40) return "copper";
        if (r < 55) return "silver";
        if (r < 65) return "sterling_silver";
        if (r < 80) return "bronze";
        if (r < 90) return "carbon_steel";
        if (r < 98) return "cobalt";
        return "rose_gold";
    }

    /* ===========================
       ENTRY POINTS
       =========================== */

    public static void maybeUpgradeZombieLike(MobEntity mob, Random random, LocalDifficulty difficulty) {
        // random 1/(4..7)
        if (!rollOneInRange(random, 4, 7)) return;

        boolean doArmor  = random.nextFloat() < 0.75f;
        boolean doWeapon = random.nextFloat() < 0.70f;
        if (!doArmor && !doWeapon) doWeapon = true;

        if (doArmor) {
            equipZombieArmorMixedLimitedCobalt(mob, random);
        }

        if (doWeapon) {
            if (!mob.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty() || random.nextFloat() < 0.60f) {
                equipRandomWeaponVariant(mob, pickZombieWeaponMaterial(random), random);
            }
        }
    }

    public static void maybeUpgradeSkeletonLike(MobEntity mob, Random random, LocalDifficulty difficulty) {
        if (random.nextFloat() >= SKELETON_ARMOR_CHANCE) return;
        equipSkeletonArmorMixed(mob, random);
    }

    public static void maybeUpgradeWitherSkeleton(MobEntity mob, Random random, LocalDifficulty difficulty) {
        if (random.nextFloat() >= WITHER_UPGRADE_CHANCE) return;

        float roll = random.nextFloat();
        if (roll < WITHER_VERY_STRONG_SWORD_CHANCE) {
            if (!equipMainhandFromAny(mob, VERY_STRONG_SWORDS, random)) {
                equipRandomWeaponVariant(mob, "cobalt", random);
            }
        } else if (roll < WITHER_VERY_STRONG_SWORD_CHANCE + WITHER_STRONG_SWORD_CHANCE) {
            equipRandomWeaponVariant(mob, "cobalt", random);
        } else {
            equipRandomWeaponVariant(mob, "carbon_steel", random);
        }

        if (random.nextFloat() < WITHER_ARMOR_WITH_UPGRADE_CHANCE) {
            // Withers can remain mixed but harder-leaning:
            equipZombieArmorMixedLimitedCobalt(mob, random);
        }
    }

    public static void maybeUpgradePiglin(MobEntity mob, Random random, LocalDifficulty difficulty) {
        // Armor: visible chance, rose_gold only (your design)
        if (random.nextFloat() < 0.30f) {
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.HEAD,  ROSE_GOLD_ARMOR[0], 0.25f, random);
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.CHEST, ROSE_GOLD_ARMOR[1], 0.25f, random);
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.LEGS,  ROSE_GOLD_ARMOR[2], 0.25f, random);
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.FEET,  ROSE_GOLD_ARMOR[3], 0.25f, random);
            setArmorDropChances(mob);
        }

        // Weapon: only sword piglins (not crossbow)
        ItemStack hand = mob.getEquippedStack(EquipmentSlot.MAINHAND);
        if (!hand.isEmpty() && !hand.isOf(Items.CROSSBOW) && random.nextFloat() < 0.35f) {
            equipMainhandFromAny(mob, PIGLIN_WEAPONS, random);
        }
    }

    public static void maybeUpgradeZombifiedPiglin(MobEntity mob, Random random) {
        // Explicit 5%
        if (random.nextFloat() >= ZOMBIFIED_PIGLIN_ROSE_GOLD_SWORD_CHANCE) return;

        boolean equipped = equipMainhandFromAny(mob, PIGLIN_WEAPONS, random);

        // Debug: if roll passed but item didn't equip, log it (helps catch registry/id issues)
        if (!equipped) {
            Mores.LOGGER.warn("Rolled rose_gold for Zombified Piglin but failed to equip. Check item id: {}", PIGLIN_WEAPONS[0]);
        } else {
            // Optional: uncomment to confirm it's happening
             Mores.LOGGER.info("Equipped rose_gold_sword on Zombified Piglin {}", mob.getUuidAsString());
        }
    }


    public static void maybeUpgradeVindicator(MobEntity mob, Random random, LocalDifficulty difficulty) {
        if (random.nextFloat() >= 0.18f) return;
        equipMainhandFromAny(mob, VINDICATOR_AXES, random);
    }

    public static void maybeUpgradeVex(MobEntity mob, Random random) {
        if (random.nextFloat() >= 0.18f) return;
        equipRandomWeaponVariant(mob, "tin", random);
    }

    /* ===========================
       MIXED ARMOR (WITH LIMITS)
       =========================== */

    private static void equipZombieArmorMixedLimitedCobalt(MobEntity mob, Random random) {
        int pieces;
        float r = random.nextFloat();
        if (r < 0.55f) pieces = 1;
        else if (r < 0.82f) pieces = 2;
        else if (r < 0.96f) pieces = 3;
        else pieces = 4;

        List<EquipmentSlot> slots = new ArrayList<>(List.of(
                EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
        ));
        Collections.shuffle(slots, new java.util.Random(random.nextLong()));

        int equipped = 0;
        int cobaltPieces = 0;
        final int COBALT_CAP = 1; // <-- change to 2 if you ever want slightly more cobalt

        for (EquipmentSlot slot : slots) {
            if (equipped >= pieces) break;
            if (!mob.getEquippedStack(slot).isEmpty()) continue;

            String mat = pickZombieArmorMaterial(random);
            if ("cobalt".equals(mat) && cobaltPieces >= COBALT_CAP) {
                // reroll once to avoid cobalt spam
                mat = pickZombieArmorMaterial(random);
                if ("cobalt".equals(mat)) mat = "carbon_steel";
            }

            if (equipSlotIfEmpty(mob, slot, armorId(mat, slot))) {
                equipped++;
                if ("cobalt".equals(mat)) cobaltPieces++;
            }
        }

        if (equipped > 0) setArmorDropChances(mob);
    }

    private static void equipSkeletonArmorMixed(MobEntity mob, Random random) {
        int pieces;
        float r = random.nextFloat();
        if (r < 0.60f) pieces = 1;
        else if (r < 0.86f) pieces = 2;
        else if (r < 0.97f) pieces = 3;
        else pieces = 4;

        List<EquipmentSlot> slots = new ArrayList<>(List.of(
                EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
        ));
        Collections.shuffle(slots, new java.util.Random(random.nextLong()));

        int equipped = 0;
        for (EquipmentSlot slot : slots) {
            if (equipped >= pieces) break;
            if (!mob.getEquippedStack(slot).isEmpty()) continue;

            String mat = pickSkeletonArmorMaterial(random);
            if (equipSlotIfEmpty(mob, slot, armorId(mat, slot))) equipped++;
        }

        if (equipped > 0) setArmorDropChances(mob);
    }

    /* ===========================
       WEAPONS
       =========================== */

    private static void equipRandomWeaponVariant(MobEntity mob, String material, Random random) {
        List<String> candidates = new ArrayList<>(List.of(
                toolId(material, "dagger"),
                toolId(material, "battle_axe"),
                toolId(material, "battle_mace"),
                toolId(material, "sword")
        ));
        Collections.shuffle(candidates, new java.util.Random(random.nextLong()));

        for (String id : candidates) {
            if (equipMainhandFromAny(mob, new String[]{id}, random)) return;
        }
    }

    /* ===========================
       ID BUILDERS
       =========================== */

    private static String armorId(String material, EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> "mores:" + material + "_helmet";
            case CHEST -> "mores:" + material + "_chestplate";
            case LEGS -> "mores:" + material + "_leggings";
            case FEET -> "mores:" + material + "_boots";
            default -> null;
        };
    }

    private static String toolId(String material, String type) {
        return "mores:" + material + "_" + type;
    }

    /* ===========================
       EQUIP HELPERS
       =========================== */

    private static void setArmorDropChances(MobEntity mob) {
        mob.setEquipmentDropChance(EquipmentSlot.HEAD,  DROP_CHANCE_ARMOR);
        mob.setEquipmentDropChance(EquipmentSlot.CHEST, DROP_CHANCE_ARMOR);
        mob.setEquipmentDropChance(EquipmentSlot.LEGS,  DROP_CHANCE_ARMOR);
        mob.setEquipmentDropChance(EquipmentSlot.FEET,  DROP_CHANCE_ARMOR);
    }

    private static void maybeEquipSlotIfEmptyChance(MobEntity mob, EquipmentSlot slot, String itemId, float chance, Random random) {
        if (random.nextFloat() >= chance) return;
        equipSlotIfEmpty(mob, slot, itemId);
    }

    private static boolean equipMainhandFromAny(MobEntity mob, String[] candidates, Random random) {
        if (candidates.length == 0) return false;

        String id = candidates[random.nextInt(candidates.length)];
        Optional<Item> item = getItem(id);
        if (item.isEmpty()) return false;

        mob.equipStack(EquipmentSlot.MAINHAND, new ItemStack(item.get()));
        mob.setEquipmentDropChance(EquipmentSlot.MAINHAND, DROP_CHANCE_HAND);
        return true;
    }

    private static boolean equipSlotIfEmpty(MobEntity mob, EquipmentSlot slot, String itemId) {
        if (itemId == null) return false;
        if (!mob.getEquippedStack(slot).isEmpty()) return false;

        Optional<Item> item = getItem(itemId);
        if (item.isEmpty()) return false;

        mob.equipStack(slot, new ItemStack(item.get()));
        return true;
    }

    private static Optional<Item> getItem(String id) {
        try {
            return Registries.ITEM.getOrEmpty(Identifier.of(id));
        } catch (Exception e) {
            Mores.LOGGER.warn("Bad item id in mob equipment config: {}", id);
            return Optional.empty();
        }
    }
}
