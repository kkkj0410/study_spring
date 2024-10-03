@ModelAttribute("itemTypes")
public ItemType[] ItemTypes(){
    //ItemType.values() : 모든 enum값을 반환
    ItemType[] values = ItemType.values();

    return values;
}
