package com.mcmoddev.mmdbench;

import com.mcmoddev.mmdbench.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = Constants.MOD_ID,
    name = Constants.MOD_NAME,
    version = Constants.MOD_VERSION,
    dependencies = "required-after:forge@[" + Constants.FORGE_VERSION + ",);",
    acceptedMinecraftVersions = "[" + Constants.MIN_MC_VERSION + ",)")
@SuppressWarnings({"WeakerAccess", "unused"})
public class MMDBench {
    private static final String PROXY_BASE = "com.mcmoddev.mmdbench.proxy.";

    @SidedProxy(clientSide = PROXY_BASE + "ClientProxy", serverSide = PROXY_BASE + "ServerProxy")
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getFormatterLogger(Constants.MOD_ID);

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MMDBench.proxy.construct(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MMDBench.proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MMDBench.proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MMDBench.proxy.postInit(event);
    }
}
