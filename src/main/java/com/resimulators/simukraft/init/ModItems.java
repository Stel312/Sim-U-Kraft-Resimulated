package com.resimulators.simukraft.init;

import com.resimulators.simukraft.SimUTab;
import com.resimulators.simukraft.common.item.ItemBlueprint;
import com.resimulators.simukraft.common.item.ItemGranules;
import com.resimulators.simukraft.common.item.ItemPlanningSheet;
import com.resimulators.simukraft.common.item.ItemStart;
import com.resimulators.simukraft.common.item.base.ItemFoodBase;
import com.resimulators.simukraft.registry.RegistryHandler;
import com.resimulators.simukraft.debug.ItemDebug;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;

/**
 * Created by fabbe on 06/01/2018 - 2:47 AM.
 */
public class ModItems {
	public static final Item GRANULES = new ItemGranules("granules", SimUTab.SUTab);
	public static final Item BURGER = new ItemFoodBase("burger", SimUTab.SUTab, 8, 8, false);
	public static final Item CHEESE = new ItemFoodBase("cheese", SimUTab.SUTab, 4, 4, false);
	public static final Item CHEESEBURGER = new ItemFoodBase("cheeseburger", SimUTab.SUTab, 14, 10, false);
	public static final Item FRIES = new ItemFoodBase("fries", SimUTab.SUTab, 5, 6, false);
	public static final Item BLUEPRINT = new ItemBlueprint("blueprint", SimUTab.SUTab);
	public static final Item PLANNING_SHEET = new ItemPlanningSheet("planning_sheet", SimUTab.SUTab);
	public static final Item VILLAGE_FOUNDER = new ItemStart("village_founder",SimUTab.SUTab);
	public static final Item DEBUG = new ItemDebug("debug", SimUTab.SUTab);

	public static void init() {
		RegistryHandler.registerItem(GRANULES, ItemGranules.TYPES);
		RegistryHandler.registerItem(BURGER);
		RegistryHandler.registerItem(CHEESE);
		RegistryHandler.registerItem(CHEESEBURGER);
		RegistryHandler.registerItem(FRIES);
		RegistryHandler.registerItem(BLUEPRINT);
		RegistryHandler.registerItem(PLANNING_SHEET);
		RegistryHandler.registerItem(VILLAGE_FOUNDER);

		if ((Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment")) {
		    //Register all debug items here, these will only show up in a development environment!
		    RegistryHandler.registerItem(DEBUG);
        }
	}
}
