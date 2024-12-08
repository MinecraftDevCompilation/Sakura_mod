package cn.mcmod.sakura.loot_modifier;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import cn.mcmod.sakura.item.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class SeedsDrop {
	public static class SeedDropModifier extends LootModifier {
		public static final Supplier<MapCodec<SilkTouchTestModifier>> CODEC = Suppliers.memoize(() ->
            		RecordCodecBuilder.mapCodec(inst ->
                		codecStart(inst)
                		.apply(inst, SeedDropModifier::new)
            		)
        	);
		
		protected SeedDropModifier(LootItemCondition[] conditionsIn) {
			super(conditionsIn);
		}

		@Nonnull
		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
			List<Item> seeds = Lists.newArrayList(ItemRegistry.CABBAGE_SEEDS.get(), ItemRegistry.EGGPLANT_SEEDS.get(),
					ItemRegistry.ONION_SEEDS.get(), ItemRegistry.RADISH_SEEDS.get(), ItemRegistry.TOMATO_SEEDS.get(),
					ItemRegistry.RICE_SEEDS.get(), ItemRegistry.RAPESEEDS.get(), ItemRegistry.TARO.get(),
					ItemRegistry.BUCKWHEAT.get(), ItemRegistry.SOYBEAN.get(), ItemRegistry.RED_BEAN.get());
			generatedLoot.add(new ItemStack(seeds.get((int) (Math.random() * seeds.size()))));
			return generatedLoot;
		}

		@Override
        	public MapCodec<? extends IGlobalLootModifier> codec() {
            		return CODEC.get();
        	}
	}



}
