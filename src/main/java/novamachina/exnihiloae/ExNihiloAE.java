package novamachina.exnihiloae;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import novamachina.exnihiloae.common.init.ExNihiloAEInitialization;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;
import org.slf4j.Logger;

@Mod(ExNihiloAEConstants.ModIds.EX_NIHILO_AE)
public class ExNihiloAE {
  public static final Logger logger = LogUtils.getLogger();

  public ExNihiloAE() {
    logger.debug("Starting Ex Nihilo: Sequentia - AE2 Addon");
    ExNihiloAEInitialization.init(FMLJavaModLoadingContext.get().getModEventBus());
  }
}
