package com.syf097.chemine.item;

import com.syf097.chemine.chemine;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IElectricItemManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class QuantumSaber extends ItemSword implements IElectricItem {
private boolean active = false;
	public QuantumSaber() {
		super(Item.ToolMaterial.DIAMOND);
	    this.setUnlocalizedName("quantumsaber");
	    this.active= false;
	    this.addPropertyOverride(new ResourceLocation("quantumsaber_active"), new IItemPropertyGetter()
        {

			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
				 return ((QuantumSaber) stack.getItem()).getActivity() ? 1.0F :0.0F ;
			}
	    	
        });
	}

	 public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	    {
		if (((QuantumSaber) stack.getItem()).getActivity()) {
			ElectricItem.manager.use(stack, 150000f, attacker);
			if (attacker instanceof EntityPlayer) {
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 40f);
			}else {
				target.attackEntityFrom(DamageSource.causeMobDamage( attacker), 40f);
			}
			target.setHealth(target.getHealth()-6);
		}
	        return true;
	    }
	 
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
        	ItemStack item = new ItemStack(this,1);
        	ElectricItem.manager.charge(item, 30000000f, 4, true, false);
        	items.add(item);

        }
    }
	public boolean preInit() {
		this.setRegistryName("quantumsaber");
		 ForgeRegistries.ITEMS.register(this);
		return true;
	}
	 public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
	    {
	        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
	        {
	       	 ElectricItem.manager.use(stack, 300000f, entityLiving);
	        }

	        return true;
	    }
	@Override
	public boolean canProvideEnergy(ItemStack stack) {
		return false;
	}



	@Override
	public double getMaxCharge(ItemStack stack) {
		return 30000000f;
	}



	@Override
	public int getTier(ItemStack stack) {
		return 4;
	}

	@Override
	public double getTransferLimit(ItemStack stack) {
	
		return  300000f;
	}

    public  boolean getActivity() {
    	return this.active;
    }
   
    public void setActivity(boolean act) {
    	this.active=act;
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
	if(worldIn.isRemote) {
    	if (((QuantumSaber) playerIn.getHeldItem(handIn).getItem()).getActivity()) {
        	((QuantumSaber) playerIn.getHeldItem(handIn).getItem()).setActivity(false); 
       
        }else {
        	((QuantumSaber) playerIn.getHeldItem(handIn).getItem()).setActivity(true);
        	
        }
	}
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
