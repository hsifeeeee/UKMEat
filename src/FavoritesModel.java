import java.util.ArrayList;

public class FavoritesModel {

	private ArrayList<ProductModel> favouriteList = new ArrayList<ProductModel>();
	private ProductCatalogue pc = new ProductCatalogue();
	
	public boolean addToFavourite(String itemName) {
		ProductModel menu[] = pc.getFullMenu();
		
		for (int i=0; i<menu.length; i++)
			if (menu[i].getName().equals(itemName)) {
				boolean alreadyInList = false;
				for (ProductModel pd: favouriteList) {  // Add the product into List if it is not already in the list
					if (pd.getName().equals(itemName))
						alreadyInList = true;	
				}
				
				if (alreadyInList) {
					return false;
				} else
					favouriteList.add(menu[i]);
			}
		
		return true;
	}
	
	public boolean removeFromFavourite(String itemName) {
		ProductModel menu[] = pc.getFullMenu();
		
		for (int i=0; i<menu.length; i++)
			if (menu[i].getName().equals(itemName)) {
				boolean alreadyInList = false;
				for (ProductModel pd: favouriteList) {  // Add the product into List if it is not already in the list
					if (pd.getName().equals(itemName))
						alreadyInList = true;	
				}
				
				if (alreadyInList) {
					favouriteList.remove(menu[i]);
					
				} else
					return false;
			}
		return true;
	}
	
	public String[] getFavouriteList() {
		String arr[] = new String[favouriteList.size()];
		int i=0;
		for (ProductModel pd: favouriteList) {
			arr[i] = (pd.getName());   
			i++;
		}
		return arr;
	}
	
	public boolean getIsInFavorite(String itemName) {
		ProductModel menu[] = pc.getFullMenu();
	
		for (int i=0; i<menu.length; i++)
			if (menu[i].getName().equals(itemName)) {
				for (ProductModel pd: favouriteList) {  // Add the product into List if it is not already in the list
					if (pd.getName().equals(itemName))
						return true;	
				}
			}
		return false;
	}
	
	public void setFavorites() {
		ProductModel[] sampleItems = pc.getFullMenu();
		favouriteList.add(sampleItems[0]);
		favouriteList.add(sampleItems[1]);
	}

}

