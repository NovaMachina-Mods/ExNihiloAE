package novamachina.exnihiloae.datagen.common;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import novamachina.exnihiloae.common.init.ExNihiloAEBlocks;
import novamachina.novacore.data.loot.LootProvider;
import novamachina.novacore.data.loot.table.BlockLootTables;

import java.util.List;

public class ExNihiloAELootTables extends LootProvider {

  public ExNihiloAELootTables(PackOutput generator) {
    super(generator, List.of(new LootTableProvider.SubProviderEntry(EXNAELootTable::new, LootContextParamSets.BLOCK)));
  }

  public static class EXNAELootTable extends BlockLootTables {
	  @Override
	  protected void generate() {
		  this.add(this::createSingleItemTable, ExNihiloAEBlocks.CRUSHED_SKYSTONE);

	  }
  }
}
