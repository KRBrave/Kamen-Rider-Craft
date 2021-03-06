package Kamen_Rider_Craft_4TH.item.saber;


import Kamen_Rider_Craft_4TH.RiderItems;
import Kamen_Rider_Craft_4TH.TokuCraft_core;
import Kamen_Rider_Craft_4TH.blocks.hiden_3d_printing;
import Kamen_Rider_Craft_4TH.blocks.zaia_3d_printing;
import Kamen_Rider_Craft_4TH.blocks.wood.BlockHelheimVine;
import Kamen_Rider_Craft_4TH.util.IHasModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;


public class Item_wonder_ride_book extends Item implements IHasModel
{

	public String num;
	public int num2;

	public String setBase = "thingy";


	public Item_wonder_ride_book(String NUM ,int arms,String name)
	{
		super();
		this.setMaxDamage(0);
		num=NUM;
		num2=arms;
		setTranslationKey(name);
		setRegistryName(name);
		TokuCraft_core.ITEMS.add(this);

	}

	public Item_wonder_ride_book(String name)
	{
		super();
		this.setMaxDamage(0);
		setTranslationKey(name);
		setRegistryName(name);
		TokuCraft_core.ITEMS.add(this);
		num="thingy";
		num2=10;

	}

	@Override
	public void registerModels() {
		TokuCraft_core.proxy.registerItemRender(this,0,"inventory");
	}



	public Item_wonder_ride_book resetBook(String rider)
	{
		setBase=rider;
		return this;
	}
	/**
	 * Called when the equipped item is right clicked.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{

		if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET)!= null){

			if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof item_saberdriver){
				item_saberdriver belt = (item_saberdriver) playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem();
				if (num!="thingy") {
					if (setBase==belt.Rider) {
						item_saberdriver.set_core(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET),belt.BOOK_L, "l");
						item_saberdriver.set_core(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET),belt.BOOK_M, "m");
						item_saberdriver.set_core(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET),belt.BOOK_R, "r");
					}
					else if (belt.Rider=="saber"||belt.Rider=="blaze"){

						item_saberdriver.set_core(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET),num2, num);
					}
				}
			}
		}
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
}