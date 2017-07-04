package br.com.testedx.databinding;
import br.com.testedx.R;
import br.com.testedx.BR;
import android.view.View;
public class SandwichItemBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.widget.Button btnAddCart;
    public final android.widget.Button btnCustomize;
    public final android.support.v7.widget.CardView cardView;
    public final android.widget.ImageView picture;
    public final android.widget.TextView txtIngredients;
    public final android.widget.TextView txtPriceDiscounts;
    public final android.widget.TextView txtPriceEdit;
    public final android.widget.TextView txtTittle;
    // variables
    private br.com.testedx.menu.listener.OnRecyclerViewClickListener mCallback;
    private br.com.testedx.model.Sandwich mSandwich;
    private final android.view.View.OnClickListener mCallback4;
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SandwichItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.btnAddCart = (android.widget.Button) bindings[6];
        this.btnAddCart.setTag("add");
        this.btnCustomize = (android.widget.Button) bindings[7];
        this.btnCustomize.setTag("edit");
        this.cardView = (android.support.v7.widget.CardView) bindings[0];
        this.cardView.setTag(null);
        this.picture = (android.widget.ImageView) bindings[1];
        this.picture.setTag(null);
        this.txtIngredients = (android.widget.TextView) bindings[3];
        this.txtIngredients.setTag(null);
        this.txtPriceDiscounts = (android.widget.TextView) bindings[5];
        this.txtPriceDiscounts.setTag(null);
        this.txtPriceEdit = (android.widget.TextView) bindings[4];
        this.txtPriceEdit.setTag(null);
        this.txtTittle = (android.widget.TextView) bindings[2];
        this.txtTittle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
                setCallback((br.com.testedx.menu.listener.OnRecyclerViewClickListener) variable);
                return true;
            case BR.sandwich :
                setSandwich((br.com.testedx.model.Sandwich) variable);
                return true;
        }
        return false;
    }

    public void setCallback(br.com.testedx.menu.listener.OnRecyclerViewClickListener Callback) {
        this.mCallback = Callback;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.callback);
        super.requestRebind();
    }
    public br.com.testedx.menu.listener.OnRecyclerViewClickListener getCallback() {
        return mCallback;
    }
    public void setSandwich(br.com.testedx.model.Sandwich Sandwich) {
        this.mSandwich = Sandwich;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
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
        double sandwichGetTotalWithDiscounts = 0.0;
        br.com.testedx.menu.listener.OnRecyclerViewClickListener callback = mCallback;
        boolean sandwichGetPromotionEnumPromotionEnumNONE = false;
        java.lang.String stringUtilFormatNumberToCurrentSandwichGetTotal = null;
        java.lang.String sandwichGetName = null;
        java.lang.String stringUtilFormatNumberToCurrentSandwichGetTotalWithDiscounts = null;
        java.lang.String sandwichGetImage = null;
        br.com.testedx.enums.PromotionEnum sandwichGetPromotionEnum = null;
        double sandwichGetTotal = 0.0;
        br.com.testedx.model.Sandwich sandwich = mSandwich;
        java.lang.String sandwichGetPromotionEnumToString = null;
        int sandwichGetPromotionEnumPromotionEnumNONEViewGONEViewVISIBLE = 0;
        java.lang.String txtPriceDiscountsAndroidStringDiscountsValueSandwichGetPromotionEnumToStringStringUtilFormatNumberToCurrentSandwichGetTotalWithDiscounts = null;
        java.lang.String sandwichGetIngredientsName = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (sandwich != null) {
                    // read sandwich.getTotalWithDiscounts()
                    sandwichGetTotalWithDiscounts = sandwich.getTotalWithDiscounts();
                    // read sandwich.getName()
                    sandwichGetName = sandwich.getName();
                    // read sandwich.getImage()
                    sandwichGetImage = sandwich.getImage();
                    // read sandwich.getPromotionEnum()
                    sandwichGetPromotionEnum = sandwich.getPromotionEnum();
                    // read sandwich.getTotal()
                    sandwichGetTotal = sandwich.getTotal();
                    // read sandwich.getIngredientsName()
                    sandwichGetIngredientsName = sandwich.getIngredientsName();
                }


                // read StringUtil.formatNumberToCurrent(sandwich.getTotalWithDiscounts())
                stringUtilFormatNumberToCurrentSandwichGetTotalWithDiscounts = br.com.testedx.util.StringUtil.formatNumberToCurrent(sandwichGetTotalWithDiscounts);
                // read sandwich.getPromotionEnum() == PromotionEnum.NONE
                sandwichGetPromotionEnumPromotionEnumNONE = (sandwichGetPromotionEnum) == (br.com.testedx.enums.PromotionEnum.NONE);
                // read StringUtil.formatNumberToCurrent(sandwich.getTotal())
                stringUtilFormatNumberToCurrentSandwichGetTotal = br.com.testedx.util.StringUtil.formatNumberToCurrent(sandwichGetTotal);
            if((dirtyFlags & 0x6L) != 0) {
                if(sandwichGetPromotionEnumPromotionEnumNONE) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
                if (sandwichGetPromotionEnum != null) {
                    // read sandwich.getPromotionEnum().toString()
                    sandwichGetPromotionEnumToString = sandwichGetPromotionEnum.toString();
                }


                // read sandwich.getPromotionEnum() == PromotionEnum.NONE ? View.GONE : View.VISIBLE
                sandwichGetPromotionEnumPromotionEnumNONEViewGONEViewVISIBLE = ((sandwichGetPromotionEnumPromotionEnumNONE) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read @android:string/discounts_value
                txtPriceDiscountsAndroidStringDiscountsValueSandwichGetPromotionEnumToStringStringUtilFormatNumberToCurrentSandwichGetTotalWithDiscounts = txtPriceDiscounts.getResources().getString(R.string.discounts_value, sandwichGetPromotionEnumToString, stringUtilFormatNumberToCurrentSandwichGetTotalWithDiscounts);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnAddCart.setOnClickListener(mCallback3);
            this.btnCustomize.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            br.com.testedx.menu.MenuAdapter.addImageMenu(this.picture, sandwichGetImage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtIngredients, sandwichGetIngredientsName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPriceDiscounts, txtPriceDiscountsAndroidStringDiscountsValueSandwichGetPromotionEnumToStringStringUtilFormatNumberToCurrentSandwichGetTotalWithDiscounts);
            this.txtPriceDiscounts.setVisibility(sandwichGetPromotionEnumPromotionEnumNONEViewGONEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPriceEdit, stringUtilFormatNumberToCurrentSandwichGetTotal);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtTittle, sandwichGetName);
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
                br.com.testedx.menu.listener.OnRecyclerViewClickListener callback = mCallback;
                // callback != null
                boolean callbackJavaLangObjectNull = false;



                callbackJavaLangObjectNull = (callback) != (null);
                if (callbackJavaLangObjectNull) {



                    callback.editOrder(sandwich);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // sandwich
                br.com.testedx.model.Sandwich sandwich = mSandwich;
                // callback
                br.com.testedx.menu.listener.OnRecyclerViewClickListener callback = mCallback;
                // callback != null
                boolean callbackJavaLangObjectNull = false;



                callbackJavaLangObjectNull = (callback) != (null);
                if (callbackJavaLangObjectNull) {



                    callback.addCart(sandwich);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static SandwichItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static SandwichItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<SandwichItemBinding>inflate(inflater, br.com.testedx.R.layout.sandwich_item, root, attachToRoot, bindingComponent);
    }
    public static SandwichItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static SandwichItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(br.com.testedx.R.layout.sandwich_item, null, false), bindingComponent);
    }
    public static SandwichItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static SandwichItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/sandwich_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new SandwichItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): callback
        flag 1 (0x2L): sandwich
        flag 2 (0x3L): null
        flag 3 (0x4L): sandwich.getPromotionEnum() == PromotionEnum.NONE ? View.GONE : View.VISIBLE
        flag 4 (0x5L): sandwich.getPromotionEnum() == PromotionEnum.NONE ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}