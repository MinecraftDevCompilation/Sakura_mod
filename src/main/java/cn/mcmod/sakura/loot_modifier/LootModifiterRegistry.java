package cn.mcmod.sakura.loot_modifier;

import com.mojang.serialization.Codec;

import cn.mcmod.sakura.SakuraMod;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifiterRegistry {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister
            .create(ForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SakuraMod.MODID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SEEDSDROP = GLM.register("grass_drops",
            SeedsDrop.Serializer::new);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> FISHING = GLM.register("fishing_modifiter",
            FishingModifiter.Serializer::new);
}
