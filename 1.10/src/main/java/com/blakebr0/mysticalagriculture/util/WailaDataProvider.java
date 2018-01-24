package com.blakebr0.mysticalagriculture.util;

import net.minecraft.block.BlockCrops;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import com.blakebr0.mysticalagriculture.blocks.BlockSeedReprocessor;
import com.blakebr0.mysticalagriculture.blocks.BlockTinkeringTable;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockInferiumCrop;
import com.blakebr0.mysticalagriculture.tileentity.TileEntitySeedReprocessor;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;

public class WailaDataProvider implements IWailaDataProvider {

	public static void callbackRegister(IWailaRegistrar registrar) {
		registrar.registerStackProvider(new WailaDataProvider(), BlockMysticalCrop.class);
		registrar.registerStackProvider(new WailaDataProvider(), BlockInferiumCrop.class);
		registrar.registerStackProvider(new WailaDataProvider(), BlockTinkeringTable.class);
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP arg0, TileEntity arg1, NBTTagCompound arg2, World arg3, BlockPos arg4) {
		return null;
	}

	@Override
	public List<String> getWailaBody(ItemStack arg0, List<String> arg1, IWailaDataAccessor arg2, IWailaConfigHandler arg3) {
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack arg0, List<String> arg1, IWailaDataAccessor arg2, IWailaConfigHandler arg3) {
		return null;
	}

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor arg0, IWailaConfigHandler arg1) {
		if(arg0.getBlockState().getBlock() instanceof BlockTinkeringTable){
			return new ItemStack(arg0.getBlockState().getBlock(), 1, arg0.getMetadata());
		}
		return new ItemStack(arg0.getBlockState().getBlock(), 1, 0);
	}

	@Override
	public List<String> getWailaTail(ItemStack arg0, List<String> arg1, IWailaDataAccessor arg2, IWailaConfigHandler arg3) {
		return null;
	}
}
