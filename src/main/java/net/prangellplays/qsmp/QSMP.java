package net.prangellplays.qsmp;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.prangellplays.qsmp.callbacks.QSMPCallbacks;
import net.prangellplays.qsmp.registry.QSMPBlocks;
import net.prangellplays.qsmp.registry.QSMPItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class QSMP implements ModInitializer {
	public static final String MOD_ID = "qsmp";
	public static final Logger LOGGER = LoggerFactory.getLogger("qsmp");

	@Override
	public void onInitialize() {

		QSMPBlocks.registerQSMPBlocks();
		QSMPItems.registerQSMPItems();
		QSMPCallbacks.init();

	}
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}