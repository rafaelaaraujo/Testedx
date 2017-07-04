package br.com.testedx.databinding;
import br.com.testedx.R;
import br.com.testedx.BR;
import android.view.View;
public class FragmentEditorderBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.recicle_edit_order, 8);
    }
    // views
    public final android.widget.Button btnCancel;
    public final android.widget.Button btnFinish;
    private final android.widget.LinearLayout mboundView0;
    public final android.widget.ImageView pictureEdit;
    public final android.support.v7.widget.RecyclerView recicleEditOrder;
    public final android.widget.TextView txtIngredients;
    public final android.widget.TextView txtPriceDiscounts;
    public final android.widget.TextView txtPriceEditOrder;
    public final android.widget.TextView txtTittle;
    // variables
    private br.com.testedx.editOrder.listener.OnClickIngredientListener mCallback;
    private java.lang.String mPrice;
    private java.lang.String mPriceDiscount;
    private java.lang.String mPromotion;
    private java.lang.String mIngredients;
    private br.com.testedx.model.Sandwich mSandwich;
    private final android.view.View.OnClickListener mCallback2;
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentEditorderBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.btnCancel = (android.widget.Button) bindings[6];
        this.btnCancel.setTag(null);
        this.btnFinish = (android.widget.Button) bindings[7];
        this.btnFinish.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.pictureEdit = (android.widget.ImageView) bindings[1];
        this.pictureEdit.setTag(null);
        this.recicleEditOrder = (android.support.v7.widget.RecyclerView) bindings[8];
        this.txtIngredients = (android.widget.TextView) bindings[3];
        this.txtIngredients.setTag(null);
        this.txtPriceDiscounts = (android.widget.TextView) bindings[5];
        this.txtPriceDiscounts.setTag(null);
        this.txtPriceEditOrder = (android.widget.TextView) bindings[4];
        this.txtPriceEditOrder.setTag(null);
        this.txtTittle = (android.widget.TextView) bindings[2];
        this.txtTittle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
            case BR.callback :
                setCallback((br.com.testedx.editOrder.listener.OnClickIngredientListener) variable);
                return true;
            case BR.price :
                setPrice((java.lang.String) variable);
                return true;
            case BR.priceDiscount :
                setPriceDiscount((java.lang.String) variable);
                return true;
            case BR.promotion :
                setPromotion((java.lang.String) variable);
                return true;
            case BR.ingredients :
                setIngredients((java.lang.String) variable);
                return true;
            case BR.sandwich :
                setSandwich((br.com.testedx.model.Sandwich) variable);
                return true;
        }
        return false;
    }

    public void setCallback(br.com.testedx.editOrder.listener.OnClickIngredientListener Callback) {
        this.mCallback = Callback;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.callback);
        super.requestRebind();
    }
    public br.com.testedx.editOrder.listener.OnClickIngredientListener getCallback() {
        return mCallback;
    }
    public void setPrice(java.lang.String Price) {
        this.mPrice = Price;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.price);
        super.requestRebind();
    }
    public java.lang.String getPrice() {
        return mPrice;
    }
    public void setPriceDiscount(java.lang.String PriceDiscount) {
        this.mPriceDiscount = PriceDiscount;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.priceDiscount);
        super.requestRebind();
    }
    public java.lang.String getPriceDiscount() {
        return mPriceDiscount;
    }
    public void setPromotion(java.lang.String Promotion) {
        this.mPromotion = Promotion;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.promotion);
        super.requestRebind();
    }
    public java.lang.String getPromotion() {
        return mPromotion;
    }
    public void setIngredients(java.lang.String Ingredients) {
        this.mIngredients = Ingredients;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.ingredients);
        super.requestRebind();
    }
    public java.lang.String getIngredients() {
        return mIngredients;
    }
    public void setSandwich(br.com.testedx.model.Sandwich Sandwich) {
        this.mSandwich = Sandwich;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.sandwich);
        super.requestRebind();
    }
    public br.com.testedx.model.Sandwich getSandwich() {
        return mSandwich;
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
        br.com.testedx.editOrder.listener.OnClickIngredientListener callback = mCallback;
        java.lang.String price = mPrice;
        java.lang.String priceDiscount = mPriceDiscount;
        java.lang.String promotion = mPromotion;
        boolean promotionJavaLangObjectNull = false;
        java.lang.String stringUtilFormatNumberToCurrentSandwichGetTotal = null;
        java.lang.String txtPriceDiscountsAndroidStringDiscountsValuePromotionPriceDiscount = null;
        java.lang.String ingredients = mIngredients;
        java.lang.String sandwichGetName = null;
        java.lang.String sandwichGetImage = null;
        double sandwichGetTotal = 0.0;
        int promotionJavaLangObjectNullViewVISIBLEViewGONE = 0;
        br.com.testedx.model.Sandwich sandwich = mSandwich;
        java.lang.String txtPriceEditOrderAndroidStringTotalValuePriceJavaLangObjectNullStringUtilFormatNumberToCurrentSandwichGetTotalPrice = null;
        boolean ingredientsJavaLangObjectNull = false;
        java.lang.String priceJavaLangObjectNullStringUtilFormatNumberToCurrentSandwichGetTotalPrice = null;
        boolean priceJavaLangObjectNull = false;
        java.lang.String sandwichGetIngredientsName = null;
        java.lang.String ingredientsJavaLangObjectNullSandwichGetIngredientsNameIngredients = null;

        if ((dirtyFlags & 0x62L) != 0) {



                // read price == null
                priceJavaLangObjectNull = (price) == (null);
            if((dirtyFlags & 0x62L) != 0) {
                if(priceJavaLangObjectNull) {
                        dirtyFlags |= 0x400L;
                }
                else {
                        dirtyFlags |= 0x200L;
                }
            }
        }
        if ((dirtyFlags & 0x4cL) != 0) {


            if ((dirtyFlags & 0x48L) != 0) {

                    // read promotion != null
                    promotionJavaLangObjectNull = (promotion) != (null);
                if((dirtyFlags & 0x48L) != 0) {
                    if(promotionJavaLangObjectNull) {
                            dirtyFlags |= 0x100L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                    }
                }


                    // read promotion != null ? View.VISIBLE : View.GONE
                    promotionJavaLangObjectNullViewVISIBLEViewGONE = ((promotionJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }

                // read @android:string/discounts_value
                txtPriceDiscountsAndroidStringDiscountsValuePromotionPriceDiscount = txtPriceDiscounts.getResources().getString(R.string.discounts_value, promotion, priceDiscount);
        }
        if ((dirtyFlags & 0x70L) != 0) {



                // read ingredients == null
                ingredientsJavaLangObjectNull = (ingredients) == (null);
            if((dirtyFlags & 0x70L) != 0) {
                if(ingredientsJavaLangObjectNull) {
                        dirtyFlags |= 0x1000L;
                }
                else {
                        dirtyFlags |= 0x800L;
                }
            }
        }
        if ((dirtyFlags & 0x60L) != 0) {



                if (sandwich != null) {
                    // read sandwich.getName()
                    sandwichGetName = sandwich.getName();
                    // read sandwich.getImage()
                    sandwichGetImage = sandwich.getImage();
                }
        }
        // batch finished

        if ((dirtyFlags & 0x1400L) != 0) {


            if ((dirtyFlags & 0x400L) != 0) {

                    if (sandwich != null) {
                        // read sandwich.getTotal()
                        sandwichGetTotal = sandwich.getTotal();
                    }


                    // read StringUtil.formatNumberToCurrent(sandwich.getTotal())
                    stringUtilFormatNumberToCurrentSandwichGetTotal = br.com.testedx.util.StringUtil.formatNumberToCurrent(sandwichGetTotal);
            }
            if ((dirtyFlags & 0x1000L) != 0) {

                    if (sandwich != null) {
                        // read sandwich.getIngredientsName()
                        sandwichGetIngredientsName = sandwich.getIngredientsName();
                    }
            }
        }

        if ((dirtyFlags & 0x62L) != 0) {

                // read price == null ? StringUtil.formatNumberToCurrent(sandwich.getTotal()) : price
                priceJavaLangObjectNullStringUtilFormatNumberToCurrentSandwichGetTotalPrice = ((priceJavaLangObjectNull) ? (stringUtilFormatNumberToCurrentSandwichGetTotal) : (price));


                // read @android:string/total_value
                txtPriceEditOrderAndroidStringTotalValuePriceJavaLangObjectNullStringUtilFormatNumberToCurrentSandwichGetTotalPrice = txtPriceEditOrder.getResources().getString(R.string.total_value, priceJavaLangObjectNullStringUtilFormatNumberToCurrentSandwichGetTotalPrice);
        }
        if ((dirtyFlags & 0x70L) != 0) {

                // read ingredients == null ? sandwich.getIngredientsName() : ingredients
                ingredientsJavaLangObjectNullSandwichGetIngredientsNameIngredients = ((ingredientsJavaLangObjectNull) ? (sandwichGetIngredientsName) : (ingredients));
        }
        // batch finished
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.btnCancel.setOnClickListener(mCallback1);
            this.btnFinish.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            br.com.testedx.editOrder.EditOrderDialogFragment.addImageSandwich(this.pictureEdit, sandwichGetImage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtTittle, sandwichGetName);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtIngredients, ingredientsJavaLangObjectNullSandwichGetIngredientsNameIngredients);
        }
        if ((dirtyFlags & 0x4cL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPriceDiscounts, txtPriceDiscountsAndroidStringDiscountsValuePromotionPriceDiscount);
        }
        if ((dirtyFlags & 0x48L) != 0) {
            // api target 1

            this.txtPriceDiscounts.setVisibility(promotionJavaLangObjectNullViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPriceEditOrder, txtPriceEditOrderAndroidStringTotalValuePriceJavaLangObjectNullStringUtilFormatNumberToCurrentSandwichGetTotalPrice);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // sandwich
                br.com.testedx.model.Sandwich sandwich = mSandwich;
                // callback
                br.com.testedx.editOrder.listener.OnClickIngredientListener callback = mCallback;
                // callback != null
                boolean callbackJavaLangObjectNull = false;



                callbackJavaLangObjectNull = (callback) != (null);
                if (callbackJavaLangObjectNull) {



                    callback.onFinishListener(sandwich);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // sandwich
                br.com.testedx.model.Sandwich sandwich = mSandwich;
                // callback
                br.com.testedx.editOrder.listener.OnClickIngredientListener callback = mCallback;
                // callback != null
                boolean callbackJavaLangObjectNull = false;



                callbackJavaLangObjectNull = (callback) != (null);
                if (callbackJavaLangObjectNull) {



                    callback.onCancelListener(sandwich);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static FragmentEditorderBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentEditorderBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentEditorderBinding>inflate(inflater, br.com.testedx.R.layout.fragment_editorder, root, attachToRoot, bindingComponent);
    }
    public static FragmentEditorderBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentEditorderBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(br.com.testedx.R.layout.fragment_editorder, null, false), bindingComponent);
    }
    public static FragmentEditorderBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentEditorderBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_editorder_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentEditorderBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): callback
        flag 1 (0x2L): price
        flag 2 (0x3L): priceDiscount
        flag 3 (0x4L): promotion
        flag 4 (0x5L): ingredients
        flag 5 (0x6L): sandwich
        flag 6 (0x7L): null
        flag 7 (0x8L): promotion != null ? View.VISIBLE : View.GONE
        flag 8 (0x9L): promotion != null ? View.VISIBLE : View.GONE
        flag 9 (0xaL): price == null ? StringUtil.formatNumberToCurrent(sandwich.getTotal()) : price
        flag 10 (0xbL): price == null ? StringUtil.formatNumberToCurrent(sandwich.getTotal()) : price
        flag 11 (0xcL): ingredients == null ? sandwich.getIngredientsName() : ingredients
        flag 12 (0xdL): ingredients == null ? sandwich.getIngredientsName() : ingredients
    flag mapping end*/
    //end
}