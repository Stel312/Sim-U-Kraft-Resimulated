package com.resimulators.simukraft.common.block;

import com.resimulators.simukraft.GuiHandler;
import com.resimulators.simukraft.SimUKraft;
import com.resimulators.simukraft.common.block.base.BlockBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Astavie on 25/01/2018 - 5:22 PM.
 */
public class BlockMineBox extends BlockBase {
	public BlockMineBox(String name, CreativeTabs tab, Material blockMaterialIn, MapColor blockMapColorIn) {
		super(name, tab, blockMaterialIn, blockMapColorIn);
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		//TODO: implement logic
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		//TODO: implement logic
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			return true;
		} else {
			playerIn.openGui(SimUKraft.instance, GuiHandler.GUI_MINER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
	}
}
