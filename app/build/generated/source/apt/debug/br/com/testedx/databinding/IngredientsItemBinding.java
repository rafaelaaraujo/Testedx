package br.com.testedx.databinding;
import br.com.testedx.R;
import br.com.testedx.BR;
import android.view.View;
public class IngredientsItemBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btn_minus, 4);
        sViewsWithIds.put(R.id.btn_plus, 5);
    }
    // views
    public final android.widget.Button btnMinus;
    public final android.widget.Button btnPlus;
    private final android.widget.LinearLayout mboundView0;
    public final android.widget.ImageView pictureIngredient;
    public final android.widget.TextView txtIngredient;
    public final android.widget.TextView txtItemName;
    // variables
    private br.com.testedx.model.Ingredient mIngredient;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public IngredientsItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btnMinus = (android.widget.Button) bindings[4];
        this.btnPlus = (android.widget.Button) bindings[5];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.pictureIngredient = (android.widget.ImageView) bindings[3];
        this.pictureIngredient.setTag(null);
        this.txtIngredient = (android.widget.TextView) bindings[1];
        this.txtIngredient.setTag(null);
        this.txtItemName = (android.widget.TextView) bindings[2];
        this.txtItemName.setTag(null);
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
            case BR.ingredient :
                setIngredient((br.com.testedx.model.Ingredient) variable);
                return true;
        }
        return false;
    }

    public void setIngredient(br.com.testedx.model.Ingredient Ingredient) {
        this.mIngredient = Ingredient;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.ingredient);
        super.requestRebind();
    }
    public br.com.testedx.model.Ingredient getIngredient() {
        return mIngredient;
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
        java.lang.String ingredientGetImage = null;
        br.com.testedx.model.Ingredient ingredient = mIngredient;
        java.lang.String ingredientGetName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (ingredient != null) {
                    // read ingredient.getImage()
                    ingredientGetImage = ingredient.getImage();
                    // read ingredient.getName()
                    ingredientGetName = ingredient.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            br.com.testedx.editOrder.EditOrderAdapter.addImageIngrediente(this.pictureIngredient, ingredientGetImage);
            br.com.testedx.editOrder.EditOrderAdapter.getQuantity(this.txtIngredient, ingredient);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtItemName, ingredientGetName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static IngredientsItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static IngredientsItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<IngredientsItemBinding>inflate(inflater, br.com.testedx.R.layout.ingredients_item, root, attachToRoot, bindingComponent);
    }
    public static IngredientsItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static IngredientsItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(br.com.testedx.R.layout.ingredients_item, null, false), bindingComponent);
    }
    public static IngredientsItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static IngredientsItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/ingredients_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new IngredientsItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): ingredient
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}