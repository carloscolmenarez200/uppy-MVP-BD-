package com.developers.carlos.uppy;

/**
 * Created by carlos on 17/02/17.
 */

public interface OnItemClickListener<ItemClass> {
    void onItemClicked(int position, ItemClass item);
}
