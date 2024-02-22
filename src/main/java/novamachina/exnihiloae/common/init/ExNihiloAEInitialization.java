package novamachina.exnihiloae.common.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegisterEvent;
import novamachina.exnihiloae.ExNihiloAE;
import novamachina.novacore.bootstrap.ForgeBlockRegistry;
import novamachina.novacore.core.IRegistry;
import novamachina.novacore.world.level.block.BlockDefinition;

public class ExNihiloAEInitialization {

    private ExNihiloAEInitialization() {}

    public static void init(IEventBus modEventBus) {
    ExNihiloAE.logger.debug("Initializing modded items");
      modEventBus.addListener((RegisterEvent event) -> {
          if (event.getRegistryKey().equals(BuiltInRegistries.BLOCK.key())) {
              initBlocks(new ForgeBlockRegistry());
          }
      });
    }

    public static void initBlocks(IRegistry<BlockDefinition<?>> registry) {
        for (BlockDefinition<?> blockDefinition : ExNihiloAEBlocks.getDefinitions()) {
            registry.register(blockDefinition);
        }
    }
}
