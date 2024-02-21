package novamachina.exnihiloae.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import novamachina.exnihiloae.datagen.client.ExNihiloAEBlockStates;
import novamachina.exnihiloae.datagen.common.ExNihiloAELootTables;
import novamachina.exnihiloae.datagen.common.ExNihiloAERecipes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExNihiloAEDataGenerators {

  private ExNihiloAEDataGenerators() {}

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
	  PackOutput output = generator.getPackOutput();
	  ExistingFileHelper helper = event.getExistingFileHelper();

    if (event.includeServer()) {
      // Recipes
      generator.addProvider(true, new ExNihiloAERecipes(output, helper));
      // LootTable
      generator.addProvider(true, new ExNihiloAELootTables(output));
    }
    if (event.includeClient()) {
      // BlockStates
      generator.addProvider(
          true, new ExNihiloAEBlockStates(output, event.getExistingFileHelper()));
    }
  }
}
