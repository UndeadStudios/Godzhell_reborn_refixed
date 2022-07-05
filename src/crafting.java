public class crafting {

client c;
	public boolean theGems(int gemID)
	{
		int gems[] = { 1623, 1621, 1619, 1617, 1631, 6571, 1627, 1625, 1629 };

		for(int g = 0; g < gems.length; g++) 
		{
		
			if(gems[g] == gemID) 
			{
				return true;
			}
		}

		return false;
	}

	public void isBeingUsedWith(client c, int itemUsed, int useWith)
	{
		int item = -1;
	
        	if (itemUsed == 1755) 
		{
           		item = useWith;
        	}
        	if (useWith == 1755) 
		{
           		item = itemUsed;
        	}

		switch(item)
		{
		case 1623: // saphire
		startCrafting(c, item, 20);
        	break;

        	case 1621: // ruby
		startCrafting(c, item, 27);
        	break;

       		case 1619: // emrald
		startCrafting(c, item, 34);
        	break;

		case 1617: // diamond
		startCrafting(c, item, 43);
        	break;

        	case 1631: // dragon stone
		startCrafting(c, item, 55);
        	break;

       		case 6571: // onyx
     		startCrafting(c, item, 67);
        	break;

		case 1627: // jade
		startCrafting(c, item, 13);
		break;

		case 1629: // red topaz
		startCrafting(c, item, 16);
		break;

		case 1625: // opal
		startCrafting(c, item, 1);
		break;

		}
	}


	public void startCrafting(client c, int item, int levelNeeded)
	{
		if (c.playerLevel[12] >= levelNeeded) 
		{	
			getExp(c, item);
			doTheAnimation(c, item);
			addAndDeleteTheItem(c, item);
		} 
		
		else if (c.playerLevel[12] < levelNeeded) 
		{
                    c.sendMessage("You need atleast "+levelNeeded+" Crafting to make this.");
                }
	}

	public void addAndDeleteTheItem(client c, int item)
	{
		int addedItemID = -1;

		switch(item)
		{
			case 1623: // saphire
			addedItemID = 1607;
			break;	

			case 1621: // emrald
			addedItemID = 1605;
			break;	

			case 1619: // ruby
			addedItemID = 1603;
			break;	

			case 1617: // diamond
			addedItemID = 1601;
			break;

			case 1631: // dragon stone
			addedItemID = 1615;
			break;

			case 6571: // onyx
			addedItemID = 6573;
			break;

			case 1627: // jade
			addedItemID = 1611;
			break;

			case 1629:
			addedItemID = 1613; // red topaz
			break;

			case 1625: // opal
			addedItemID = 1609;
			break;
		}
			c.addItem(addedItemID, 1);
			c.deleteItem(item, c.getItemSlot(item), 1);
               		c.sendMessage("You use the chisle on a "+c.getItemName(item)+" and get a "+c.getItemName(addedItemID)+".");
	}

	public void getExp(client c, int item)
	{
		double exp = 0;

		switch(item)
		{
			case 1623: // saphire
			exp = 50;
			break;	

			case 1621: // emrald
			exp = 67.5;
			break;	

			case 1619: // ruby
			exp = 85;
			break;	

			case 1617: // diamond
			exp = 107.5;
			break;

			case 1631: // dragon stone
			exp = 137.5;
			break;

			case 6571: // onyx
			exp = 167.5;
			break;

			case 1627: // jade
			exp = 5;
			break;

			case 1629:
			exp = 6.3; // red topaz
			break;

			case 1625: // opal
			exp = 3.8;
			break;
		}
		
		c.addSkillXP(exp, 12);
	}



	public void doTheAnimation(client c, int item) 
	{
		int animationID = -1;
		
		switch(item)
		{
			case 1623: // saphire
			animationID = 888;
			break;	

			case 1621: // emrald
			animationID = 889;
			break;	

			case 1619: // ruby
			animationID = 887;
			break;	

			case 1617: // diamond
			animationID = 890;
			break;

			case 1631: // dragon stone
			animationID = 885;
			break;

			case 6571: // onyx
			animationID = 888;
			break;

			case 1627: // jade
			animationID = 891;
			break;

			case 1629:
			animationID = 892; // red topaz
			break;

			case 1625: // opal
			animationID = 886;
			break;
		}

		c.setAnimation(animationID);
	}
	

}