package novamachina.exnihiloae.datagen.common;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.FluidStack;
import novamachina.exnihiloae.common.init.ExNihiloAEBlocks;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;
import novamachina.exnihilosequentia.data.recipes.CrushingRecipeBuilder;
import novamachina.exnihilosequentia.data.recipes.PrecipitateRecipeBuilder;
import novamachina.exnihilosequentia.data.recipes.RecipeProviderUtilities;
import novamachina.exnihilosequentia.data.recipes.SiftingRecipeBuilder;
import novamachina.exnihilosequentia.world.item.MeshType;
import novamachina.exnihilosequentia.world.item.crafting.MeshWithChance;
import novamachina.exnihilosequentia.world.level.block.EXNBlocks;
import novamachina.novacore.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class ExNihiloAERecipes extends RecipeProvider {

  public ExNihiloAERecipes(PackOutput generator, ExistingFileHelper helper) {
    super(generator, helper, ExNihiloAEConstants.ModIds.EX_NIHILO_AE);
  }

  @Override
  protected void addRecipes(Consumer<FinishedRecipe> consumer) {
    registerSieveRecipes(consumer);
    registerPrecipitateRecipes(consumer);
    registerCrushingRecipes(consumer);
  }

  private void registerCrushingRecipes(Consumer<FinishedRecipe> consumer) {
	  CrushingRecipeBuilder.crushing(AEBlocks.SKY_STONE_BLOCK)
        .addDrop(ExNihiloAEBlocks.CRUSHED_SKYSTONE.block().asItem().getDefaultInstance())
        .build(consumer, crushLoc(ExNihiloAEConstants.Blocks.CRUSHED_SKYSTONE));
  }

  private void registerPrecipitateRecipes(Consumer<FinishedRecipe> consumer) {
    PrecipitateRecipeBuilder.precipitate(new FluidStack(Fluids.LAVA, 1000), AEItems.SKY_DUST, AEBlocks.SKY_STONE_BLOCK)
        .build(consumer, precipLoc("sky_stone"));
  }

  private void registerSieveRecipes(Consumer<FinishedRecipe> consumer) {
    SiftingRecipeBuilder.sifting(Ingredient.of(EXNBlocks.DUST), AEItems.SKY_DUST)
        .addRoll(new MeshWithChance(MeshType.FLINT, 0.1F))
        .addRoll(new MeshWithChance(MeshType.IRON, 0.2F))
        .addRoll(new MeshWithChance(MeshType.DIAMOND, 0.3F))
        .build(consumer, siftingLoc("sky_dust"));

	  SiftingRecipeBuilder.sifting(Ingredient.of(EXNBlocks.DUST), AEItems.CERTUS_QUARTZ_DUST)
        .addRoll(new MeshWithChance(MeshType.IRON, 0.15F))
        .build(consumer, siftingLoc("certus_dust"));

	  SiftingRecipeBuilder.sifting(Ingredient.of(ExNihiloAEBlocks.CRUSHED_SKYSTONE.block()), AEItems.CERTUS_QUARTZ_CRYSTAL)
        .addRoll(new MeshWithChance(MeshType.IRON, 0.7F))
        .addRoll(new MeshWithChance(MeshType.DIAMOND, 0.8F))
        .build(consumer, siftingLoc("certus_quartz"));

	  SiftingRecipeBuilder.sifting(Ingredient.of(ExNihiloAEBlocks.CRUSHED_SKYSTONE.block()), AEItems.CERTUS_QUARTZ_CRYSTAL_CHARGED)
        .addRoll(new MeshWithChance(MeshType.DIAMOND, 0.1F))
        .build(consumer, siftingLoc("charged_certus_quartz"));

	  SiftingRecipeBuilder.sifting(Ingredient.of(EXNBlocks.DUST), AEItems.FLUIX_DUST)
        .addRoll(new MeshWithChance(MeshType.DIAMOND, 0.03F))
        .addRoll(new MeshWithChance(MeshType.EMERALD, 0.06F))
        .build(consumer, siftingLoc("fluix_dust"));
  }

	private ResourceLocation siftingLoc(String id) {
		return new ResourceLocation(ExNihiloAEConstants.ModIds.EX_NIHILO_AE, "sifting/" + RecipeProviderUtilities.prependRecipePrefix(id));
	}
	private ResourceLocation crushLoc(String id) {
		return new ResourceLocation(ExNihiloAEConstants.ModIds.EX_NIHILO_AE, "crushing/" + RecipeProviderUtilities.prependRecipePrefix(id));
	}
	private ResourceLocation precipLoc(String id) {
		return new ResourceLocation(ExNihiloAEConstants.ModIds.EX_NIHILO_AE, "precipitate/" + RecipeProviderUtilities.prependRecipePrefix(id));
	}
}
