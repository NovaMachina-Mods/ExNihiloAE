package novamachina.exnihiloae.datagen.common;

import net.minecraft.data.DataGenerator;
import novamachina.exnihiloae.common.init.ExNihiloAEBlocks;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants.ModIds;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractLangGenerator;

public class ExNihiloAELangGenerator extends AbstractLangGenerator {

    public ExNihiloAELangGenerator(DataGenerator gen, String locale) {
        super(gen, ModIds.EX_NIHILO_AE, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        addBlocks();
    }

    private void addBlocks() {
        add("block.exnihiloae." + ExNihiloAEConstants.Blocks.CRUSHED_SKYSTONE, "Crushed Sky Stone");
    }
}