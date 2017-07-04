
package android.databinding;
import br.com.testedx.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 24;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case br.com.testedx.R.layout.fragment_editorder:
                    return br.com.testedx.databinding.FragmentEditorderBinding.bind(view, bindingComponent);
                case br.com.testedx.R.layout.ingredients_item:
                    return br.com.testedx.databinding.IngredientsItemBinding.bind(view, bindingComponent);
                case br.com.testedx.R.layout.shopping_cart_item:
                    return br.com.testedx.databinding.ShoppingCartItemBinding.bind(view, bindingComponent);
                case br.com.testedx.R.layout.sandwich_item:
                    return br.com.testedx.databinding.SandwichItemBinding.bind(view, bindingComponent);
                case br.com.testedx.R.layout.fragment_promotions:
                    return br.com.testedx.databinding.FragmentPromotionsBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -575313781: {
                if(tag.equals("layout/fragment_editorder_0")) {
                    return br.com.testedx.R.layout.fragment_editorder;
                }
                break;
            }
            case -2016377050: {
                if(tag.equals("layout/ingredients_item_0")) {
                    return br.com.testedx.R.layout.ingredients_item;
                }
                break;
            }
            case -258419343: {
                if(tag.equals("layout/shopping_cart_item_0")) {
                    return br.com.testedx.R.layout.shopping_cart_item;
                }
                break;
            }
            case -1174054749: {
                if(tag.equals("layout/sandwich_item_0")) {
                    return br.com.testedx.R.layout.sandwich_item;
                }
                break;
            }
            case 1893024843: {
                if(tag.equals("layout/fragment_promotions_0")) {
                    return br.com.testedx.R.layout.fragment_promotions;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"callback"
            ,"ingredient"
            ,"ingredients"
            ,"order"
            ,"price"
            ,"priceDiscount"
            ,"promotion"
            ,"s"
            ,"sandwich"};
    }
}