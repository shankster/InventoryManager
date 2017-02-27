package com.nilotpal.inventorymanager.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class SaleContract {
    private SaleContract(){}

    public static final String CONTENT_AUTHORITY="com.nilotpal.inventorymanager";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);
    public static final String PATH_SALE="sale";

    public static final class SaleEntry implements BaseColumns{
        public final static String TABLE_NAME = "sale";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI,PATH_SALE);
        public static final String CONTENT_LIST_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SALE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SALE;

        public final static String _ID = BaseColumns._ID;
        public final static String  COLUMN_ITEM_NAME="name";
        public final static String COLUMN_ITEM_DESCRIPTION="description";
        public final static String COLUMN_ITEM_IN_STOCK="instock";
        public static String COLUMN_ITEM_QUANTITY="quantity";

        public final static int IN_STOCK=1;
        public final static int NOT_IN_STOCK=0;

        public static boolean isValidStock(int instock){
            if(instock==IN_STOCK || instock==NOT_IN_STOCK){
                return true;
            }
            return false;
        }


    }
}
