package com.blakebr0.mysticalagriculture.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.blakebr0.mysticalagriculture.items.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInferiumCrop extends BlockMysticalCrop {
	
	private int tier;
    
    public BlockInferiumCrop(String name, int tier) {
    	super(name);
        this.tier = tier;
    }
    
    @Override
	public Item getCrop() {
    	return ModItems.itemCrafting;
    }
    
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        int age = state.getValue(AGE);
        Random rand = ((World)world).rand;

        int essence = 0;
        int seeds = 1;

        if(age == 7){
        	if(ModConfig.confSeedChance > 0){
        		if(rand.nextInt(100 / ModConfig.confSeedChance) > 0){
        			seeds = 1;
        		} else {
        			seeds = 2;
        		}
        	} else {
        		seeds = 1;
        	}
        }
        
        if(age == 7){
        	if(ModConfig.confEssenceChance > 0){
                if(rand.nextInt(100 / ModConfig.confEssenceChance) > 0){
                	essence = tier;
                } else{
                	essence = tier + 1; 
                }             		
        	} else {
        		essence = tier;
        	}
        }

        drops.add(new ItemStack(this.getSeed(), seeds, 0));
        if(essence > 0) { drops.add(new ItemStack(this.getCrop(), essence, 0)); }
    }
}