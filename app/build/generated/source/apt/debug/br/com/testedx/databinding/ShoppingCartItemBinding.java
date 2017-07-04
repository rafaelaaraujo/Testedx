package br.com.testedx.databinding;
import br.com.testedx.R;
import br.com.testedx.BR;
import android.view.View;
public class ShoppingCartItemBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.support.v7.widget.CardView cardView;
    public final android.widget.ImageView picture;
    public final android.widget.ProgressBar progress;
    public final android.widget.LinearLayout root;
    public final android.widget.TextView txtIngredients;
    public final android.widget.TextView txtPriceDiscounts;
    public final android.widget.TextView txtSubtotal;
    public final android.widget.TextView txtTittle;
    // variables
    private br.com.testedx.model.Sandwich mS;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ShoppingCartItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.cardView = (android.support.v7.widget.CardView) bindings[0];
        this.cardView.setTag(null);
        this.picture = (android.widget.ImageView) bindings[3];
        this.picture.setTag(null);
        this.progress = (android.widget.ProgressBar) bindings[1];
        this.progress.setTag(null);
        this.root = (android.widget.LinearLayout) bindings[2];
        this.root.setTag(null);
        this.txtIngredients = (android.widget.TextView) bindings[5];
        this.txtIngredients.setTag(null);
        this.txtPriceDiscounts = (android.widget.TextView) bindings[7];
        this.txtPriceDiscounts.setTag(null);
        this.txtSubtotal = (android.widget.TextView) bindings[6];
        this.txtSubtotal.setTag(null);
        this.txtTittle = (android.widget.TextView) bindings[4];
        this.txtTittle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.s :
                setS((br.com.testedx.model.Sandwich) variable);
                return true;
        }
        return false;
    }

    public void setS(br.com.testedx.model.Sandwich S) {
        this.mS = S;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.s);
        super.requestRebind();
    }
    public br.com.testedx.model.Sandwich getS() {
        return mS;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String sGetIngredientsName = null;
        double sGetTotalWithDiscounts = 0.0;
        boolean sJavaLangObjectNull = false;
        br.com.testedx.model.Sandwich s = mS;
        java.lang.String sGetName = null;
        java.lang.String txtPriceDiscountsAndroidStringDiscountsValueSGetPromotionEnumToStringStringUtilFormatNumberToCurrentSGetTotalWithDiscounts = null;
        java.lang.String txtSubtotalAndroidStringSubtotalValueStringUtilFormatNumberToCurrentSGetTotal = null;
        int sJavaLangObjectNullViewVISIBLEViewGONE = 0;
        java.lang.String stringUtilFormatNumberToCurrentSGetTotal = null;
        int sGetPromotionEnumPromotionEnumNONEViewGONEViewVISIBLE = 0;
        java.lang.String stringUtilFormatNumberToCurrentSGetTotalWithDiscounts = null;
        java.lang.String sGetPromotionEnumToString = null;
        java.lang.String sGetImage = null;
        br.com.testedx.enums.PromotionEnum sGetPromotionEnum = null;
        boolean sGetPromotionEnumPromotionEnumNONE = false;
        double sGetTotal = 0.0;
        int sJavaLangObjectNullViewINVISIBLEViewVISIBLE = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (s != null) {
                    // read s.getIngredientsName()
                    sGetIngredientsName = s.getIngredientsName();
                    // read s.getTotalWithDiscounts()
                    sGetTotalWithDiscounts = s.getTotalWithDiscounts();
                    // read s.getName()
                    sGetName = s.getName();
                    // read s.getImage()
                    sGetImage = s.getImage();
                    // read s.getPromotionEnum()
                    sGetPromotionEnum = s.getPromotionEnum();
                    // read s.getTotal()
                    sGetTotal = s.getTotal();
                }
                // read s == null
                sJavaLangObjectNull = (s) == (null);
            if((dirtyFlags & 0x3L) != 0) {
                if(sJavaLangObjectNull) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x40L;
                }
            }


                // read StringUtil.formatNumberToCurrent(s.getTotalWithDiscounts())
                stringUtilFormatNumberToCurrentSGetTotalWithDiscounts = br.com.testedx.util.StringUtil.formatNumberToCurrent(sGetTotalWithDiscounts);
                // read s.getPromotionEnum() == PromotionEnum.NONE
                sGetPromotionEnumPromotionEnumNONE = (sGetPromotionEnum) == (br.com.testedx.enums.PromotionEnum.NONE);
                // read StringUtil.formatNumberToCurrent(s.getTotal())
                stringUtilFormatNumberToCurrentSGetTotal = br.com.testedx.util.StringUtil.formatNumberToCurrent(sGetTotal);
                // read s == null ? View.VISIBLE : View.GONE
                sJavaLangObjectNullViewVISIBLEViewGONE = ((sJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read s == null ? View.INVISIBLE : View.VISIBLE
                sJavaLangObjectNullViewINVISIBLEViewVISIBLE = ((sJavaLangObjectNull) ? (android.view.View.INVISIBLE) : (android.view.View.VISIBLE));
            if((dirtyFlags & 0x3L) != 0) {
                if(sGetPromotionEnumPromotionEnumNONE) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
                if (sGetPromotionEnum != null) {
                    // read s.getPromotionEnum().toString()
                    sGetPromotionEnumToString = sGetPromotionEnum.toString();
                }


                // read s.getPromotionEnum() == PromotionEnum.NONE ? View.GONE : View.VISIBLE
                sGetPromotionEnumPromotionEnumNONEViewGONEViewVISIBLE = ((sGetPromotionEnumPromotionEnumNONE) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read @android:string/subtotal_value
                txtSubtotalAndroidStringSubtotalValueStringUtilFormatNumberToCurrentSGetTotal = txtSubtotal.getResources().getString(R.string.subtotal_value, stringUtilFormatNumberToCurrentSGetTotal);
                // read @android:string/discounts_value
                txtPriceDiscountsAndroidStringDiscountsValueSGetPromotionEnumToStringStringUtilFormatNumberToCurrentSGetTotalWithDiscounts = txtPriceDiscounts.getResources().getString(R.string.discounts_value, sGetPromotionEnumToString, stringUtilFormatNumberToCurrentSGetTotalWithDiscounts);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            br.com.testedx.shoppingCart.ShoppingCartAdapter.addImage(this.picture, sGetImage);
            this.progress.setVisibility(sJavaLangObjectNullViewVISIBLEViewGONE);
            this.root.setVisibility(sJavaLangObjectNullViewINVISIBLEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtIngredients, sGetIngredientsName);
            this.txtPriceDiscounts.setVisibility(sGetPromotionEnumPromotionEnumNONEViewGONEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPriceDiscounts, txtPriceDiscountsAndroidStringDiscountsValueSGetPromotionEnumToStringStringUtilFormatNumberToCurrentSGetTotalWithDiscounts);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtSubtotal, txtSubtotalAndroidStringSubtotalValueStringUtilFormatNumberToCurrentSGetTotal);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtTittle, sGetName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ShoppingCartItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ShoppingCartItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ShoppingCartItemBinding>inflate(inflater, br.com.testedx.R.layout.shopping_cart_item, root, attachToRoot, bindingComponent);
    }
    public static ShoppingCartItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ShoppingCartItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(br.com.testedx.R.layout.shopping_cart_item, null, false), bindingComponent);
    }
    public static ShoppingCartItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ShoppingCartItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/shopping_cart_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ShoppingCartItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): s
        flag 1 (0x2L): null
        flag 2 (0x3L): s == null ? View.VISIBLE : View.GONE
        flag 3 (0x4L): s == null ? View.VISIBLE : View.GONE
        flag 4 (0x5L): s.getPromotionEnum() == PromotionEnum.NONE ? View.GONE : View.VISIBLE
        flag 5 (0x6L): s.getPromotionEnum() == PromotionEnum.NONE ? View.GONE : View.VISIBLE
        flag 6 (0x7L): s == null ? View.INVISIBLE : View.VISIBLE
        flag 7 (0x8L): s == null ? View.INVISIBLE : View.VISIBLE
    flag mapping end*/
    //end
}