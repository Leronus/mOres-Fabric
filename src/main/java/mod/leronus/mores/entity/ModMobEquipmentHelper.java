package mod.leronus.mores.entity;

import mod.leronus.mores.Mores;
import mod.leronus.mores.config.CommonConfig;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.structure.Structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class ModMobEquipmentHelper {
    private ModMobEquipmentHelper() {}

    //Armor drop chance (3%)
    public static final float DROP_CHANCE_HAND  = CommonConfig.handDropChance;
    public static final float DROP_CHANCE_ARMOR = CommonConfig.armorDropChance;

    //Zombies
    public static final int ZOMBIE_UPGRADE_MIN = CommonConfig.zombieUpgradeMin;
    public static final int ZOMBIE_UPGRADE_MAX = CommonConfig.zombieUpgradeMax;
    public static final float ZOMBIE_WEAPON_CHANCE = CommonConfig.zombieWeaponChance;
    public static final float ZOMBIE_ARMOR_CHANCE = CommonConfig.zombieArmorChance;

    //Skeletons
    public static final float SKELETON_ARMOR_CHANCE = CommonConfig.skeletonArmorChance;

    //Piglins (10%)
    public static final float PIGLIN_ROSE_GOLD_SWORD_CHANCE = CommonConfig.piglinSwordChance;
    public static final float PIGLIN_ROSE_GOLD_ARMOR_CHANCE = CommonConfig.piglinArmorChance;
    public static final float ZOMBIFIED_PIGLIN_ROSE_GOLD_SWORD_CHANCE = CommonConfig.zombifiedPiglinSwordChance;
    public static final float PIGLIN_BRUTE_ROSE_GOLD_AXE_CHANCE = CommonConfig.piglinBruteAxeChance;

    // Withers
    public static final float WITHER_UPGRADE_CHANCE = CommonConfig.witherUpgradeChance;
    public static final float WITHER_VERY_STRONG_SWORD_CHANCE = CommonConfig.witherVeryStrongSwordChance;
    public static final float WITHER_STRONG_SWORD_CHANCE = CommonConfig.witherStrongSwordChance;
    public static final float WITHER_ARMOR_WITH_UPGRADE_CHANCE = CommonConfig.witherWithArmorUpgradeChance;

    //Vindicator+Vex
    public static final float VINDICATOR_WEAPON_CHANCE = CommonConfig.vindicatorWeaponChance;
    public static final float VEX_WEAPON_CHANCE = CommonConfig.vexWeaponChance;

    /**
     * Exotic roll chances:
     * - NORMAL: extremely rare (0.5% => 1/200)
     * - TRIAL CHAMBER: much more frequent (5.0% => 1/20)
     */
    private static final float EXOTIC_CHANCE_NORMAL = 0.005f; //0.5%
    private static final float EXOTIC_CHANCE_TRIAL  = 0.05f; //5%

    /**
     * Trim roll chances:
     * - NORMAL: rare, but possible
     * - TRIAL CHAMBER: common
     */
    private static final float TRIM_CHANCE_NORMAL = 0.01f; //1%
    private static final float TRIM_CHANCE_TRIAL  = 0.30f; //30%

    private static final RegistryKey<Structure> TRIAL_CHAMBERS_KEY =
            RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of("minecraft", "trial_chambers"));

    private static final String[] VERY_STRONG_SWORDS = {
            "mores:obsidian_sword",
            "mores:hardened_steel_sword"
    };

    private static final String[] PIGLIN_WEAPONS = {
            "mores:rose_gold_sword"
    };
    private static final String[] BRUTE_AXES = {
            "mores:rose_gold_axe",
    };

    private static final String[] ROSE_GOLD_ARMOR = {
            "mores:rose_gold_helmet",
            "mores:rose_gold_chestplate",
            "mores:rose_gold_leggings",
            "mores:rose_gold_boots"
    };

    private static final String[] VINDICATOR_AXES = {
            "mores:bronze_axe",
            "mores:sterling_silver_axe",
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

    /**
     * Exotic materials selection (NO moissanite).
     *
     * Tiers (about +10% relative per step):
     * - topaz / tanzanite / tourmaline : slightly more common (weight 21)
     * - ruby / sapphire / spinel       : next tier (weight 20)
     * - obsidian / adamantium          : rarest tier (weight 19)
     */
    private static String pickExoticMaterial(Random random) {
        final int W_TOP = 21;   // topaz/tanzanite/tourmaline
        final int W_MID = 19;   // ruby/sapphire/spinel
        final int W_LOW = 17;   // obsidian/adamantium (rarest)

        int total = (3 * W_TOP) + (3 * W_MID) + (2 * W_LOW);
        int roll = random.nextInt(total);

        // Top tier (each ~5% more likely than mid tier)
        if ((roll -= W_TOP) < 0) return "topaz";
        if ((roll -= W_TOP) < 0) return "tanzanite";
        if ((roll -= W_TOP) < 0) return "tourmaline";

        // Mid tier (each ~5% more likely than low tier)
        if ((roll -= W_MID) < 0) return "ruby";
        if ((roll -= W_MID) < 0) return "sapphire";
        if ((roll -= W_MID) < 0) return "spinel";

        // Low tier (rarest, equal odds)
        return (random.nextBoolean()) ? "obsidian" : "adamantium";
    }


    /* ===========================
       ENTRY POINTS
       =========================== */

    public static void maybeUpgradeZombieLike(MobEntity mob, Random random) {
        if (!rollOneInRange(random, ZOMBIE_UPGRADE_MIN, ZOMBIE_UPGRADE_MAX)) return;

        boolean doArmor  = random.nextFloat() < ZOMBIE_ARMOR_CHANCE;
        boolean doWeapon = random.nextFloat() < ZOMBIE_WEAPON_CHANCE;
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

    public static void maybeUpgradeSkeletonLike(MobEntity mob, Random random) {
        if (random.nextFloat() >= SKELETON_ARMOR_CHANCE) return;
        equipSkeletonArmorMixed(mob, random);
    }

    public static void maybeUpgradeWitherSkeleton(MobEntity mob, Random random) {
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
            equipZombieArmorMixedLimitedCobalt(mob, random);
        }
    }

    public static void maybeUpgradePiglin(MobEntity mob, Random random) {
        if (random.nextFloat() < PIGLIN_ROSE_GOLD_ARMOR_CHANCE) {
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.HEAD,  ROSE_GOLD_ARMOR[0], 0.25f, random);
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.CHEST, ROSE_GOLD_ARMOR[1], 0.25f, random);
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.LEGS,  ROSE_GOLD_ARMOR[2], 0.25f, random);
            maybeEquipSlotIfEmptyChance(mob, EquipmentSlot.FEET,  ROSE_GOLD_ARMOR[3], 0.25f, random);
            setArmorDropChances(mob);
        }

        ItemStack hand = mob.getEquippedStack(EquipmentSlot.MAINHAND);
        if (!hand.isEmpty() && !hand.isOf(Items.CROSSBOW) && random.nextFloat() < PIGLIN_ROSE_GOLD_SWORD_CHANCE) {
            equipMainhandFromAny(mob, PIGLIN_WEAPONS, random);
        }
    }

    public static void maybeUpgradeZombifiedPiglin(MobEntity mob, Random random) {
        if (random.nextFloat() >= ZOMBIFIED_PIGLIN_ROSE_GOLD_SWORD_CHANCE) return;
        equipMainhandFromAny(mob, PIGLIN_WEAPONS, random);
    }

    public static void maybeUpgradePiglinBrute(MobEntity mob, Random random) {
        ItemStack hand = mob.getEquippedStack(EquipmentSlot.MAINHAND);
        if (!hand.isEmpty() && random.nextFloat() < PIGLIN_BRUTE_ROSE_GOLD_AXE_CHANCE) {
            equipMainhandFromAny(mob, BRUTE_AXES, random);
        }
    }

    public static void maybeUpgradeVindicator(MobEntity mob, Random random) {
        if (random.nextFloat() >= VINDICATOR_WEAPON_CHANCE) return;
        equipMainhandFromAny(mob, VINDICATOR_AXES, random);
    }

    public static void maybeUpgradeVex(MobEntity mob, Random random) {
        if (random.nextFloat() >= VEX_WEAPON_CHANCE) return;
        equipRandomWeaponVariant(mob, "tin", random);
    }

    /**
     * Very rare “exotic” loadout roll.
     * - Outside Trial Chambers: 0.05% (1/2000)
     * - Inside Trial Chambers: 1% (1/100)
     */
    public static void maybeApplyExoticLoadoutIfEligible(MobEntity mob, Random random) {
        float chance = isInTrialChamber(mob) ? EXOTIC_CHANCE_TRIAL : EXOTIC_CHANCE_NORMAL;
        if (random.nextFloat() >= chance) return;

        String mat = pickExoticMaterial(random);

        // Similar feel to vanilla “diamond chance”: sometimes weapon only, sometimes armor only, sometimes both.
        boolean doWeapon = random.nextFloat() < 0.65f;
        boolean doArmor  = random.nextFloat() < 0.55f;
        if (!doWeapon && !doArmor) doWeapon = true;

        if (doWeapon) {
            equipRandomWeaponVariantOverride(mob, mat, random);
        }

        if (doArmor) {
            equipExoticArmorOverride(mob, mat, random);
            setArmorDropChances(mob);
        }
    }

    /**
     * Apply ANY/ALL of your mod's registered trim materials (everything in namespace "mores")
     * to any equipped armor (vanilla OR mOres armor).
     *
     * Does NOT overwrite existing trims.
     */
    public static void maybeApplyMoresTrimsIfEligible(MobEntity mob, Random random) {
        float chance = isInTrialChamber(mob) ? TRIM_CHANCE_TRIAL : TRIM_CHANCE_NORMAL;
        if (random.nextFloat() >= chance) return;

        if (!(mob.getWorld() instanceof ServerWorld sw)) return;
        if (!hasAnyArmorEquipped(mob)) return;

        RegistryEntry<ArmorTrimMaterial> material = pickAnyMoresTrimMaterial(sw, random);
        if (material == null) return;

        RegistryEntry<ArmorTrimPattern> pattern = pickTrimPattern(sw, random, isInTrialChamber(mob));
        if (pattern == null) return;

        ArmorTrim trim = new ArmorTrim(material, pattern);

        applyTrimIfPossible(mob, EquipmentSlot.HEAD, trim);
        applyTrimIfPossible(mob, EquipmentSlot.CHEST, trim);
        applyTrimIfPossible(mob, EquipmentSlot.LEGS, trim);
        applyTrimIfPossible(mob, EquipmentSlot.FEET, trim);
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
        final int COBALT_CAP = 1;

        for (EquipmentSlot slot : slots) {
            if (equipped >= pieces) break;
            if (!mob.getEquippedStack(slot).isEmpty()) continue;

            String mat = pickZombieArmorMaterial(random);
            if ("cobalt".equals(mat) && cobaltPieces >= COBALT_CAP) {
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
       EXOTIC ARMOR/WEAPON (OVERRIDE)
       =========================== */

    private static void equipExoticArmorOverride(MobEntity mob, String material, Random random) {
        // Heavily biased to partial sets (like vanilla diamond spawns)
        int pieces;
        float r = random.nextFloat();
        if (r < 0.70f) pieces = 1;
        else if (r < 0.92f) pieces = 2;
        else if (r < 0.985f) pieces = 3;
        else pieces = 4;

        List<EquipmentSlot> slots = new ArrayList<>(List.of(
                EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
        ));
        Collections.shuffle(slots, new java.util.Random(random.nextLong()));

        int equipped = 0;
        for (EquipmentSlot slot : slots) {
            if (equipped >= pieces) break;

            String id = armorId(material, slot);
            if (equipSlotOverride(mob, slot, id)) {
                equipped++;
            }
        }
    }

    private static void equipRandomWeaponVariantOverride(MobEntity mob, String material, Random random) {
        List<String> candidates = new ArrayList<>(List.of(
                toolId(material, "dagger"),
                toolId(material, "battle_axe"),
                toolId(material, "battle_mace"),
                toolId(material, "sword")
        ));
        Collections.shuffle(candidates, new java.util.Random(random.nextLong()));

        for (String id : candidates) {
            if (equipMainhandOverride(mob, id)) return;
        }
    }

    /* ===========================
       WEAPONS (EXISTING)
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

    /** override armor even if occupied */
    private static boolean equipSlotOverride(MobEntity mob, EquipmentSlot slot, String itemId) {
        if (itemId == null) return false;

        Optional<Item> item = getItem(itemId);
        if (item.isEmpty()) return false;

        mob.equipStack(slot, new ItemStack(item.get()));
        return true;
    }

    /** override mainhand even if occupied */
    private static boolean equipMainhandOverride(MobEntity mob, String itemId) {
        Optional<Item> item = getItem(itemId);
        if (item.isEmpty()) return false;

        mob.equipStack(EquipmentSlot.MAINHAND, new ItemStack(item.get()));
        mob.setEquipmentDropChance(EquipmentSlot.MAINHAND, DROP_CHANCE_HAND);
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

    /* ===========================
       TRIMS
       =========================== */

    private static boolean hasAnyArmorEquipped(MobEntity mob) {
        return isArmorItem(mob.getEquippedStack(EquipmentSlot.HEAD))
                || isArmorItem(mob.getEquippedStack(EquipmentSlot.CHEST))
                || isArmorItem(mob.getEquippedStack(EquipmentSlot.LEGS))
                || isArmorItem(mob.getEquippedStack(EquipmentSlot.FEET));
    }

    private static boolean isArmorItem(ItemStack stack) {
        return !stack.isEmpty() && (stack.getItem() instanceof ArmorItem);
    }

    private static void applyTrimIfPossible(MobEntity mob, EquipmentSlot slot, ArmorTrim trim) {
        ItemStack stack = mob.getEquippedStack(slot);
        if (stack.isEmpty()) return;
        if (!(stack.getItem() instanceof ArmorItem)) return;

        // Don't overwrite existing trim (vanilla trial spawner may already apply one)
        if (stack.contains(DataComponentTypes.TRIM)) return;

        stack.set(DataComponentTypes.TRIM, trim);
        mob.equipStack(slot, stack);
    }

    /**
     * Picks uniformly from all registered trim materials in the mores namespace.
     * (So it automatically includes any/all of your trim materials.)
     */
    private static RegistryEntry<ArmorTrimMaterial> pickAnyMoresTrimMaterial(ServerWorld sw, Random random) {
        Registry<ArmorTrimMaterial> reg = sw.getRegistryManager().get(RegistryKeys.TRIM_MATERIAL);

        List<RegistryKey<ArmorTrimMaterial>> keys = new ArrayList<>();
        for (var entry : reg.getEntrySet()) {
            Identifier id = entry.getKey().getValue();
            if (id != null && Mores.MOD_ID.equals(id.getNamespace())) {
                keys.add(entry.getKey());
            }
        }

        if (keys.isEmpty()) return null;

        RegistryKey<ArmorTrimMaterial> picked = keys.get(random.nextInt(keys.size()));
        return reg.getEntry(picked).orElse(null);
    }

    /**
     * Trial chambers bias toward FLOW/BOLT if present; otherwise pick from a wider pool.
     * Uses registry IDs directly (version-safe).
     */
    private static RegistryEntry<ArmorTrimPattern> pickTrimPattern(ServerWorld sw, Random random, boolean inTrial) {
        Registry<ArmorTrimPattern> reg = sw.getRegistryManager().get(RegistryKeys.TRIM_PATTERN);

        List<Identifier> pool = new ArrayList<>();

        if (inTrial) {
            for (int i = 0; i < 6; i++) pool.add(Identifier.of("minecraft", "flow"));
            for (int i = 0; i < 6; i++) pool.add(Identifier.of("minecraft", "bolt"));
        }

        pool.add(Identifier.of("minecraft", "sentry"));
        pool.add(Identifier.of("minecraft", "dune"));
        pool.add(Identifier.of("minecraft", "coast"));
        pool.add(Identifier.of("minecraft", "wild"));
        pool.add(Identifier.of("minecraft", "ward"));
        pool.add(Identifier.of("minecraft", "vex"));
        pool.add(Identifier.of("minecraft", "eye"));
        pool.add(Identifier.of("minecraft", "tide"));
        pool.add(Identifier.of("minecraft", "snout"));
        pool.add(Identifier.of("minecraft", "rib"));
        pool.add(Identifier.of("minecraft", "spire"));
        pool.add(Identifier.of("minecraft", "wayfinder"));
        pool.add(Identifier.of("minecraft", "shaper"));
        pool.add(Identifier.of("minecraft", "raiser"));
        pool.add(Identifier.of("minecraft", "host"));
        pool.add(Identifier.of("minecraft", "silence"));

        for (int attempts = 0; attempts < 8; attempts++) {
            Identifier id = pool.get(random.nextInt(pool.size()));
            Optional<ArmorTrimPattern> pat = reg.getOrEmpty(id);
            if (pat.isEmpty()) continue;

            RegistryKey<ArmorTrimPattern> key = RegistryKey.of(RegistryKeys.TRIM_PATTERN, id);
            RegistryEntry<ArmorTrimPattern> entry = reg.getEntry(key).orElse(null);
            if (entry != null) return entry;
        }

        return null;
    }

    /* ===========================
       TRIAL CHAMBER DETECTION
       =========================== */

    private static boolean isInTrialChamber(MobEntity mob) {
        if (!(mob.getWorld() instanceof ServerWorld sw)) return false;

        BlockPos pos = mob.getBlockPos();

        Optional<Structure> trialOpt = sw.getRegistryManager()
                .get(RegistryKeys.STRUCTURE)
                .getOrEmpty(Identifier.of("minecraft", "trial_chambers"));

        if (trialOpt.isEmpty()) return false;

        try {
            StructureStart start = sw.getStructureAccessor().getStructureContaining(pos, trialOpt.get());
            return start != null && start.hasChildren();
        } catch (Throwable t) {
            return false;
        }
    }
}
