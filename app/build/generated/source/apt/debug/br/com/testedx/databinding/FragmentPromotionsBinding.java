package br.com.testedx.databinding;
import br.com.testedx.R;
import br.com.testedx.BR;
import android.view.View;
public class FragmentPromotionsBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.support.v7.widget.CardView cardView;
    public final android.widget.TextView content;
    public final android.widget.TextView id;
    // variables
    private br.com.testedx.promotion.model.Promotion mPromotion;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentPromotionsBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.cardView = (android.support.v7.widget.CardView) bindings[0];
        this.cardView.setTag(null);
        this.content = (android.widget.TextView) bindings[2];
        this.content.setTag(null);
        this.id = (android.widget.TextView) bindings[1];
        this.id.setTag(null);
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
            case BR.promotion :
                setPromotion((br.com.testedx.promotion.model.Promotion) variable);
                return true;
        }
        return false;
    }

    public void setPromotion(br.com.testedx.promotion.model.Promotion Promotion) {
        this.mPromotion = Promotion;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.promotion);
        super.requestRebind();
    }
    public br.com.testedx.promotion.model.Promotion getPromotion() {
        return mPromotion;
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
        br.com.testedx.promotion.model.Promotion promotion = mPromotion;
        java.lang.String promotionGetName = null;
        java.lang.String promotionGetDescription = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (promotion != null) {
                    // read promotion.getName()
                    promotionGetName = promotion.getName();
                    // read promotion.getDescription()
                    promotionGetDescription = promotion.getDescription();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.content, promotionGetDescription);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.id, promotionGetName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static FragmentPromotionsBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentPromotionsBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentPromotionsBinding>inflate(inflater, br.com.testedx.R.layout.fragment_promotions, root, attachToRoot, bindingComponent);
    }
    public static FragmentPromotionsBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentPromotionsBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(br.com.testedx.R.layout.fragment_promotions, null, false), bindingComponent);
    }
    public static FragmentPromotionsBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentPromotionsBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_promotions_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentPromotionsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): promotion
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}