package novamachina.exnihiloae.common.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;
import novamachina.novacore.core.registries.BlockRegistry;
import novamachina.novacore.world.level.block.BlockBuilder;
import novamachina.novacore.world.level.block.BlockDefinition;

import java.util.List;

public class ExNihiloAEBlocks {
    private static final BlockRegistry BLOCKS = new BlockRegistry(ExNihiloAEConstants.ModIds.EX_NIHILO_AE);
    public static final BlockDefinition<Block> CRUSHED_SKYSTONE =
      BLOCKS.block("Crushed Sky Stone",
          ExNihiloAEConstants.Blocks.CRUSHED_SKYSTONE,
          () -> BlockBuilder.create().strength(0.7F).sound(SoundType.GRAVEL).buildFallingBlock());

    private ExNihiloAEBlocks() {}

	public static List<BlockDefinition<?>> getDefinitions() {
		return BLOCKS.getRegistry();
	}
}
