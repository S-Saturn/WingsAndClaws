package net.msrandom.wings.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.wings.WingsAndClaws;
import net.msrandom.wings.entity.item.MimangoEggEntity;
import net.msrandom.wings.entity.item.PlowheadEggEntity;
import net.msrandom.wings.entity.item.SpearProjectileEntity;
import net.msrandom.wings.entity.monster.DumpyEggDrakeEntity;
import net.msrandom.wings.entity.monster.HatchetBeakEntity;
import net.msrandom.wings.entity.monster.IcyPlowheadEntity;
import net.msrandom.wings.entity.passive.*;
import net.msrandom.wings.entity.item.SaddledThunderTailEggEntity;
import net.msrandom.wings.item.WingsItems;

public class WingsEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, WingsAndClaws.MOD_ID);
    //public static final EntityType<DragonEggEntity> DRAGON_EGG = createEgg("dragon_egg", DragonEggEntity::new, () -> WingsEntities.DRAGON_EGG, 0.2f, 0.2f);
    public static final EntityType<DumpyEggDrakeEntity> DUMPY_EGG_DRAKE = create("dumpy_egg_drake", DumpyEggDrakeEntity::new, EntityClassification.CREATURE, 1.2f, 1.3f, 0xddbc8b, 0xbc9161);
    public static final EntityType<HatchetBeakEntity> HATCHET_BEAK = create("hatchet_beak", HatchetBeakEntity::new, EntityClassification.CREATURE, 3.35f, 2.5f, 0x54392a, 0x04a08e);
    public static final EntityType<IcyPlowheadEntity> ICY_PLOWHEAD = create("icy_plowhead", IcyPlowheadEntity::new, EntityClassification.WATER_CREATURE, 1.5f, 1.0f, 0x3B4782, 0x9CA0AD);
    public static final EntityType<PlowheadEggEntity> PLOWHEAD_EGG = create("icy_plowhead_egg", PlowheadEggEntity::new, EntityClassification.MISC, 0.43f, 0.43f);
    public static final EntityType<MimangoEggEntity> MIMANGO_EGG = create("mimango_egg", MimangoEggEntity::new, EntityClassification.MISC, 0.3f, 0.3f);
    public static final EntityType<MimangoEntity> MIMANGO = create("mimango", MimangoEntity::new, EntityClassification.CREATURE, 0.35f, 0.35f, 0xab571e, 0xf2cd51);
    public static final EntityType<SpearProjectileEntity> ST_PROJECTILE_ENTITY = create("spear_projectile_entity", SpearProjectileEntity::new, EntityClassification.MISC, 0.4f, 0.4f);
    public static final EntityType<SugarscaleEntity> SUGARSCALE = create("sugarscale", SugarscaleEntity::new, EntityClassification.WATER_CREATURE, 0.4f, 0.2f, 0x4a4e80, 0x413852);
    public static final EntityType<HaroldsGreendrakeEntity> HAROLDS_GREENDRAKE = create("harolds_greendrake", HaroldsGreendrakeEntity::new, EntityClassification.CREATURE, 0.9f, 1.1f, 0x4b5832, 0xb59a2f);
    //public static final EntityType<SaddledThunderTailEntity> SADDLED_THUNDER_TAIL = create("saddled_thunder_tail", SaddledThunderTailEntity::new, EntityClassification.CREATURE, 4.0f, 3.2f, 0xFE9A2E, 0x8A2908);
    //public static final EntityType<SaddledThunderTailEggEntity> SADDLED_THUNDER_TAIL_EGG = create("saddled_thunder_tail_egg", SaddledThunderTailEggEntity::new, EntityClassification.MISC, 0.5f, 0.75f);

    //public static final EntityType<LeapingGrubShrimpEntity> LEAPING_GRUB_SHRIMP = create("leaping_grub_shrimp", LeapingGrubShrimpEntity::new, EntityClassification.WATER_CREATURE, 0.6f, 0.5f, 0x9eb3ba, 0x647382);
    //public static final EntityType<SongvernEntity> SONGVERN = create("songvern", SongvernEntity::new, EntityClassification.CREATURE, 0.65f, 0.3f, 0xc8602b, 0xc3b0b0);

    private static <T extends CreatureEntity> EntityType<T> create(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height, int pri, int sec) {
        final Item.Properties properties = new Item.Properties().group(WingsItems.GROUP);
        EntityType<T> type = create(name, factory, classification, width, height);
        WingsItems.REGISTRY.register(name + "_spawn_egg", () -> new SpawnEggItem(type, pri, sec, properties));
        return type;
    }

    private static <T extends Entity> EntityType<T> create(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height) {
        EntityType<T> type = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(128).build(name);
        REGISTRY.register(name, () -> type);
        return type;
    }
}
