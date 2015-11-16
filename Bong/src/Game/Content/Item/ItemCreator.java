package Game.Content.Item;

public class ItemCreator
{
    public static final int ITEM_TIPE = 1;

    public static Item create(int itemId)
    {
        Item item = null;
        switch (itemId) {
        case 0:
            item = new Item();
            break;
        case 1:
            item = new Item();
        case 2:
            item = new Item();
        default:
            item = null;
        }
        return item;
    }
}
