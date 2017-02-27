package com.nilotpal.inventorymanager;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.nilotpal.inventorymanager.data.SaleContract.SaleEntry;

public class SaleCursorAdapter extends CursorAdapter {
    public SaleCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.quantity);

        // Find the columns of pet attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(SaleEntry.COLUMN_ITEM_NAME);
        int descriptionColumnIndex = cursor.getColumnIndex(SaleEntry.COLUMN_ITEM_QUANTITY);

        // Read the pet attributes from the Cursor for the current pet
        String itemName = cursor.getString(nameColumnIndex);
        String itemDescription = cursor.getString(descriptionColumnIndex);

        // If the pet breed is empty string or null, then use some default text
        // that says "Unknown breed", so the TextView isn't blank.
        if (TextUtils.isEmpty(itemDescription)) {
            itemDescription = context.getString(R.string.unknown_item);
        }

        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(itemName);
        summaryTextView.setText(itemDescription);
    }
}
